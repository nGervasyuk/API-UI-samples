package com.samples.responses.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Generated("com.robohorse.robopojogenerator")
public class Links{

	@JsonProperty("addresses")
	private Addresses addresses;

	@JsonProperty("cards")
	private Cards cards;

	@JsonProperty("self")
	private Self self;

	@JsonProperty("customer")
	private Customer customer;
}