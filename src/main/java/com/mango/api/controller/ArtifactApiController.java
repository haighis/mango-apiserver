package com.mango.api.controller;

import com.mango.api.exception.EntityNotFoundException;
import com.mango.api.model.Artifact;
import com.mango.api.model.Item;
import com.mango.api.respository.ArtifactRepository;
import com.mango.api.respository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
public class ArtifactApiController implements ArtifactApi {

  @Autowired
  private ArtifactRepository repository;

  @Override
  public ResponseEntity<Artifact> findById(
          UUID id
  ) throws Exception {

    Artifact book = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Artifact not found for this id :: " + id));

    return ResponseEntity.ok().body(book);
  }

  @Override
  public Collection<Artifact> findArtifacts() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Artifact updateArtifact(@PathVariable("id") final UUID id, @RequestBody final Artifact label) {
    return label;
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Artifact patchArtifact(@PathVariable("id") final UUID id, @RequestBody final Artifact book) {
    return book;
  }

  @Override
  public ResponseEntity<Artifact> postArtifact(
          Artifact body
  ) throws Exception {
    return new ResponseEntity<Artifact>(repository.save(body), HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.HEAD, value = "/")
  @ResponseStatus(HttpStatus.OK)
  public Artifact headArtifact() {
    return new Artifact();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UUID deleteArtifact(@PathVariable final UUID id) {
    return id;
  }
}