//package com.mango.api.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.v3.oas.annotations.media.Schema;
//import lombok.Setter;
//import lombok.Getter;
//import javax.persistence.*;
//import java.util.UUID;
//
//@Schema(description = "Artifact object")
//@Getter
//@Setter
//public class ArtifactDto {
//	@JsonProperty(value="id", required=true, index = 10)
//	@Schema(description = "Unique identifier of the Item.",
//			example = "1", required = true)
//	private UUID id;
//
//	//Getters and setters omitted for brevity
//	public UUID getId() {
//		return id;
//	}
//
//	@JsonProperty(value="name", required=true, index = 10)
//	@Schema(name="name", description = "Name of the Artifact.",
//		example = "Forum", required = true)
//	private String name;
//
//	@JsonProperty(value="url", required=true, index = 20)
//	@Schema(name = "url", description = "Url of the Artifact.",
//		example = "", required = true)
//	private String url;
//
//	@JsonProperty(value="version", required=true, index = 20)
//	@Schema(name = "version", description = "Version of the Artifact.",
//			example = "", required = true)
//	private String version;
//
//	@JsonProperty(value="isCurrent", required=true, index = 20)
//	@Schema(name = "isCurrent", description = "isCurrent of the Artifact.",
//			example = "", required = true)
//	private Boolean isCurrent;
//
//	@JsonProperty(value="status", required=true, index = 30)
//	@Schema(name="status", description = "Status of the Artifact.",
//		example = "ACTIVE, INACTIVE", required = true)
//	private String status;
//
//	public ArtifactDto() {
//
//	}
//
//	public ArtifactDto(String name, String url, String version, boolean isCurrent, String status, String namespace) {
//		this.name = name;
//		this.version = version;
//		this.url = url;
//		this.isCurrent = isCurrent;
//		this.status = status;
//	}
//
//	@JsonProperty(value="namespace", required=true, index = 50)
//	@Schema(description = "Namespace of the item",
//			example = "test", required = false)
//	private String namespace;
//}
