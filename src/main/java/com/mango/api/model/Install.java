package com.mango.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Schema(description = "Install audit object")
@Entity
@Table(name = "installs")
@Getter @Setter
public class Install {
//	@JsonProperty(value="id", required=true, index = 10)
//	@Schema(description = "Unique identifier of the Item.",
//			example = "1", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	//Getters and setters omitted for brevity
	//public UUID getId() {
//		return id;
//	}

//	@JsonProperty(value="name", required=true, index = 10)
//	@Schema(name="name", description = "Name of the Install.",
//		example = "Shop", required = true)
	@Column(name = "name")
	private String name;

//	@JsonProperty(value="uri", required=true, index = 20)
//	@Schema(name="uri", description = "Uri of the Install audit.",
//		example = "http://someurltoapplicationjsmodule", required = true)
	@Column(name = "uri")
	private String uri;

//	@JsonProperty(value="code", required=true, index = 30)
//	@Schema(name="code", description = "Installed Instance Code of the Install audit.",
//		example = "SDFSDFS", required = true)
	@Column(name = "code")
	private String code;

//	@JsonProperty(value="version", required=true, index = 40)
//	@Schema(name="version", description = "Version of the Install audit.",
//			example = "Shop", required = true)
	@Column(name = "version")
	private String version;

//	@JsonProperty(value="created", required=true, index = 10)
//	@Schema(name="created", description = "Installation created data and time of the Install audit.",
//			example = "Shop", required = true)
	@Column(name = "created")
	@CreationTimestamp
	private Date created;

	@Column(name = "kind")
	private String kind;

	@Column(name = "namespace")
	private String namespace;

//	@JsonProperty(value="Status", required=true, index = 40)
//	@Schema(name="status", description = "Status of the Install.",
//		example = "ACTIVE,INACTIVE", required = true)
	@Column(name = "status")
	private boolean status;

	public Install() {

	}
	public Install(String name, String uri, boolean status, String namespace, String kind) {
		this.name = name;
		this.uri = uri;
		this.status = status;
		this.namespace = namespace;
		this.kind = kind;
	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String title)
//	{
//		this.name = title;
//	}
//
//	@Column(name = "uri")
//	public String getUri() {
//		return this.uri;
//	}
//
//	public void setUri(String uri)
//	{
//		this.uri = uri;
//	}
//
//	@Column(name = "code")
//	public String getCode() {
//		return this.code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}
//
//	@Column(name = "status")
//	public boolean getStatus() {
//		return status;
//	}
//	public void setStatus(boolean status) {
//		this.status = status;
//	}
//
//
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
//
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
