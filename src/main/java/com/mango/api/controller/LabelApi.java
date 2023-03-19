package com.mango.api.controller;

import com.mango.api.model.Label;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.UUID;

@Tag(name = "Label", description = "The Label API")
@RequestMapping("/api/labels")
public interface LabelApi {

  @Operation(summary = "Find label by ID", description = "Returns a single label", tags = { "label" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Label.class))),
      @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
      @ApiResponse(responseCode = "404", description = "label not found", content = @Content) })
  @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Label> findById(
      @Parameter(description = "ID of Label", required = true)
      @PathVariable UUID id
//      @NotNull @Parameter(description = "select which kind of data to fetch", required = true)
//      @Valid @RequestHeader(value="bookAuthorization", required = true) String bookAuthorization
      )
      throws Exception;

  @Operation(summary = "Get Label", description = "Returns a Label collection", tags = { "label" })
  @GetMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public Collection<Label> findLabels();

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Label updateLabel(@PathVariable("id") final UUID id, @RequestBody final Label label);

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Label patchLabel(@PathVariable("id") final UUID id, @RequestBody final Label label);

  @Operation(summary = "Create Label", description = "", tags = { "label" })
  @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Label.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = Label.class)) }) })
  @PostMapping(value = "/", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Label> postLabel(
      @NotNull
      @Parameter(description = "Created Label object", required = true)
      @Valid @RequestBody Label body //,
      //@NotNull @Parameter(description = "select which kind of data to fetch", required = true)
  //    @Valid @RequestHeader(value="bookAuthorization", required = true) String bookAuthorization
  )
      throws Exception;

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public Label headLabel();

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UUID deleteLabel(@PathVariable final UUID id);
}
