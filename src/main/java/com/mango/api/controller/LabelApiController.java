package com.mango.api.controller;

import com.mango.api.exception.EntityNotFoundException;
import com.mango.api.model.Label;
import com.mango.api.respository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
public class LabelApiController implements LabelApi {

  @Autowired
  private LabelRepository repository;

  @Override
  public ResponseEntity<Label> findById(
          UUID id//,
          //    String bookAuthorization
  ) throws Exception {

    Label book = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Label not found for this id :: " + id));

    return ResponseEntity.ok().body(book);
  }

  @Override
  public Collection<Label> findLabels() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Label updateLabel(@PathVariable("id") final UUID id, @RequestBody final Label label) {
    return label;
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Label patchLabel(@PathVariable("id") final UUID id, @RequestBody final Label book) {
    return book;
  }

  @Override
  public ResponseEntity<Label> postLabel(
          Label body//,
  //    String bookAuthorization
  ) throws Exception {
    return new ResponseEntity<Label>(repository.save(body), HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public Label headLabel() {
    return new Label();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UUID deleteLabel(@PathVariable final UUID id) {
    return id;
  }
}