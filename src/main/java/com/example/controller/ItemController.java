package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Category;
import com.example.entity.Item;
import com.example.form.ItemForm;
import com.example.service.CategoryService;
import com.example.service.ItemService;

@Controller
public class ItemController {
	private final ItemService itemService;
	private final CategoryService categoryService;

	@Autowired
	public ItemController(ItemService itemService, CategoryService categoryService) {
		this.itemService = itemService;
		this.categoryService = categoryService;
	}

	@GetMapping("/index")
	public String index(Model model) {
		List<Item> items = this.itemService.findAll();
		model.addAttribute("items", items);
		return "index";
	}

	@GetMapping("/create")
	public String showCreate(@ModelAttribute ItemForm itemForm, Model model) {
		List<Category> categories = this.categoryService.findAll();
		model.addAttribute("categories", categories);
		return "create";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute ItemForm itemForm) {
		this.itemService.insert(itemForm.getName(), itemForm.getPrice(), itemForm.getCategoryId());
		return "redirect:/index";
	}

	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable("id") Integer id,
			@ModelAttribute ItemForm itemForm, Model model) {
		Item item = this.itemService.findById(id);
		itemForm.setName(item.getName());
		itemForm.setPrice(item.getPrice());
		itemForm.setCategoryId(item.getCategory().getId());
		List<Category> categories = this.categoryService.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("id", id);
		return "edit";
	}

	@PostMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, ItemForm itemForm) {
		this.itemService.update(id, itemForm.getName(), itemForm.getPrice(), itemForm.getCategoryId());
		return "redirect:/index";
	}

	@PostMapping("/delete/{id}")
	public String deleteById(@PathVariable Integer id) {
		this.itemService.deleteById(id);
		return "redirect:/index";
	}


}
