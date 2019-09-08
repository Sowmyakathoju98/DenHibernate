package com.virtusa.denorm.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
public class ProductDetail {
	@Id
	@GeneratedValue
	private int productId;
	private String productName;
	private String productImage;
	private float productPrice;
	private String productDescription;
	private int productStock;
	@ManyToOne
    @JoinColumn(name ="FK_CategoryId")
	private CategoryDetail category;

	public ProductDetail(int productId) {
		super();
		this.productId = productId;
	}

	public ProductDetail(int productId, String productName, String productImage, float productPrice,
			String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}

	public ProductDetail(String productName, String productImage, float productPrice, String productDescription,
			int productStock, CategoryDetail category) {
		super();
		this.productName = productName;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productStock = productStock;
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductDetail [productId=" + productId + ", productName=" + productName + ", productImage="
				+ productImage + ", productPrice=" + productPrice + ", productDescription=" + productDescription
				+ ", productStock=" + productStock + ", category=" + category + "]";
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public CategoryDetail getCategory() {
		return category;
	}

	public void setCategory(CategoryDetail category) {
		this.category = category;
	}

	public ProductDetail() {
	}

}
