package com.virtusa.denorm.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.virtusa.denorm.entity.CardDetail;
import com.virtusa.denorm.entity.CategoryDetail;
import com.virtusa.denorm.entity.CustomerDetail;
import com.virtusa.denorm.entity.LoginDetail;
import com.virtusa.denorm.entity.ProductDetail;
import com.virtusa.denorm.entity.ShoppingCart;
import com.virtusa.denorm.exception.ShoppingException;
import com.virtusa.denorm.util.ConnectionUtil;

public class ShoppingDao {
	public int doRegister(CustomerDetail customer) throws ShoppingException {
		Session session = ConnectionUtil.getConnection();
		Transaction transaction = session.beginTransaction();
		session.save(customer);
		transaction.commit();
		session.close();
		return customer.getCustomerId();

	}

	public List<CustomerDetail> doLogin(LoginDetail login) throws ShoppingException {
		Session session = ConnectionUtil.getConnection();
		Transaction transaction = session.beginTransaction();
		List<CustomerDetail> list = null;
		Query query = session.createQuery(
				"from CustomerDetail " + "c where c.customerEmail=:usernameParam and c.customerPassword=:userPassword");
		query.setParameter("usernameParam", login.getUserName());
		query.setParameter("userPassword", login.getPassword());

		if (query != null) {
			list = query.list();
		}
		transaction.commit();
		session.close();
		return list;
	}

	public int doAddCategory(String name) throws ShoppingException {
		Session session = ConnectionUtil.getConnection();
		Transaction transaction = session.beginTransaction();
		CategoryDetail categoryDetail = new CategoryDetail(name);
		session.save(categoryDetail);
		transaction.commit();
		session.close();
		return categoryDetail.getCategoryId();
	}

	public List<CategoryDetail> getAllCategory() throws ShoppingException {
		Session session = ConnectionUtil.getConnection();
		Transaction transaction = session.beginTransaction();
		List<CategoryDetail> list = null;
		Query query = session.createQuery("from CategoryDetail c");
		list = query.list();
		transaction.commit();
		session.close();
		return list;

	}

	public int doAddProduct(ProductDetail productDetail) throws ShoppingException {
		Session session = ConnectionUtil.getConnection();
		Transaction transaction = session.beginTransaction();
		List<ProductDetail> list = new ArrayList<ProductDetail>();
		list.add(productDetail);

		session.save(productDetail);
		// session.update(categoryDetail);
		transaction.commit();
		session.close();
		return productDetail.getProductId();
	}

	public int doDeleteCategory(CategoryDetail categoryDetail) throws ShoppingException {
		Session session = ConnectionUtil.getConnection();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("delete ProductDetail where category = :categoryId");
		query.setParameter("categoryId", categoryDetail);
		int result = query.executeUpdate();
		session.delete(categoryDetail);
		transaction.commit();
		session.close();
		return 1;
	}

	public int doDeleteProduct(int productId) throws ShoppingException {
		Session session = ConnectionUtil.getConnection();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("delete ProductDetail where productId = :categoryId");
		query.setParameter("categoryId", productId);
		int result = query.executeUpdate();
		transaction.commit();
		session.close();
		return 1;
	}

	public List<ProductDetail> doListProducts(CategoryDetail categoryDetail) throws ShoppingException {
		Session session = ConnectionUtil.getConnection();
		Transaction transaction = session.beginTransaction();
		List<ProductDetail> list = null;
		Query query = session.createQuery("from ProductDetail p where category = :categoryId");
		query.setParameter("categoryId", categoryDetail);
		list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

	public List<ProductDetail> doViewProducts() throws ShoppingException {
		Session session = ConnectionUtil.getConnection();
		Transaction transaction = session.beginTransaction();
		List<ProductDetail> list = null;
		Query query = session.createQuery("from ProductDetail p");
		list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

	public List<ProductDetail> doSearch(String name) throws ShoppingException {
		Session session = ConnectionUtil.getConnection();
		Transaction transaction = session.beginTransaction();
		List<ProductDetail> list = null;
		List<CategoryDetail> list1 = null;
		Query query1 = session.createQuery("from CategoryDetail p where p.categoryName=:name");
		query1.setParameter("name", name);
		list1 = query1.list();
		if(list1!=null) {
		for(CategoryDetail l:list1) {
		CategoryDetail categoryDetail =new CategoryDetail(l.getCategoryId());
		Query query = session.createQuery("from ProductDetail p where p.category=:name");
		query.setParameter("name", categoryDetail);
		list = query.list();
		}
		}
		else {
			list=null;
		}
		transaction.commit();
		session.close();
		return list;
	}

	public int doAddToCart(ShoppingCart cart) throws ShoppingException {
		Session session = ConnectionUtil.getConnection();
		Transaction transaction = session.beginTransaction();
		session.save(cart);
		transaction.commit();
		session.close();
		return cart.getCartId();

	}

	public List<ShoppingCart> viewCart(int customerId) throws ShoppingException {
		Session session = ConnectionUtil.getConnection();
		Transaction transaction = session.beginTransaction();
		List<ShoppingCart> listS = new ArrayList<ShoppingCart>();
		List<ProductDetail> list = new ArrayList<ProductDetail>();
		List<ShoppingCart> listP = new ArrayList<ShoppingCart>();
		String hql = "from ShoppingCart S where S.customerId=" + customerId;
		Query query = session.createQuery(hql);
		listS = query.list();
		for (ShoppingCart s : listS) {
			Query query1 = session.createQuery("from ProductDetail where productId=:product");
			query1.setParameter("product", s.getProduct().getProductId());
			list = query1.list();
			for (ProductDetail p : list) {
				ProductDetail product=new ProductDetail(p.getProductName(),p.getProductImage(),
						p.getProductPrice(),p.getProductDescription(),p.getProductStock(),p.getCategory());
				ShoppingCart shoppingCart=new ShoppingCart(s.getCartId(),product, customerId, s.getCartDate());
				listP.add(shoppingCart);
				}
		}
		transaction.commit();
		session.close();
		return listP;

	}
	public int doDeleteCartItem(int cartId) throws ShoppingException{
		Session session = ConnectionUtil.getConnection();
		Transaction transaction = session.beginTransaction();
		ShoppingCart cart=new ShoppingCart();
		cart.setCartId(cartId);
		session.delete(cart);
		transaction.commit();
		session.close();
		return 1;		
	}

	public int doPayment(CardDetail cardDetail) throws ShoppingException {
		Session session = ConnectionUtil.getConnection();
		Transaction transaction = session.beginTransaction();
		session.delete(cardDetail);
		transaction.commit();
		session.close();
		return 1;		
	}

}