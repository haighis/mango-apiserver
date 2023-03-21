package com.mango.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.util.UUID;

@Schema(description = "Artifact object")
@Entity
@Table(name = "artifacts")
public class Artifact {
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

	@JsonProperty(value="name", required=true, index = 10)
	@Schema(name="name", description = "Name of the Artifact.",
		example = "Forum", required = true)
	private String name;

	@JsonProperty(value="url", required=true, index = 20)
	@Schema(name = "url", description = "Url of the Artifact.",
		example = "", required = true)
	private String url;

	@JsonProperty(value="version", required=true, index = 20)
	@Schema(name = "version", description = "Version of the Artifact.",
			example = "", required = true)
	private String version;

	@JsonProperty(value="isCurrent", required=true, index = 20)
	@Schema(name = "isCurrent", description = "isCurrent of the Artifact.",
			example = "", required = true)
	private Boolean isCurrent;

	@JsonProperty(value="status", required=true, index = 30)
	@Schema(name="status", description = "Status of the Artifact.",
		example = "ACTIVE, INACTIVE", required = true)
	private String status;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "item_id", nullable = false)
	@JsonIgnore
	private Item item;

	public Artifact() {

	}

	public Artifact(String name, String url, String version, boolean isCurrent, String status, String namespace) {
		this.name = name;
		this.version = version;
		this.url = url;
		this.isCurrent = isCurrent;
		this.status = status;
	}

	@Column(name = "name")
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "url")
	public String getUrl()
	{
		return this.url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	@Column(name = "version")
	public String getVersion()
	{
		return this.version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	@Column(name = "isCurrent")
	public boolean getIsCurrent() {
		return this.isCurrent;
	}

	public void setIsCurrent(boolean isCurrent)
	{
		this.isCurrent = isCurrent;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

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

	@JsonProperty(value="namespace", required=true, index = 50)
	@Schema(description = "Namespace of the item",
			example = "test", required = false)
	private String namespace;

	@Column(name = "namespace")
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
}
