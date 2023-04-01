package com.mango.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;
/*
	Kind - Kind reference entity. We don't relate each row to it's kind. For example if you have an Application then there isn't
	a Kind row related via Foreign KindId.
* */
@Schema(description = "Kind object")
@Entity
@Table(name = "kinds")
@Getter @Setter
public class Kind {
//	@JsonProperty(value="id", required=true, index = 10)
//	@Schema(description = "Unique identifier of the Book.",
//			example = "1", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	//Getters and setters omitted for brevity
//	public UUID getId() {
//		return id;
//	}
//	@JsonProperty(value="name", required=true, index = 20)
//	@Schema(name="name", description = "Name of the Store Item.",
//		example = "Forum", required = true)
	@Column(name = "name")
	private String name;

//	@JsonProperty(value="description", required=true, index = 30)
//	@Schema(name = "description", description = "Description fo the Store Item.",
//		example = "Forum Application for PHP", required = true)
	@Column(name = "description")
	private String description;

	public Kind() {
	}

	public Kind(String name, String description) {
		this.name = name;
		this.description = description;
	}

//	@Column(name = "name")
//	public String getName()
//	{
//		return this.name;
//	}
//
//	public void setName(String name)
//	{
//		this.name = name;
//	}
//
//	@Column(name = "description")
//	public String getDescription() {
//		return this.description;
//	}
//
//	public void setDescription(String description)
//	{
//		this.description = description;
//	}
}
