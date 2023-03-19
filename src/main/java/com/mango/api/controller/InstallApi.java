package com.mango.api.controller;

import com.mango.api.model.Install;
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

@Tag(name = "Install", description = "the Install audit API")
@RequestMapping("/api/installs")
public interface InstallApi {

  @Operation(summary = "Find Install by ID", description = "Returns a single Install", tags = { "install" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Install.class))),
      @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
      @ApiResponse(responseCode = "404", description = "Install not found", content = @Content) })
  @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Install> findById(
      @Parameter(description = "ID of Install", required = true)
      @PathVariable UUID id
//      @NotNull @Parameter(description = "select which kind of data to fetch", required = true)
//      @Valid @RequestHeader(value="bookAuthorization", required = true) String bookAuthorization
      )
      throws Exception;

  @Operation(summary = "Get Install", description = "Returns a Install collection", tags = { "book" })
  @GetMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public Collection<Install> findApplicationInstalls();

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Install updateApplicationInstall(@PathVariable("id") final UUID id, @RequestBody final Install book);

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Install patchApplicationInstall(@PathVariable("id") final UUID id, @RequestBody final Install book);

  @Operation(summary = "Create Install", description = "", tags = { "applicationinstall" })
  @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Install.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = Install.class)) }) })
  @PostMapping(value = "/", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Install> postApplicationInstall(
          @NotNull
      @Parameter(description = "Created Install object", required = true)
      @Valid @RequestBody Install body //,
          //@NotNull @Parameter(description = "select which kind of data to fetch", required = true)
          //    @Valid @RequestHeader(value="bookAuthorization", required = true) String bookAuthorization
  )
      throws Exception;

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public Install headApplicationInstall();

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UUID deleteApplicationInstall(@PathVariable final UUID id);

}
