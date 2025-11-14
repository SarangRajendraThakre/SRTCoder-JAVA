package com.srt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srt.client.InventoryClient;
import com.srt.request.Item;
import com.srt.request.ItemRequestDTO;

@Service
public class Inventoryservice {

	@Autowired
	private InventoryClient inventoryClient;
	
	public List<Item> viewProduct()
	{
	  return	inventoryClient.getItems();
	}
	
	public List<Item> getItemByCategory(String category)
	{
		return inventoryClient.getProductByCategory(category);
	}
	
	public Item updateStock(ItemRequestDTO itemRequestDTO)
	{
		return inventoryClient.receiveNewShipment(itemRequestDTO);
	}
	
	
}
