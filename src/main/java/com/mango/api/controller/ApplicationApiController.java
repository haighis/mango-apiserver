package com.mango.api.controller;

import com.mango.api.exception.EntityNotFoundException;
import com.mango.api.model.Application;
import com.mango.api.respository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
public class ApplicationApiController implements ApplicationApi {

  @Autowired
  private ApplicationRepository repository;

  @Override
  public ResponseEntity<Application> findById(
          UUID id//,
          //    String bookAuthorization
  ) throws Exception {

    Application book = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Application not found for this id :: " + id));

    return ResponseEntity.ok().body(book);
  }

  @Override
  public Collection<Application> findApplications() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Application updateApplication(@PathVariable("id") final UUID id, @RequestBody final Application book) {
    return book;
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Application patchApplication(@PathVariable("id") final UUID id, @RequestBody final Application book) {
    return book;
  }

  @Override
  public ResponseEntity<Application> postApplication(
          Application body//,
  //    String bookAuthorization
  ) throws Exception {
    return new ResponseEntity<Application>(repository.save(body), HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public Application headApplication() {
    return new Application();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UUID deleteApplication(@PathVariable final UUID id) {
    return id;
  }
}