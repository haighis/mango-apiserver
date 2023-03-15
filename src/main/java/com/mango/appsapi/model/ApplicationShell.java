package com.mango.appsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Schema(description = "Application Shell object")
@Entity
@Table(name = "application_shells")
public class ApplicationShell extends BaseEntity {
	@JsonProperty(value="applicationShellName", required=true, index = 10)
	@Schema(name="applicationShellName", description = "Application Shell Name",
		example = "Shop", required = true)
	private String applicationShellName;

	@JsonProperty(value="installedInstanceCode", required=true, index = 20)
	@Schema(name = "installedInstanceCode", description = "Installed Instance Code of the Application Shell.",
			example = "SDFSDFS", required = true)
	private String installedInstanceCode;

	@JsonProperty(value="foundationId", required=true, index = 30)
	@Schema(name="foundationId", description = "Foundaton Identifier for the Application Shell",
			example = "SDFSDFS", required = false)
	private Long foundationId;

	@JsonProperty(value="applicationShellType", required=true, index = 40)
	@Schema(name="applicationShellType", description = "Application Shell Type of the Application Shell",
			example = "DESKTOP_ELECTRON, WEB, CLI, MOBILE", required = true)
	private String applicationShellType;

	public ApplicationShell() {
		super("");
	}

	public ApplicationShell(String applicationShellName, Long foundationId, String applicationShellType, String namespace) {
		super(namespace);
		this.applicationShellType = applicationShellType;
		this.foundationId = foundationId;
		this.applicationShellName = applicationShellName;

//		if(label.isPresent()){
//			//this.label = label.get();
//
//		} else {
//			//super(namespace,"");
//		}
	}

	@Column(name = "application_shell_name")
	public String getApplcationShellName() {
		return applicationShellName;
	}
	public void setApplcationShellName(String applicationShellName) {
		this.applicationShellName = applicationShellName;
	}

	@Column(name = "installed_instance_code")
	public String getInstalledInstanceCode() {
		return this.installedInstanceCode;
	}

	public void setInstalledInstanceCode(String installedInstanceCode) {
		this.installedInstanceCode = installedInstanceCode;
	}

	@Column(name = "foundation_id")
	public Long getFoundationId() {
		return this.foundationId;
	}

	public void setFoundationId(Long foundationId) {
		this.foundationId = foundationId;
	}

	@Column(name = "application_shell_type")
	public String getApplicationShellType() {
		return this.applicationShellType;
	}
	public void setApplicationShellType(String applicationShellType) {
		this.applicationShellType = applicationShellType;
	}
}
