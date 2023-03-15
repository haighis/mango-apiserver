package com.mango.appsapi.controller;

import com.mango.appsapi.exception.EntityNotFoundException;
import com.mango.appsapi.respository.ApplicationInstallRepository;
import com.mango.appsapi.model.ApplicationInstall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ApplicationInstallApiController implements ApplicationInstallApi {

  @Autowired
  private ApplicationInstallRepository repository;

  @Override
  public ResponseEntity<ApplicationInstall> findById(
      long id//,
  //    String bookAuthorization
  ) throws Exception {

    ApplicationInstall book = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Application Install not found for this id :: " + id));

    return ResponseEntity.ok().body(book);
  }

  @Override
  public Collection<ApplicationInstall> findApplicationInstalls() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationInstall updateApplicationInstall(@PathVariable("id") final String id, @RequestBody final ApplicationInstall book) {
    return book;
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationInstall patchApplicationInstall(@PathVariable("id") final String id, @RequestBody final ApplicationInstall book) {
    return book;
  }

  @Override
  public ResponseEntity<ApplicationInstall> postApplicationInstall(
          ApplicationInstall body//,
  //    String bookAuthorization
  ) throws Exception {
    return new ResponseEntity<ApplicationInstall>(repository.save(body), HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationInstall headApplicationInstall() {
    return new ApplicationInstall();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public long deleteApplicationInstall(@PathVariable final long id) {
    return id;
  }
}