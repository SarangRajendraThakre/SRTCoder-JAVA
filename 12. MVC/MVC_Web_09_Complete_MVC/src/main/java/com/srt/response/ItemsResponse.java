package com.srt.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemsResponse {

	private String prodName;
	private String prodPrice;
	private String prodQuantity;
	private List<String> characteristics;
	
	
	
	
	
}
