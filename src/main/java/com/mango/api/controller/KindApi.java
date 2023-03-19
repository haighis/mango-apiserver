package com.mango.api.controller;

import com.mango.api.model.Kind;
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

@Tag(name = "Kind", description = "The Kind API")
@RequestMapping("/api/kinds")
public interface KindApi {

  @Operation(summary = "Find Kind by ID", description = "Returns a single kind", tags = { "kind" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Kind.class))),
      @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
      @ApiResponse(responseCode = "404", description = "kind not found", content = @Content) })
  @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Kind> findById(
      @Parameter(description = "ID of Kind", required = true)
      @PathVariable UUID id
      )
      throws Exception;

  @Operation(summary = "Get Kind", description = "Returns a Kind collection", tags = { "kind" })
  @GetMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public Collection<Kind> findKinds();

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Kind updateKind(@PathVariable("id") final UUID id, @RequestBody final Kind label);

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Kind patchKind(@PathVariable("id") final UUID id, @RequestBody final Kind label);

  @Operation(summary = "Create Kind", description = "", tags = { "kind" })
  @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Kind.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = Kind.class)) }) })
  @PostMapping(value = "/", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Kind> postKind(
      @NotNull
      @Parameter(description = "Created Kind object", required = true)
      @Valid @RequestBody Kind body
  )
      throws Exception;

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public Kind headKind();

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UUID deleteKind(@PathVariable final UUID id);
}
