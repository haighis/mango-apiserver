package com.mango.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Schema(description = "Item Dto object")
@Getter @Setter
public class ItemDto {
//	@JsonProperty(value="name", required=true, index = 10)
//	@Schema(name="name", description = "Name of the Store Item.",
//		example = "Forum", required = true)
	private String name;

//	@JsonProperty(value="description", required=true, index = 20)
//	@Schema(name = "description", description = "Description fo the Store Item.",
//		example = "Forum Application for PHP", required = true)
	private String description;

//	@JsonProperty(value="status", required=true, index = 30)
//	@Schema(name="status", description = "Installed Instance Code of the Application.",
//		example = "ACTIVE, INACTIVE", required = true)
	private String status;


//	@JsonProperty(value="url", required=true, index = 30)
//	@Schema(name="url", description = "url",
//			example = "http://", required = true)
	private String url;

//	@JsonProperty(value="version", required=true, index = 30)
//	@Schema(name="version", description = "version",
//			example = "http://", required = true)
	private String version;

	private String namespace;

	public ItemDto() {
	}

	public ItemDto(String name, String description, String version, String status, String namespace, String url) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.namespace = namespace;
		this.url = url;
		this.version = version;
	}
}
