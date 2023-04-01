package com.mango.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Schema(description = "Item object")
@Entity
@Table(name = "items")
@Getter
@Setter
public class Item {
//	@JsonProperty(value="id", required=true, index = 10)
//	@Schema(description = "Unique identifier of the Item.",
//			example = "1", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	//Getters and setters omitted for brevity
	public UUID getId() {
		return id;
	}

//	@JsonProperty(value="name", required=true, index = 10)
//	@Schema(name="name", description = "Name of the Store Item.",
//		example = "Forum", required = true)
	@Column(name = "name")
	private String name;

//	@JsonProperty(value="description", required=true, index = 20)
//	@Schema(name = "description", description = "Description fo the Store Item.",
//		example = "Forum Application for PHP", required = true)
	@Column(name = "description")
	private String description;

//	@JsonProperty(value="status", required=true, index = 30)
//	@Schema(name="status", description = "Installed Instance Code of the Application.",
//		example = "ACTIVE, INACTIVE", required = true)
	@Column(name = "status")
	private String status;

	@Column(name = "namespace")
	private String namespace;

	//@OneToMany(mappedBy = "item")
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "order_id", referencedColumnName = "id")
	//private List<Artifact> artifacts;

//	@Column(name = "item_id")
//	private Integer orderId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id", referencedColumnName = "id")
	private Set<Artifact> artifacts = new HashSet<>();

	public Item() {
	}

	public Item(String name, String description, String status, String namespace) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.namespace = namespace;
	}

	public void add(Artifact artifact) {
		if (artifact != null) {
			if (this.artifacts == null) {
				artifacts = new HashSet<>();
			}
			artifacts.add(artifact);
		}
	}

	public Set<Artifact> getArtifacts() {
		return this.artifacts;
	}

	public void setArtifacts(Set<Artifact> artifacts) {
		this.artifacts = artifacts;
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
//
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

//	@JsonProperty(value="kind", required=true, index = 40)
//	@Schema(description = "Kind of the item",
//			example = "Application", required = false)
//	private String kind;
//	@Column(name = "kind")
//	public String getKind() {
//		return kind;
//	}
//	public void setKind(String kind) {
//		this.kind = kind;
//	}

//	@JsonProperty(value="namespace", required=true, index = 50)
//	@Schema(description = "Namespace of the item",
//			example = "test", required = false)
//	private String namespace;
//
//	@Column(name = "namespace")
//	public String getNamespace() {
//		return namespace;
//	}
//	public void setNamespace(String namespace) {
//		this.namespace = namespace;
//	}
}
