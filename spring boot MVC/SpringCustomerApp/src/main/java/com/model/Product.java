package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name = "products")
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_ID_PK;

	private String description;

	private String name;

	private int price;

	// bi-directional many-to-many association to Order
	@ManyToMany
	@JoinTable(name = "orders_product", joinColumns = { @JoinColumn(name = "product_ID_FK") }, inverseJoinColumns = {
			@JoinColumn(name = "order_ID_FK") })
	private List<Order> orders;

	public Product() {
	}

	public int getProduct_ID_PK() {
		return this.product_ID_PK;
	}

	public void setProduct_ID_PK(int product_ID_PK) {
		this.product_ID_PK = product_ID_PK;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}