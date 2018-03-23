package com.marcin.product.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marcin.product.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Product> getProductList() {
		
		// get the current session factory
		Session currentSession = sessionFactory.getCurrentSession();
		
		// query the database
		Query<Product> query = currentSession.createQuery("from Product order by productName");
		
		// get the result list
		List<Product> product = query.getResultList();
		
		return product;
	}

	@Transactional
	@Override
	public void saveProduct(Product theProduct) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theProduct);
		
	}
	
	@Transactional
	@Override
	public Product updateProduct(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		// create a new object of Product type, and prepopulate it with the value of product of id=theId;
		Product theProduct = currentSession.get(Product.class, theId);
		return theProduct;
	}

	@Transactional
	@Override
	public void deleteProduct(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> query = currentSession.createQuery("delete from Product where id=:deleteId");
		query.setParameter("deleteId", theId);
		query.executeUpdate();
	}

	@Transactional
	@Override
	public List<Product> showBuyList() {
		
		// get the current session factory
		Session currentSession = sessionFactory.getCurrentSession();
		
		// query the database
		Query<Product> query = currentSession.createQuery("from Product p where p.status<p.quantityNeeded order by productName");
		
		// get the result list
		List<Product> product = query.getResultList();
		
		return product;
	}

	@Transactional
	@Override
	public Product setMax(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Product theProduct = currentSession.get(Product.class, theId);
		theProduct.setStatus(theProduct.getQuantityNeeded());
		return theProduct;
	}
	
}
