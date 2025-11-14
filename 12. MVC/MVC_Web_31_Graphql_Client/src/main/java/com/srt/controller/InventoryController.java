package com.srt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srt.request.Item;
import com.srt.request.ItemRequestDTO;
import com.srt.service.Inventoryservice;

@RestController
public class InventoryController {

	@Autowired
	private Inventoryservice inventoryservice;
	
	@GetMapping("/catalog")
	public List<Item> viewItems()
	{
	return inventoryservice.viewProduct();
		
	}

	@PostMapping("/update/stock")
	public Item viewItemsByCategory(@RequestBody ItemRequestDTO itemRequestDTO)
	{
		return inventoryservice.updateStock(itemRequestDTO);	
	}

	
	
}
