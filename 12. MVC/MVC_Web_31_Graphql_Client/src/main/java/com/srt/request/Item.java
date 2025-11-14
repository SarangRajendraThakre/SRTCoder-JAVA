package com.srt.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Item {

	
	 private Integer	id;
	 private String	name;
	 private String	category;
	 private Float	price;
	 private Integer	stock;

	
}
