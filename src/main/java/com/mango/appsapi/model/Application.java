package com.mango.appsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Schema(description = "Application object")
@Entity
@Table(name = "applications")
public class Application extends BaseEntity {
	@JsonProperty(value="applicationName", required=true, index = 10)
	@Schema(name="applicationName", description = "Name of the Application.",
		example = "Shop", required = true)
	private String applicationName;

	@JsonProperty(value="applicationUrl", required=true, index = 20)
	@Schema(name = "applicationUrl", description = "Url of the Application.",
		example = "http://someurltoapplicationjsmodule", required = true)
	private String applicationUrl;

	@JsonProperty(value="installedInstanceCode", required=true, index = 30)
	@Schema(name="installedInstanceCode", description = "Installed Instance Code of the Application.",
		example = "SDFSDFS", required = true)
	private String installedInstanceCode;

	public Application() {
		super("");
	}

	public Application(String applicationName, String applicationUrl, String installedInstanceCode, String namespace) {
		super(namespace);
		this.applicationName = applicationName;
		this.installedInstanceCode = installedInstanceCode;
		this.applicationUrl = applicationUrl;
//		if(label.isPresent()){
//			this.label = label.get();
//		}
	}

	@Column(name = "application_name")
	public String getApplicationName()
	{
		return this.applicationName;
	}

	public void setApplicationName(String applicationName)
	{
		this.applicationName = applicationName;
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
		return installedInstanceCode;
	}
	public void setInstalledInstanceCode(String installed_instance_code) {
		this.installedInstanceCode = installed_instance_code;
	}
}
