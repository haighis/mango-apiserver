package com.mango.appsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import java.sql.Date;

@Schema(description = "Application Install audit object")
@Entity
@Table(name = "application_installs")
public class ApplicationInstall extends BaseEntity {
	@JsonProperty(value="applicationName", required=true, index = 10)
	@Schema(name="applicationName", description = "Name of the Application Install.",
		example = "Shop", required = true)
	private String applicationName;

	@JsonProperty(value="applicationUrl", required=true, index = 20)
	@Schema(name="applicationUrl", description = "Url of the Application Install audit.",
		example = "http://someurltoapplicationjsmodule", required = true)
	private String applicationUrl;

	@JsonProperty(value="installedInstanceCode", required=true, index = 30)
	@Schema(name="installedInstanceCode", description = "Installed Instance Code of the Application Install audit.",
		example = "SDFSDFS", required = true)
	private String installedInstanceCode;

	@JsonProperty(value="version", required=true, index = 40)
	@Schema(name="version", description = "Version of the Application Install audit.",
			example = "Shop", required = true)
	private String version;

	@JsonProperty(value="created", required=true, index = 10)
	@Schema(name="created", description = "Installation created data and time of the Application Install audit.",
			example = "Shop", required = true)
	private Date created;

	@JsonProperty(value="Status", required=true, index = 40)
	@Schema(name="status", description = "Status of the Application Install.",
		example = "ACTIVE,INACTIVE", required = true)
	private boolean status;

	public ApplicationInstall() {
		super("");
	}
	public ApplicationInstall(String application_name, String applicationUrl, boolean status, String namespace) {
		super(namespace);
		this.applicationName = application_name;
		this.applicationUrl = applicationUrl;
//		if(label.isPresent()){
//			this.label = label.get();
//		}
		this.status = status;
	}

	@Column(name = "application_name")
	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String title)
	{
		this.applicationName = title;
	}

	@Column(name = "application_url")
	public String getApplicationUrl() {
		return this.applicationUrl;
	}

	public void setApplicationUrl(String applicationUrl)
	{
		this.applicationUrl = applicationUrl;
	}

	@Column(name = "installed_instance_code")
	public String getInstalledInstanceCode() {
		return this.installedInstanceCode;
	}

	public void setInstalledInstanceCode(String installed_instance_code) {
		this.installedInstanceCode = installed_instance_code;
	}

	@Column(name = "status")
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
