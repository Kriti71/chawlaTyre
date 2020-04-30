package com.chawla.tyre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.chawla.tyre.entity.Inventory;
import com.chawla.tyre.service.InventoryService;

@Controller
public class InventoryController {

	@Autowired
	private InventoryService service;

	@GetMapping("/addProduct")
	public String addInventory() {
		return "addProduct";
	}

	@GetMapping("/viewProduct")
	public String viewInventory() {
		return "inventoryQuery";
	}

	@PostMapping("/saveProduct")
	public String saveInventory(Inventory inventory) {
		inventory = service.save(inventory);
		if (inventory != null) {
			return "viewDetails";
		} else {
			return "failed";
		}
	}

	@GetMapping("/findProduct")
	public String findProduct(Inventory inventory, Model model) {
		List<Inventory> inventoryList = service.findProducts(inventory);
		model.addAttribute("inventoryList", inventoryList);
		return "viewInventory";
	}
}
