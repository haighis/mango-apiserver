package com.mango.api.controller;

import com.mango.api.model.Item;
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

@Tag(name = "Item", description = "The Item API")
@RequestMapping("/api/items")
public interface ItemApi {

  @Operation(summary = "Find Item by ID", description = "Returns a single item", tags = { "item" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Item.class))),
      @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
      @ApiResponse(responseCode = "404", description = "item not found", content = @Content) })
  @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Item> findById(
      @Parameter(description = "ID of Item", required = true)
      @PathVariable UUID id
      )
      throws Exception;

  @Operation(summary = "Get Item", description = "Returns a Item collection", tags = { "item" })
  @GetMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public Collection<Item> findItems();

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Item updateItem(@PathVariable("id") final UUID id, @RequestBody final Item label);

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Item patchItem(@PathVariable("id") final UUID id, @RequestBody final Item label);

  @Operation(summary = "Create Item", description = "", tags = { "item" })
  @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Item.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = Item.class)) }) })
  @PostMapping(value = "/", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Item> postItem(
      @NotNull
      @Parameter(description = "Created Item object", required = true)
      @Valid @RequestBody Item body
  )
      throws Exception;

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public Item headItem();

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UUID deleteItem(@PathVariable final UUID id);
}
