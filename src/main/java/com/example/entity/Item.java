package com.example.entity;

import java.time.LocalDateTime;

public class Item {
	private int id;
	private String name;
	private int price;
	private LocalDateTime deletedAt;
	private int categoryId;
	private int stock;

	private Category category;

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getDeleteAt() {
		return this.deletedAt;
	}
	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	public int getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getStock() {
		return this.stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public Category getCategory() {
		return this.category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
