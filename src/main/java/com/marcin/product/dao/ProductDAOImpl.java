package com.marcin.product.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.product.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProductList() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> query = currentSession.createQuery("from Product order by productName");
		List<Product> product = query.getResultList();
		return product;
	}

	@Override
	public void saveProduct(Product theProduct) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.merge(theProduct);	//saveOrUpdate causes org.hibernate.NonUniqueObjectException !
		
	}
	
	@Override
	public Product updateProduct(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		// create a new object of Product type, and prepopulate it with the value of product of id=theId;
		Product theProduct = currentSession.get(Product.class, theId);
		return theProduct;
	}

	@Override
	public void deleteProduct(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> query = currentSession.createQuery("delete from Product where id = :deleteId");
		query.setParameter("deleteId", theId);
		query.executeUpdate();
	}

	@Override
	public List<Product> showBuyList() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> query = currentSession.createQuery("from Product p where p.status<p.quantityNeeded order by productName");
		List<Product> product = query.getResultList();
		return product;
	}

	@Override
	public Product setMax(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Product theProduct = currentSession.get(Product.class, theId);
		theProduct.setStatus(theProduct.getQuantityNeeded());
		return theProduct;
	}

//	@Override
//	public Product searchProduct(String productName) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		Product theProduct = null;
////		try {
//			Query<Product> query = currentSession.createQuery("from Product p where p.productName = :searchResult");
//			query.setParameter("searchResult", productName);
////			theProduct = currentSession.get(Product.class, productName);
//			theProduct = query.getSingleResult();
//			System.out.println("____________ input productName = " + productName);
//			System.out.println(">>>> productName = " + theProduct.getProductName());
//			System.out.println(">>>> quantityNeeded = " + theProduct.getQuantityNeeded());
//			System.out.println(">>>> status = " + theProduct.getStatus());
////		} catch(NoResultException exc) {
////			
////		}
//		System.out.println("____________ input productName = " + productName);
//		System.out.println(">>>> productName = " + theProduct.getProductName());
//		System.out.println(">>>> quantityNeeded = " + theProduct.getQuantityNeeded());
//		System.out.println(">>>> status = " + theProduct.getStatus());
////		query.executeUpdate();
//		return theProduct;
//	}
}
