package com.mango.api.controller;

import com.mango.api.model.Artifact;
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

@Tag(name = "Artifact", description = "The Artifact API")
@RequestMapping("/api/artifacts")
public interface ArtifactApi {

  @Operation(summary = "Find Artifact by ID", description = "Returns a single artifact", tags = { "artifact" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Artifact.class))),
      @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
      @ApiResponse(responseCode = "404", description = "artifact not found", content = @Content) })
  @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Artifact> findById(
      @Parameter(description = "ID of Artifact", required = true)
      @PathVariable UUID id
      )
      throws Exception;

  @Operation(summary = "Get Artifact", description = "Returns a Artifact collection", tags = { "kind" })
  @GetMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public Collection<Artifact> findArtifacts();

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Artifact updateArtifact(@PathVariable("id") final UUID id, @RequestBody final Artifact label);

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Artifact patchArtifact(@PathVariable("id") final UUID id, @RequestBody final Artifact label);

  @Operation(summary = "Create Artifact", description = "", tags = { "artifact" })
  @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Artifact.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = Artifact.class)) }) })
  @PostMapping(value = "/", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Artifact> postArtifact(
      @NotNull
      @Parameter(description = "Created Artifact object", required = true)
      @Valid @RequestBody Artifact body
  )
      throws Exception;

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public Artifact headArtifact();

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UUID deleteArtifact(@PathVariable final UUID id);
}
