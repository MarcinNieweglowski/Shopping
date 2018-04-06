package com.marcin.product.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.marcin.product.validation.FieldsVerification;

@FieldsVerification(quantityNeeded="quantityNeeded", status="status", message="* Current value must be equal or lower than the quantity needed")
@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank
	@Size(min=2, message="Product name requires at least 2 characters")
	@Pattern(regexp="^[a-zA-Z0-9 ]*$", message="Must only contain letters / digits")		//^[A-Za-z ][A-Za-z0-9!@#$%^&* ]*$
	@Column(name="product_name")
	private String productName;
	

	@Min(value=1, message="Quantity needed must be at least 1")
	@Column(name="quantity_needed")
	private Integer quantityNeeded;
	
	@Min(value=0, message="Status must be at least 0")
	@Column(name="status")
	private Integer status;

	@ManyToOne(cascade={CascadeType.PERSIST, 
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.REFRESH})
	@JoinColumn(name="user_id_fk")
	private User user;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantityNeeded() {
		return quantityNeeded;
	}

	public void setQuantityNeeded(Integer quantityNeeded) {
		this.quantityNeeded = quantityNeeded;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", quantityNeeded=" + quantityNeeded + ", status="
				+ status + "]";
	}
	
	
}
