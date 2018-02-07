package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name = "customers")
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cust_ID_PK")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custIDPK;

	@Column(name = "billing_city")
	private String billingCity;

	@Column(name = "billing_country")
	private String billingCountry;

	@Column(name = "billing_state")
	private String billingState;

	@Column(name = "billing_street")
	private String billingStreet;

	@Column(name = "billing_zip")
	private String billingZip;

	private String company;

	@Column(name = "display_name")
	private String displayName;

	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "other_details")
	private String otherDetails;

	@Column(name = "print_on_check_as")
	private String printOnCheckAs;

	@Column(name = "shipping_city")
	private String shippingCity;

	@Column(name = "shipping_country")
	private String shippingCountry;

	@Column(name = "shipping_state")
	private String shippingState;

	@Column(name = "shipping_street")
	private String shippingStreet;

	@Column(name = "shipping_zip")
	private String shippingZip;

	private String suffix;

	private String title;

	// bi-directional many-to-one association to Order
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orders;

	public Customer() {
	}

	public int getCustIDPK() {
		return this.custIDPK;
	}

	public void setCustIDPK(int cust_ID_PK) {
		this.custIDPK = cust_ID_PK;
	}

	public String getBillingCity() {
		return this.billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingCountry() {
		return this.billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public String getBillingState() {
		return this.billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getBillingStreet() {
		return this.billingStreet;
	}

	public void setBillingStreet(String billingStreet) {
		this.billingStreet = billingStreet;
	}

	public String getBillingZip() {
		return this.billingZip;
	}

	public void setBillingZip(String billingZip) {
		this.billingZip = billingZip;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getOtherDetails() {
		return this.otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public String getPrintOnCheckAs() {
		return this.printOnCheckAs;
	}

	public void setPrintOnCheckAs(String printOnCheckAs) {
		this.printOnCheckAs = printOnCheckAs;
	}

	public String getShippingCity() {
		return this.shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingCountry() {
		return this.shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public String getShippingState() {
		return this.shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public String getShippingStreet() {
		return this.shippingStreet;
	}

	public void setShippingStreet(String shippingStreet) {
		this.shippingStreet = shippingStreet;
	}

	public String getShippingZip() {
		return this.shippingZip;
	}

	public void setShippingZip(String shippingZip) {
		this.shippingZip = shippingZip;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setCustomer(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setCustomer(null);

		return order;
	}

}