package com.mango.api.controller;

import com.mango.api.exception.EntityNotFoundException;
import com.mango.api.model.Application;
import com.mango.api.model.ApplicationShell;
import com.mango.api.respository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
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
          Application body
  ) throws Exception {
    List<Application> exists = repository.findByApplicationNameAndInstalledInstanceCode(body.getApplicationName(), body.getInstalledInstanceCode());
    Application app = new Application();
    if(exists.stream().count() >= 1) {
      app = exists.get(0);
    }
    else {
      app =  repository.save(body);
    }
    return new ResponseEntity<Application>(app, HttpStatus.CREATED);
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