package com.mango.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {
//    @JsonProperty(value="kind", required=true, index = 10)
//    @Schema(description = "Kind of the item",
//            example = "Application", required = false)
//    private String kind;
    @JsonProperty(value="namespace", required=true, index = 10)
    @Schema(description = "Namespace of the item",
      example = "test", required = false)
    private String namespace;

//    @JsonProperty(value="label", required=true, index = 10)
//    @Schema(description = "Label of the item",
//      example = "test", required = false)
//    //@Column(name = "label")
//    private String label;

    @JsonProperty(value="id", required=true, index = 10)
    @Schema(description = "Unique identifier of the Item.",
      example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    //Getters and setters omitted for brevity
    public UUID getId() {
        return id;
    }


    @Column(name = "namespace")
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

