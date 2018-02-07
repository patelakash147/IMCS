package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name = "orders")
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "order_ID_PK")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int order_ID_PK;

	@Column(name = "custom_message")
	private String customMessage;

	@Temporal(TemporalType.DATE)
	@Column(name = "delivery_due_date")
	private Date deliveryDueDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "invoice_creation_date")
	private Date invoiceCreationDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "payment_due_date")
	private Date paymentDueDate;

	// bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name = "cust_ID_FK")
	private Customer customer;

	// bi-directional many-to-many association to Product
	@ManyToMany(mappedBy = "orders")
	private List<Product> products;

	public Order() {
	}

	public int getOrder_ID_PK() {
		return this.order_ID_PK;
	}

	public void setOrder_ID_PK(int order_ID_PK) {
		this.order_ID_PK = order_ID_PK;
	}

	public String getCustomMessage() {
		return this.customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

	public Date getDeliveryDueDate() {
		return this.deliveryDueDate;
	}

	public void setDeliveryDueDate(Date deliveryDueDate) {
		this.deliveryDueDate = deliveryDueDate;
	}

	public Date getInvoiceCreationDate() {
		return this.invoiceCreationDate;
	}

	public void setInvoiceCreationDate(Date invoiceCreationDate) {
		this.invoiceCreationDate = invoiceCreationDate;
	}

	public Date getPaymentDueDate() {
		return this.paymentDueDate;
	}

	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}