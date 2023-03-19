package com.mango.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.util.UUID;
/*
	ShellType - A Shell Type provides a classification and sub classification for Shell Applications. The classification such as Frontend, Backend,
	Database, infrastructure are used as values in the classification column value. The Sub classification such as Desktop Electron, Desktop WPF, Web,
	Mobile web, mobile ios, mobile android provide more specific clarification for the shell type. The Shell Type encapsulates specific
	attributes that describe the application shell and can be used by consumers for programmatic metadata use cases.
* */
@Schema(description = "Shell Type object")
@Entity
@Table(name = "shell_types")
public class ShellType {

	@JsonProperty(value="id")
	@Schema(description = "Unique identifier of the Shell Type.", hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	public UUID getId() {
		return id;
	}

	@JsonProperty(value="classification", required=true, index = 20)
	@Schema(name="classification", description = "Classification of the Shell Type.",
		example = "Frontend, Backend, Database, Infrastructure", required = true)
	private String classification;

	@JsonProperty(value="subClassification", required=true, index = 30)
	@Schema(name="subClassification", description = "Sub Classification of the Shell Type.",
			example = "Electron, ", required = true)
	private String subClassification;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "language_id", referencedColumnName = "id")
//	private Label language;
//
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "framework_id", referencedColumnName = "id")
//	private Label framework;

	@JsonProperty(value="description", required=true, index = 40)
	@Schema(name = "description", description = "Description fo the Store Item.",
		example = "Forum Application for PHP", required = true)
	private String description;

	public ShellType() {
	}

	public ShellType(String classification, String subClassification, String description) {
		this.classification = classification;
		this.subClassification = subClassification;
		this.description = description;
	}

	@Column(name = "classification")
	public String getClassification()
	{
		return this.classification;
	}
	public void setClassification(String classification)
	{
		this.classification = classification;
	}

	@Column(name = "sub_classification")
	public String getSubClassification()
	{
		return this.subClassification;
	}
	public void setSubClassification(String subClassification)
	{
		this.subClassification = subClassification;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
}
