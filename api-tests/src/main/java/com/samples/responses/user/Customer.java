package com.samples.responses.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Generated("com.robohorse.robopojogenerator")
public class Customer{

	@JsonProperty("href")
	private String href;
}