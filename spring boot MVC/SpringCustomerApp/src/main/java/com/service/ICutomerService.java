package com.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.model.Customer;
import com.model.Order;
import com.model.Product;

public interface ICutomerService {

	Customer findCustomerById(int id);

	boolean createCustomer(Customer c);
	
	boolean updateCustomer( String title,String fname,String mname,String lname,String suffix,String company,String display,String check,int id);

	int custIDreturn();

	Iterable<Customer> getOrder(int id);

	List<Order> getOrderbyID(int id);

	Product getProductbyID(int id);

}
