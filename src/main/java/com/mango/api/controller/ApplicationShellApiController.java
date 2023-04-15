package com.mango.api.controller;

import com.mango.api.exception.EntityNotFoundException;
import com.mango.api.model.ShellType;
import com.mango.api.respository.ApplicationShellRepository;
import com.mango.api.model.ApplicationShell;
import com.mango.api.respository.ShellTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
public class ApplicationShellApiController implements ApplicationShellApi {

  @Autowired
  private ApplicationShellRepository repository;

  @Autowired
  private ShellTypeRepository shellTypeRepository;

  @Override
  public ResponseEntity<ApplicationShell> findById(
          UUID id//,
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
  public ApplicationShell updateApplicationShell(@PathVariable("id") final UUID id, @RequestBody final ApplicationShell book) {
    return book;
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationShell patchApplicationShell(@PathVariable("id") final UUID id, @RequestBody final ApplicationShell book) {
    return book;
  }

  @Override
  public ResponseEntity<ApplicationShell> postApplicationShell(
          ApplicationShell body
  ) throws Exception {
    List<ApplicationShell> existsShells = repository.findByApplicationShellName(body.getApplicationShellName());
    if(existsShells.stream().count() >= 1) {
      return new ResponseEntity<ApplicationShell>(existsShells.get(0), HttpStatus.CREATED);
    }
    else {

      // Create the instance code
      int leftLimit = 48; // numeral '0'
      int rightLimit = 122; // letter 'z'
      int targetStringLength = 10;
      Random random = new Random();
      //System.out.println("shell " + body.g);
      String generatedString = random.ints(leftLimit, rightLimit + 1)
              .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
              .limit(targetStringLength)
              .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
              .toString();
      body.setInstalledInstanceCode(generatedString);
      //ShellType shellType = shellTypeRepository.getOne(UUID.fromString(body.getApplicationShellTypeId()));
      //body.setApplicationShellType(shellType);
      ApplicationShell appShell = repository.save(body);
      return new ResponseEntity<ApplicationShell>(appShell, HttpStatus.CREATED);
    }
  }

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public ApplicationShell headApplicationShell() {
    return new ApplicationShell();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UUID deleteApplicationShell(@PathVariable final UUID id) {
    return id;
  }
}