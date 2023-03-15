//package com.openapi.model;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.v3.oas.annotations.media.Schema;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import java.util.Optional;
//
//@Schema(description = "Backpack object")
//@Entity
//@Table(name = "backpacks")
//public class Backpack extends BaseEntity {
//
//	// ReferenceId, Label, Kind (Application, )
//	// a way to gather all things related to apps such as Applications, ApplicationInstalls, Application Shells
//	// ants, glue
//
////	@Id
////	@GeneratedValue(strategy = GenerationType.AUTO)
////	private long id;
//	@JsonProperty(value="Application Name", required=true, index = 10)
//	@Schema(description = "Name of the Application.",
//		example = "Shop", required = true)
//	//@Column(name = "application_name")
//	private String application_name;
//
//@JsonProperty(value="Application Url", required=true, index = 20)
//	@Schema(description = "Url of the Application.",
//		example = "http://someurltoapplicationjsmodule", required = true)
//	//@Column(name = "application_url")
//	private String application_url;
//
//	@JsonProperty(value="Installed Instance Code", required=true, index = 30)
//	@Schema(description = "Installed Instance Code of the Application.",
//		example = "SDFSDFS", required = true)
//	@Column(name = "installed_instance_code")
//	private String installed_instance_code;
//
////	@Column(name = "namespace")
////	private String namespace;
////
////	@Column(name = "label")
////	private String label;
//
////@JsonProperty(value="Status", required=true, index = 40)
////	@Schema(description = "Status of the Application Install.",
////		example = "ACTIVE,INACTIVE", required = true)
////	@Column(name = "status")
////	private boolean status;
//
//	public Backpack() {
//
//	}
//
//	public Backpack(String application_name, String namespace) {
//		this.application_name = application_name;
//		this.application_url = applicationUrl;
////		if(label.isPresent()){
////			this.label = label.get();
////		}
////		this.namespace = namespace;
//		//this.status = status;
//	}
//
////	public Long getId() {
////		return this.id;
////	}
////
////	public void setId(long id) {
////		this.id = id;
////	}
//
//	public String getTitle() {
//		return application_name;
//	}
//
//	public void setTitle(String title) {
//		this.application_name = title;
//	}
//
//	public String getApplicationUrl() {
//		return application_url;
//	}
//
//	public void setApplicationUrl(String applicationUrl) {
//		this.application_url = applicationUrl;
//	}
//
////	public String getNamespace() {
////		return namespace;
////	}
////
////	public void setNamespace(String namespace) {
////		this.namespace = namespace;
////	}
//
//	@Override
//	public String toString() {
//		return "Application Install [application_name=" + application_name + ", applicationUrl=" + application_url + "]";
//	}
//}
