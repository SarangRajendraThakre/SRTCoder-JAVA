package com.srt.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemsR {

	private String prodName;
	private String prodPrice;
	private String prodQuantity;
	private List<String> characteristics;
	
	
	
	
	
}
