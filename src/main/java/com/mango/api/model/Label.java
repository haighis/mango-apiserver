package com.mango.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.UUID;

@Schema(description = "Label object")
@Entity
@Table(name = "labels")
@Getter @Setter
public class Label {
/* Backpacks, Software Catalog, Software Company, Foundation*/
	@JsonProperty(value="id", required=true, index = 10)
	@Schema(description = "Unique identifier of Label.",
			example = "1", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	//Getters and setters omitted for brevity
//	public UUID getId() {
//		return id;
//	}
	@JsonProperty(value="name", required=true, index = 10)
	@Schema(name="name", description = "Name of Label.",
		example = "Forum", required = true)
	@Column(name = "name")
	private String name;

	@Column(name = "created_on")
	@CreationTimestamp
	private java.sql.Timestamp createdOn;

//	@JsonProperty(value="description", required=true, index = 20)
//	@Schema(name = "description", description = "Description fo the Store Item.",
//		example = "Forum Application for PHP", required = true)
//	private String description;
//
//	@JsonProperty(value="status", required=true, index = 30)
//	@Schema(name="status", description = "Installed Instance Code of the Application.",
//		example = "ACTIVE, INACTIVE", required = true)
//	private String status;

	public Label() {

	}

	public Label(String name, String namespace, String kind) {
		this.name = name;
		this.namespace = namespace;
		this.kind = kind;
	}

//	@Column(name = "name")
//	public String getName()
//	{
//		return this.name;
//	}
//
//	public void setName(String name)
//	{
//		this.name = name;
//	}

	@JsonProperty(value="kind", required=true, index = 40)
	@Schema(description = "Kind of Label.",
			example = "Application", required = false)
	@Column(name = "kind")
	private String kind;

//	public String getKind() {
//		return kind;
//	}
//	public void setKind(String kind) {
//		this.kind = kind;
//	}

	@JsonProperty(value="namespace", required=true, index = 50)
	@Schema(description = "Namespace of Label.",
			example = "test", required = false)
	@Column(name = "namespace")
	private String namespace;

//	@Column(name = "namespace")
//	public String getNamespace() {
//		return namespace;
//	}
//	public void setNamespace(String namespace) {
//		this.namespace = namespace;
//	}

//	@Column(name = "description")
//	public String getDescription() {
//		return this.description;
//	}
//
//	public void setDescription(String description)
//	{
//		this.description = description;
//	}
//
//	@Column(name = "status")
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
}
