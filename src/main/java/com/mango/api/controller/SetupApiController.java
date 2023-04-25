package com.mango.api.controller;

import com.mango.api.model.Install;
import com.mango.api.model.Kind;
import com.mango.api.model.Label;
import com.mango.api.model.Setup;
import com.mango.api.respository.InstallRepository;
import com.mango.api.respository.KindRepository;
import com.mango.api.respository.LabelRepository;
import com.mango.api.respository.ShellTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
public class SetupApiController implements SetupApi {

  @Autowired
  private InstallRepository installRepository;
  @Autowired
  private KindRepository kindRepository;

  @Autowired
  private LabelRepository labelRepository;

  @Override
  public ResponseEntity<Label> postSetup(
          //Label body
  ) throws Exception {
    // check if this method has run yet and prevent it from executing if already run
    String initialSetupValue = "System-Initial-Setup";
    List<Label> existingInstallList = labelRepository.findByName(initialSetupValue);
    List<Install> list = installRepository.findByName(initialSetupValue);
    if(list.stream().count() > 0) {
      return new ResponseEntity<Label>(existingInstallList.get(0),HttpStatus.BAD_REQUEST);
    }
    String mangoSystemNamespace = "mango-system";

    // Kinds
    kindRepository.save(new Kind("System","The Mango System."));
    kindRepository.save(new Kind("SystemSetup","The Mango System Setup."));
    kindRepository.save(new Kind("Application",""));
    kindRepository.save(new Kind("ApplicationShell",""));
    kindRepository.save(new Kind("Artifact",""));
    kindRepository.save(new Kind("Item",""));
    kindRepository.save(new Kind("ShellType",""));
    kindRepository.save(new Kind("Backpack",""));
    kindRepository.save(new Kind("SoftwareCatalog",""));
    kindRepository.save(new Kind("SoftwareGroup",""));

    // Backpacks, Software Catalog, Software Group
    labelRepository.save(new Label("Default Backpack",mangoSystemNamespace,"Backpack"));
    labelRepository.save(new Label("Default Software Catalog",mangoSystemNamespace,"SoftwareCatalog"));
    labelRepository.save(new Label("Default Software Group",mangoSystemNamespace,"SoftwareGroup"));

    Label initialSetup = new Label(initialSetupValue,mangoSystemNamespace,"SystemSetup");
    labelRepository.save(initialSetup);
    // Install audit for this process
    installRepository.save(new Install(initialSetupValue,"/api/setup",true,"mango-system","SystemSetup"));

    // Mango Platform Default
    // Mango Platform Application Shell
    // - create config for _system application shell, application, foundation
    // Mango Platform Application & Relate to Application Shell

    // Mango Foundation & Relate to default application shell

    // User space
    // Default Application Shell

    // Default Application & Relate to Application Shell

    // Default Foundation & Relate to default application shell\

    return new ResponseEntity<Label>(initialSetup,HttpStatus.CREATED);
  }
}