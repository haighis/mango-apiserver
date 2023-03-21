package com.mango.api.controller;

import com.mango.api.exception.EntityNotFoundException;
import com.mango.api.model.Item;
import com.mango.api.model.Kind;
import com.mango.api.respository.ItemRepository;
import com.mango.api.respository.KindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
public class ItemApiController implements ItemApi {

  @Autowired
  private ItemRepository repository;

  @Override
  public ResponseEntity<Item> findById(
          UUID id
  ) throws Exception {

    Item book = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Item not found for this id :: " + id));

    return ResponseEntity.ok().body(book);
  }

  @Override
  public Collection<Item> findItems() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Item updateItem(@PathVariable("id") final UUID id, @RequestBody final Item label) {
    return label;
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Item patchItem(@PathVariable("id") final UUID id, @RequestBody final Item book) {
    return book;
  }

  @Override
  public ResponseEntity<Item> postItem(
          Item body
  ) throws Exception {
    return new ResponseEntity<Item>(repository.save(body), HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public Item headItem() {
    return new Item();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UUID deleteItem(@PathVariable final UUID id) {
    return id;
  }
}