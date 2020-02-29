package com.samples.responses.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.List;

@Data
@Generated("com.robohorse.robopojogenerator")
public class Embedded{

	@JsonProperty("customer")
	private List<CustomerItem> customer;
}