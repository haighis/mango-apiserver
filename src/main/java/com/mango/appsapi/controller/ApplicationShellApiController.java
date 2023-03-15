package com.mango.appsapi.controller;

import com.mango.appsapi.exception.EntityNotFoundException;
import com.mango.appsapi.respository.ApplicationShellRepository;
import com.mango.appsapi.model.ApplicationShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ApplicationShellApiController implements ApplicationShellApi {

  @Autowired
  private ApplicationShellRepository repository;

  @Override
  public ResponseEntity<ApplicationShell> findById(
      long id//,
  //    String bookAuthorization
  ) throws Exception {

    ApplicationShell book = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Application Shell not found for this id :: " + id));

    return ResponseEntity.ok().body(book);
  }

  @Override
  public Collection<ApplicationShell> findApplicationShells() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationShell updateApplicationShell(@PathVariable("id") final String id, @RequestBody final ApplicationShell book) {
    return book;
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationShell patchApplicationShell(@PathVariable("id") final String id, @RequestBody final ApplicationShell book) {
    return book;
  }

  @Override
  public ResponseEntity<ApplicationShell> postApplicationShell(
          ApplicationShell body//,
  //    String bookAuthorization
  ) throws Exception {
    return new ResponseEntity<ApplicationShell>(repository.save(body), HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationShell headApplicationShell() {
    return new ApplicationShell();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public long deleteApplicationShell(@PathVariable final long id) {
    return id;
  }
}