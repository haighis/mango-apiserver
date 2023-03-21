package com.mango.api.controller;

import com.mango.api.model.ShellType;
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

@Tag(name = "Shell Type", description = "The ShellType API")
@RequestMapping("/api/shelltypes")
public interface ShellTypeApi {

  @Operation(summary = "Find shell type by ID", description = "Returns a single shell type", tags = { "label" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ShellType.class))),
      @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
      @ApiResponse(responseCode = "404", description = "shell type not found", content = @Content) })
  @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ShellType> findById(
      @Parameter(description = "ID of ShellType", required = true)
      @PathVariable UUID id
      )
      throws Exception;

  @Operation(summary = "Get Shell Type", description = "Returns a Shell Type collection", tags = { "label" })
  @GetMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public Collection<ShellType> findShellTypes();

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ShellType updateShellType(@PathVariable("id") final UUID id, @RequestBody final ShellType shellType);

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ShellType patchShellType(@PathVariable("id") final UUID id, @RequestBody final ShellType shellType);

  @Operation(summary = "Create ShellType", description = "", tags = { "label" })
  @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ShellType.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = ShellType.class)) }) })
  @PostMapping(value = "/", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ShellType> postShellType(
      @NotNull
      @Parameter(description = "Created ShellType object", required = true)
      @Valid @RequestBody ShellType body
  )
      throws Exception;

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public ShellType headShellType();

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UUID deleteShellType(@PathVariable final UUID id);
}
