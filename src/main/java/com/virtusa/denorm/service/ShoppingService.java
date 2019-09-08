package com.virtusa.denorm.service;

import java.util.List;

import com.virtusa.denorm.dao.ShoppingDao;
import com.virtusa.denorm.entity.CardDetail;
import com.virtusa.denorm.entity.CategoryDetail;
import com.virtusa.denorm.entity.CustomerDetail;
import com.virtusa.denorm.entity.LoginDetail;
import com.virtusa.denorm.entity.ProductDetail;
import com.virtusa.denorm.entity.ShoppingCart;
import com.virtusa.denorm.exception.ShoppingException;


public class ShoppingService implements IShopping {
	private ShoppingDao dao=new ShoppingDao();

	public int doRegister(CustomerDetail customer) throws ShoppingException {
		return dao.doRegister(customer);
	}

	public List<CustomerDetail> doLogin(LoginDetail login) throws ShoppingException {
		return dao.doLogin(login);
	}

	public int doAddCategory(String name) throws ShoppingException {
		return dao.doAddCategory(name);
	}

	public List<CategoryDetail> getAllCategory() throws ShoppingException {
		return dao.getAllCategory();
	}

	public int doAddProduct(ProductDetail productDetail) throws ShoppingException {
		
		return dao.doAddProduct(productDetail);
	}

	public int doDeleteCategory(CategoryDetail categoryDetail) throws ShoppingException {
		
		return dao.doDeleteCategory(categoryDetail);
	}

	public List<ProductDetail> doListProduct(CategoryDetail categoryDetail) throws ShoppingException {
		
		return dao.doListProducts(categoryDetail);
	}

	public int doDeleteProduct(int productid) throws ShoppingException {

		return dao.doDeleteProduct(productid);
	}

	public List<ProductDetail> doViewProducts() throws ShoppingException {
		
		return dao.doViewProducts();
	}

	public List<ProductDetail> doSearch(String searchItem) throws ShoppingException {
		return dao.doSearch(searchItem);
	}

	public int doAddToCart(ShoppingCart cart) throws ShoppingException {
		
		return dao.doAddToCart(cart);
	}

	public List<ShoppingCart> viewCart(int customerId) throws ShoppingException {
		return dao.viewCart(customerId);
	}

	public int doDeleteCartItem(int cartId) throws ShoppingException {
		return dao.doDeleteCartItem(cartId);
	}

	public int doPayment(CardDetail cardDetail) throws ShoppingException {
		return dao.doPayment(cardDetail);
	}

	

	
	

	
}
