package com.mango.api.controller;

import com.mango.api.model.Label;
import com.mango.api.model.Setup;
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

@Tag(name = "Setup", description = "The Setup API")
@RequestMapping("/api/setup")
public interface SetupApi {
  @Operation(summary = "Setup Mango Platform", description = "", tags = { "setup" })
  @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Label.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = Label.class)) }) })
  @PostMapping(value = "/", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Label> postSetup(
      @NotNull
      @Parameter(description = "Setup object", required = true)
      @Valid @RequestBody Label body
  )
      throws Exception;
}
