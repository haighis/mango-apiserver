package com.mango.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.util.UUID;

@Schema(description = "Setup object")
public class Setup {
	@JsonProperty(value="success", required=true, index = 10)
	@Schema(name="success", description = "Name of the Store Item.",
		example = "True/False", required = true)
	private boolean success;

	public Setup() {

	}

	public boolean getSuccess()
	{
		return this.success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}
}
