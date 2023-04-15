package com.mango.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Schema(description = "Application object")
@Entity
@Table(name = "applications")
@Getter @Setter
public class Application {
	@JsonProperty(value="id", required=true, index = 10)
	@Schema(description = "Unique identifier of the Item.",
			example = "1", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@JsonProperty(value="applicationName", required=true, index = 10)
	@Schema(name="applicationName", description = "Name of the Application.",
		example = "Shop", required = true)
	@Column(name = "application_name")
	private String applicationName;

	@JsonProperty(value="applicationUrl", required=true, index = 20)
	@Schema(name = "applicationUrl", description = "Url of the Application.",
		example = "http://someurltoapplicationjsmodule", required = true)
	@Column(name = "application_url")
	private String applicationUrl;

	@JsonProperty(value="installedInstanceCode", required=true, index = 30)
	@Schema(name="installedInstanceCode", description = "Installed Instance Code of the Application.",
		example = "SDFSDFS", required = true)
	@Column(name = "installed_instance_code")
	private String installedInstanceCode;

//	@JsonProperty(value="kind", required=true, index = 40)
//    @Schema(description = "Kind of the item",
//            example = "Application", required = false)
//    private String kind;
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
	@Column(name = "namespace")
	private String namespace;

//	@Column(name = "namespace")
//	public String getNamespace() {
//		return namespace;
//	}
//	public void setNamespace(String namespace) {
//		this.namespace = namespace;
//	}
//
//	@Column(name = "application_name")
//	public String getApplicationName()
//	{
//		return this.applicationName;
//	}
//	public void setApplicationName(String applicationName)
//	{
//		this.applicationName = applicationName;
//	}
//
//	@Column(name = "application_url")
//	public String getApplicationUrl() {
//		return this.applicationUrl;
//	}
//	public void setApplicationUrl(String applicationUrl)
//	{
//		this.applicationUrl = applicationUrl;
//	}
//
//	@Column(name = "installed_instance_code")
//	public String getInstalledInstanceCode() {
//		return installedInstanceCode;
//	}
//	public void setInstalledInstanceCode(String installed_instance_code) {
//		this.installedInstanceCode = installed_instance_code;
//	}

	public Application() {
	}

	public Application(String applicationName, String applicationUrl, String installedInstanceCode, String namespace) {
		//super(namespace);
		this.applicationName = applicationName;
		this.installedInstanceCode = installedInstanceCode;
		this.applicationUrl = applicationUrl;
		this.namespace = namespace;
	}
}
