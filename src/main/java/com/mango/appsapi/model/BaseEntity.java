package com.mango.appsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.MappedSuperclass;
import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {

    //@Column(name = "namespace")
    @JsonProperty(value="namespace", required=true, index = 10)
    @Schema(description = "Namespace of the item",
      example = "test", required = false)
    private String namespace;

    @JsonProperty(value="label", required=true, index = 10)
    @Schema(description = "Label of the item",
      example = "test", required = false)
    //@Column(name = "label")
    private String label;

    @JsonProperty(value="id", required=true, index = 10)
    @Schema(description = "Unique identifier of the Book.",
      example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Getters and setters omitted for brevity
    public long getId() {
        return id;
    }

    public String getNamespace() {
        return namespace;
    }
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

//    public String getLabel() {
//        return label;
//    }
//    public void setLabel(String label) {
//        this.label = label;
//    }

    public BaseEntity(String namespace) {
        this.namespace = namespace;
        //this.label = label;
    }
}

