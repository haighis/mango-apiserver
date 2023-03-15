package com.mango.appsapi.controller;

import com.mango.appsapi.model.ApplicationInstall;
import com.mango.appsapi.model.ApplicationShell;
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

@Tag(name = "applicationShell", description = "The Application Shell API")
@RequestMapping("/api/applicationshells")
public interface ApplicationShellApi {

  @Operation(summary = "Find application shell by ID", description = "Returns a single applicationShell", tags = { "applicationShell" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ApplicationInstall.class))),
      @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
      @ApiResponse(responseCode = "404", description = "ApplicationShell not found", content = @Content) })
  @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ApplicationShell> findById(
      @Parameter(description = "ID of Application Shell", required = true)
      @PathVariable long id
//      @NotNull @Parameter(description = "select which kind of data to fetch", required = true)
//      @Valid @RequestHeader(value="bookAuthorization", required = true) String bookAuthorization
      )
      throws Exception;

  @Operation(summary = "Get Application Shell", description = "Returns a Application Shell collection", tags = { "applicationShell" })
  @GetMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public Collection<ApplicationShell> findApplicationShells();

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationShell updateApplicationShell(@PathVariable("id") final String id, @RequestBody final ApplicationShell book);

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationShell patchApplicationShell(@PathVariable("id") final String id, @RequestBody final ApplicationShell book);

  @Operation(summary = "Create Application Shell", description = "", tags = { "book" })
  @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationShell.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = ApplicationShell.class)) }) })
  @PostMapping(value = "/", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ApplicationShell> postApplicationShell(
      @NotNull
      @Parameter(description = "Created Application Shell object", required = true)
      @Valid @RequestBody ApplicationShell body //,
      //@NotNull @Parameter(description = "select which kind of data to fetch", required = true)
  //    @Valid @RequestHeader(value="bookAuthorization", required = true) String bookAuthorization
  )
      throws Exception;

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationShell headApplicationShell();

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public long deleteApplicationShell(@PathVariable final long id);

}
