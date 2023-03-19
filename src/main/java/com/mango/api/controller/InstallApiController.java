package com.mango.api.controller;

import com.mango.api.exception.EntityNotFoundException;
import com.mango.api.respository.InstallRepository;
import com.mango.api.model.Install;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
public class InstallApiController implements InstallApi {

  @Autowired
  private InstallRepository repository;

  @Override
  public ResponseEntity<Install> findById(
          UUID id//,
          //    String bookAuthorization
  ) throws Exception {

    Install book = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Application Install not found for this id :: " + id));

    return ResponseEntity.ok().body(book);
  }

  @Override
  public Collection<Install> findApplicationInstalls() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Install updateApplicationInstall(@PathVariable("id") final UUID id, @RequestBody final Install book) {
    return book;
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Install patchApplicationInstall(@PathVariable("id") final UUID id, @RequestBody final Install book) {
    return book;
  }

  @Override
  public ResponseEntity<Install> postApplicationInstall(
          Install body//,
          //    String bookAuthorization
  ) throws Exception {
    return new ResponseEntity<Install>(repository.save(body), HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public Install headApplicationInstall() {
    return new Install();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UUID deleteApplicationInstall(@PathVariable final UUID id) {
    return id;
  }
}