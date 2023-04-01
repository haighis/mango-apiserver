package com.mango.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Schema(description = "Artifact object")
@Entity
@Table(name = "artifacts")
@Getter @Setter
public class Artifact {
	@JsonProperty(value="id", required=true, index = 10)
	@Schema(description = "Unique identifier of the Item.",
			example = "1", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	//public UUID getId() {
	//	return id;
	//}

	@JsonProperty(value="name", required=true, index = 10)
	@Schema(name="name", description = "Name of the Artifact.",
		example = "Forum", required = true)
	@Column(name = "name")
	private String name;

//	@JsonProperty(value="url", required=true, index = 20)
//	@Schema(name = "url", description = "Url of the Artifact.",
//		example = "", required = true)
	@Column(name = "url")
	private String url;

//	@JsonProperty(value="version", required=true, index = 30)
//	@Schema(name = "version", description = "Version of the Artifact.",
//			example = "", required = true)
	@Column(name = "version")
	private String version;

//	@JsonProperty(value="isCurrent", required=true, index = 40)
//	@Schema(name = "isCurrent", description = "isCurrent of the Artifact.",
//			example = "", required = true)
	@Column(name = "isCurrent")
	private Boolean isCurrent;

//	@JsonProperty(value="status", required=true, index = 50)
//	@Schema(name="status", description = "Status of the Artifact.",
//		example = "ACTIVE, INACTIVE", required = true)
	@Column(name = "status")
	private String status;

	@Column(name = "namespace")
	private String namespace;

	@Column(name = "item_id")
	private UUID itemId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "item_id", insertable = false, updatable = false)
	@JsonIgnore
	private Item item;

//	@ManyToOne
//	@JoinColumn(name = "order_id",referencedColumnName = "id",insertable = false,updatable = false)
//	private Order order;

//	@ManyToOne
//	@JoinColumn(name = "order_id",referencedColumnName = "id",insertable = false,updatable = false)
//	private Order order;

	public Artifact() {

	}

	public Artifact(UUID itemId, String name, String url, String version, boolean isCurrent, String status, String namespace) {
		this.itemId = itemId;
		this.name = name;
		this.version = version;
		this.url = url;
		this.isCurrent = isCurrent;
		this.status = status;
		this.namespace = namespace;
	}

//	@Column(name = "name")
//	public String getName()
//	{
//		return this.name;
//	}
//	public void setName(String name)
//	{
//		this.name = name;
//	}
//
//	@Column(name = "url")
//	public String getUrl()
//	{
//		return this.url;
//	}
//	public void setUrl(String url)
//	{
//		this.url = url;
//	}
//
//	@Column(name = "version")
//	public String getVersion()
//	{
//		return this.version;
//	}
//
//	public void setVersion(String version)
//	{
//		this.version = version;
//	}
//
//	@Column(name = "isCurrent")
//	public boolean getIsCurrent() {
//		return this.isCurrent;
//	}
//
//	public void setIsCurrent(boolean isCurrent)
//	{
//		this.isCurrent = isCurrent;
//	}

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
//	@Column(name = "namespace")
//	private String namespace;

//	@Column(name = "namespace")
//	public String getNamespace() {
//		return namespace;
//	}
//	public void setNamespace(String namespace) {
//		this.namespace = namespace;
//	}
}
