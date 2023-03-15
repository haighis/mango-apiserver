package com.mango.appsapi.controller;

import com.mango.appsapi.model.ApplicationInstall;
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

@Tag(name = "applicationInstall", description = "the Application Install API")
@RequestMapping("/api/applicationinstalls")
public interface ApplicationInstallApi {

  @Operation(summary = "Find applicationInstall by ID", description = "Returns a single applicationInstall", tags = { "book" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ApplicationInstall.class))),
      @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
      @ApiResponse(responseCode = "404", description = "ApplicationInstall not found", content = @Content) })
  @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ApplicationInstall> findById(
      @Parameter(description = "ID of Application Install", required = true)
      @PathVariable long id
//      @NotNull @Parameter(description = "select which kind of data to fetch", required = true)
//      @Valid @RequestHeader(value="bookAuthorization", required = true) String bookAuthorization
      )
      throws Exception;

  @Operation(summary = "Get Application Install", description = "Returns a Application Install collection", tags = { "book" })
  @GetMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public Collection<ApplicationInstall> findApplicationInstalls();

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationInstall updateApplicationInstall(@PathVariable("id") final String id, @RequestBody final ApplicationInstall book);

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationInstall patchApplicationInstall(@PathVariable("id") final String id, @RequestBody final ApplicationInstall book);

  @Operation(summary = "Create Application Install", description = "", tags = { "book" })
  @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationInstall.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = ApplicationInstall.class)) }) })
  @PostMapping(value = "/", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ApplicationInstall> postApplicationInstall(
      @NotNull
      @Parameter(description = "Created Application Install object", required = true)
      @Valid @RequestBody ApplicationInstall body //,
      //@NotNull @Parameter(description = "select which kind of data to fetch", required = true)
  //    @Valid @RequestHeader(value="bookAuthorization", required = true) String bookAuthorization
  )
      throws Exception;

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationInstall headApplicationInstall();

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public long deleteApplicationInstall(@PathVariable final long id);

}
