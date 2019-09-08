package com.virtusa.denorm.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CategoryDetail {
	@Id
	@GeneratedValue
	private int categoryId;
	private String categoryName;

	public CategoryDetail(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public CategoryDetail(int categoryId) {
		super();
		this.categoryId = categoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public CategoryDetail() {
	}

}
