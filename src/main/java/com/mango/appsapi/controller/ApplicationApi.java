package com.mango.appsapi.controller;

import com.mango.appsapi.model.Application;
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

@Tag(name = "application", description = "The Application API")
@RequestMapping("/api/applications")
public interface ApplicationApi {

  @Operation(summary = "Find application by ID", description = "Returns a single application", tags = { "application" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Application.class))),
      @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
      @ApiResponse(responseCode = "404", description = "ApplicationShell not found", content = @Content) })
  @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Application> findById(
      @Parameter(description = "ID of Application", required = true)
      @PathVariable long id
//      @NotNull @Parameter(description = "select which kind of data to fetch", required = true)
//      @Valid @RequestHeader(value="bookAuthorization", required = true) String bookAuthorization
      )
      throws Exception;

  @Operation(summary = "Get Application", description = "Returns a Application collection", tags = { "application" })
  @GetMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public Collection<Application> findApplications();

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Application updateApplication(@PathVariable("id") final String id, @RequestBody final Application book);

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Application patchApplication(@PathVariable("id") final String id, @RequestBody final Application book);

  @Operation(summary = "Create Application", description = "", tags = { "application" })
  @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Application.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = Application.class)) }) })
  @PostMapping(value = "/", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Application> postApplication(
      @NotNull
      @Parameter(description = "Created Application object", required = true)
      @Valid @RequestBody Application body //,
      //@NotNull @Parameter(description = "select which kind of data to fetch", required = true)
  //    @Valid @RequestHeader(value="bookAuthorization", required = true) String bookAuthorization
  )
      throws Exception;

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public Application headApplication();

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public long deleteApplication(@PathVariable final long id);

}
