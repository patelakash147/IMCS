package dao;

import java.sql.SQLException;

import pojo.Customer;
import pojo.Order;

public interface CustomerDAO {

	public Customer findCustomerById(int id) throws SQLException;

	public Order findOrderById(int id) throws SQLException;

	public Customer findAddressById(int id) throws SQLException;

	public boolean addCustomer(Customer c) throws SQLException;

	public boolean addAddress(Customer c) throws SQLException;

	public boolean updateCustomer(Customer c) throws SQLException;

	public boolean updateAddress(Customer c) throws SQLException;

	public void addOrder();

	public void updateOrder();

}
