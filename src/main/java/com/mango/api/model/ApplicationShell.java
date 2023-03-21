package com.mango.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.util.UUID;

@Schema(description = "Application Shell object")
@Entity
@Table(name = "application_shells")
public class ApplicationShell {
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
	@JsonProperty(value="applicationShellName", required=true, index = 10)
	@Schema(name="applicationShellName", description = "Application Shell Name",
		example = "Shop", required = true)
	private String applicationShellName;

	@JsonProperty(value="installedInstanceCode", required=true, index = 20)
	@Schema(name = "installedInstanceCode", description = "Installed Instance Code of the Application Shell.",
			example = "SDFSDFS", required = true)
	private String installedInstanceCode;

//	@JsonProperty(value="foundationId", required=true, index = 30)
//	@Schema(name="foundationId", description = "Foundaton Identifier for the Application Shell",
//			example = "SDFSDFS", required = false)
//	private Long foundationId;

	@JsonProperty(value="applicationShellType", required=true, index = 40)
	@Schema(name="applicationShellType", description = "Application Shell Type of the Application Shell",
			example = "UUID", required = true)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shell_type_id", referencedColumnName = "id")
	private ShellType applicationShellType;

	public ApplicationShell() {

	}

	public ApplicationShell(String applicationShellName, ShellType applicationShellType, String namespace) {
		this.applicationShellType = applicationShellType;
		this.applicationShellName = applicationShellName;
		this.namespace = namespace;
	}

	@Column(name = "application_shell_name")
	public String getApplicationShellName() {
		return applicationShellName;
	}
	public void setApplicationShellName(String applicationShellName) {
		this.applicationShellName = applicationShellName;
	}

	@Column(name = "installed_instance_code")
	public String getInstalledInstanceCode() {
		return this.installedInstanceCode;
	}

	public void setInstalledInstanceCode(String installedInstanceCode) {
		this.installedInstanceCode = installedInstanceCode;
	}

//	@Column(name = "foundation_id")
//	public Long getFoundationId() {
//		return this.foundationId;
//	}
//
//	public void setFoundationId(Long foundationId) {
//		this.foundationId = foundationId;
//	}

	@Column(name = "application_shell_type")
	public ShellType getApplicationShellType() {
		return this.applicationShellType;
	}
	public void setApplicationShellType(ShellType applicationShellType) {
		this.applicationShellType = applicationShellType;
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
