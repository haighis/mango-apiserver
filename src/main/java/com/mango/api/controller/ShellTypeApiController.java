package com.mango.api.controller;

import com.mango.api.exception.EntityNotFoundException;
import com.mango.api.model.ShellType;
import com.mango.api.respository.ShellTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
public class ShellTypeApiController implements ShellTypeApi {

  @Autowired
  private ShellTypeRepository repository;

  @Override
  public ResponseEntity<ShellType> findById(
          String id
  ) throws Exception {
    ShellType book = repository.findById(UUID.fromString(id))
        .orElseThrow(() -> new EntityNotFoundException("ShellType not found for this id :: " + id));
  return ResponseEntity.ok().body(book);
  }

  @Override
  public Collection<ShellType> findShellTypes() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ShellType updateShellType(@PathVariable("id") final UUID id, @RequestBody final ShellType label) {
    return label;
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ShellType patchShellType(@PathVariable("id") final UUID id, @RequestBody final ShellType book) {
    return book;
  }

  @Override
  public ResponseEntity<ShellType> postShellType(
          ShellType body
  ) throws Exception {
    ShellType shellType = new ShellType();
    List<ShellType> exist = repository.findByDescription(body.getDescription());
    if(exist.stream().count() > 0) {
      shellType = exist.get(0);
    } else {
      shellType = repository.save(body);
    }
    return new ResponseEntity<ShellType>(shellType, HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public ShellType headShellType() {
    return new ShellType();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UUID deleteShellType(@PathVariable final UUID id) {
    repository.deleteById(id);
    return id;
  }
}