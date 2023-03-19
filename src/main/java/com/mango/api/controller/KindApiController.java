package com.mango.api.controller;

import com.mango.api.exception.EntityNotFoundException;
import com.mango.api.model.Kind;
import com.mango.api.respository.KindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
public class KindApiController implements KindApi {

  @Autowired
  private KindRepository repository;

  @Override
  public ResponseEntity<Kind> findById(
          UUID id
  ) throws Exception {

    Kind book = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Kind not found for this id :: " + id));

    return ResponseEntity.ok().body(book);
  }

  @Override
  public Collection<Kind> findKinds() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Kind updateKind(@PathVariable("id") final UUID id, @RequestBody final Kind label) {
    return label;
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Kind patchKind(@PathVariable("id") final UUID id, @RequestBody final Kind book) {
    return book;
  }

  @Override
  public ResponseEntity<Kind> postKind(
          Kind body
  ) throws Exception {
    return new ResponseEntity<Kind>(repository.save(body), HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public Kind headKind() {
    return new Kind();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UUID deleteKind(@PathVariable final UUID id) {
    return id;
  }
}