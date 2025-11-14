package com.srt.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import com.srt.request.Item;
import com.srt.request.ItemRequestDTO;

@Component
public class InventoryClient {

	@Autowired
	private HttpGraphQlClient httpGraphQlClient;

	public List<Item> getItems() {
		String graphQlQuery = "query GetProduct {\r\n" + "    getProduct {\r\n" + "        name\r\n"
				+ "        price\r\n" + "    }\r\n" + "}\r\n" + "";

		return httpGraphQlClient.document(graphQlQuery).retrieve("getProduct").toEntityList(Item.class).block();
	}

	public List<Item> getProductByCategory(String category) {
		String graphQlString = String.format("query GetProductByCategory {\r\n"
				+ "    getProductByCategory(category: \"%s\") {\r\n" + "        id\r\n" + "        name\r\n"
				+ "        category\r\n" + "        price\r\n" + "        stock\r\n" + "    }\r\n" + "}\r\n" + "",
				category);

		return httpGraphQlClient.document(graphQlString).retrieve("getProductByCategory").toEntityList(Item.class)
				.block();
	}
	
	
	// In com.srt.client.InventoryClient.java

	public Item receiveNewShipment(ItemRequestDTO itemRequestDTO )
	{
	    // FIX 1: Change variable definition from Int! to ID!
	    // FIX 2: Send the ID value as a String (by using .toString())
	    
	    String graphString = "mutation UpdateNewShipment($id: ID!, $stock: Int!) {\r\n"
	        + "    updateNewShipment(id: $id, stock: $stock) {\r\n"
	        + "        name\r\n"
	        + "        price\r\n"
	        + "        stock\r\n"
	        + "    }\r\n"
	        + "}\r\n";
	        
	    // Use .variable() to send data
	    return httpGraphQlClient.document(graphString)
	        .variable("id", itemRequestDTO.getId().toString())   // <-- CRITICAL: Pass ID as a String
	        .variable("stock", itemRequestDTO.getStock()) 
	        .retrieve("updateNewShipment")
	        .toEntity(Item.class)
	        .block();
	}

}
