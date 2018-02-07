package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerOperation;
import com.dao.OrderOperation;
import com.dao.ProductOperation;
import com.model.Customer;
import com.model.Order;
import com.model.Product;

@Service
public class CustomerService implements ICutomerService {

	@Autowired
	CustomerOperation customerDAO;

	@Autowired
	OrderOperation orderDAO;

	@Autowired
	ProductOperation productDAO;

	@Override
	public Customer findCustomerById(int id) {
		Customer c = customerDAO.findCustomerBycustIDPK(id);
		return c;
	}

	@Override
	public synchronized boolean createCustomer(Customer c) {
		customerDAO.save(c);
		return true;
	}

	@Override
	public Iterable<Customer> getOrder(int id) {

		Iterable<Customer> o = customerDAO.findAll();

		return o;
	}

	@Override
	public int custIDreturn() {
		List<Customer> list = new ArrayList<>();
		list = customerDAO.findAll();
		int num = list.size();
		return num;
	}

	@Override
	public List<Order> getOrderbyID(int id) {

		List<Order> list = new ArrayList<>();
		list = orderDAO.findOrderbyID(id);
		return list;
	}

	@Override
	public Product getProductbyID(int id) {

		Product p = productDAO.findProductByid(id);

		return p;
	}

	@Override
	public boolean updateCustomer(String title, String fname, String mname, String lname, String suffix, String company,
			String display, String check, int id) {
		customerDAO.updateCustomer(title, fname, mname, lname, suffix, company, display, check, id);
		return true;
	}

}
