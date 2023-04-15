package com.mango.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Schema(description = "Application Shell object")
@Entity
@Table(name = "application_shells")
@Getter @Setter
public class ApplicationShell {
	@JsonProperty(value="id", required=true, index = 10)
	@Schema(description = "Unique identifier of the Item.",
			example = "1", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	//Getters and setters omitted for brevity
//	public UUID getId() {
//		return id;
//	}
	@JsonProperty(value="applicationShellName", required=true, index = 10)
	@Schema(name="applicationShellName", description = "Application Shell Name",
		example = "Shop", required = true)
	@Column(name = "application_shell_name")
	private String applicationShellName;

	@JsonProperty(value="installedInstanceCode", required=true, index = 20)
	@Schema(name = "installedInstanceCode", description = "Installed Instance Code of the Application Shell.",
			example = "SDFSDFS", required = true)
	@Column(name = "installed_instance_code")
	private String installedInstanceCode;

//	@JsonProperty(value="foundationId", required=true, index = 30)
//	@Schema(name="foundationId", description = "Foundaton Identifier for the Application Shell",
//			example = "SDFSDFS", required = false)
//	private Long foundationId;

//	@JsonProperty(value="applicationShellType", required=true, index = 40)
//	@Schema(name="applicationShellType", description = "Application Shell Type of the Application Shell",
//			example = "UUID", required = true)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shell_type_id", referencedColumnName = "id",  insertable = false, updatable = false)
	@JsonIgnore
	private ShellType applicationShellType;

//	@Column(name = "item_id")
//	private UUID itemId;
//
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "item_id", insertable = false, updatable = false)
//	@JsonIgnore
//	private Item item;


	@JsonProperty(value="namespace", required=true, index = 50)
	@Schema(description = "Namespace of the Application Shell.",
			example = "test", required = false)
	@Column(name = "namespace")
	private String namespace;

//	@JsonProperty(value="applicationShellTypeId", required=true, index = 60)
//	@Schema(description = "shellTypeId of the ApplicationShell",
//			example = "test", required = false)
	@JsonProperty(value="shellTypeId", required=true, index = 50)
	@Schema(description = "shellTypeId of the item",
			example = "test", required = false)
	@Column(name = "shell_type_id")
	//private UUID itemId;
	private UUID shellTypeId;
	//@Transient

	public ApplicationShell() {

	}

	public ApplicationShell(String applicationShellName, ShellType applicationShellType, UUID shellTypeId, String installedInstanceCode, String namespace) {
		this.applicationShellType = applicationShellType;
		this.applicationShellName = applicationShellName;
		this.shellTypeId = shellTypeId;
		//this.applicationShellTypeId = applicationShellTypeId;
		this.namespace = namespace;
		this.installedInstanceCode = installedInstanceCode;
	}

//	@Column(name = "application_shell_name")
//	public String getApplicationShellName() {
//		return applicationShellName;
//	}
//	public void setApplicationShellName(String applicationShellName) {
//		this.applicationShellName = applicationShellName;
//	}
//
//	@Column(name = "installed_instance_code")
//	public String getInstalledInstanceCode() {
//		return this.installedInstanceCode;
//	}
//
//	public void setInstalledInstanceCode(String installedInstanceCode) {
//		this.installedInstanceCode = installedInstanceCode;
//	}

//	@Column(name = "foundation_id")
//	public Long getFoundationId() {
//		return this.foundationId;
//	}
//
//	public void setFoundationId(Long foundationId) {
//		this.foundationId = foundationId;
//	}

//	@Column(name = "application_shell_type")
//	public ShellType getApplicationShellType() {
//		return this.applicationShellType;
//	}
//	public void setApplicationShellType(ShellType applicationShellType) {
//		this.applicationShellType = applicationShellType;
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



//	@Column(name = "namespace")
//	public String getNamespace() {
//		return namespace;
//	}
//	public void setNamespace(String namespace) {
//		this.namespace = namespace;
//	}
}
