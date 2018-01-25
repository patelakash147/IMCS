package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CustomerDAO;
import pojo.Customer;
import pojo.Order;

public class CustomerDAOimpl implements CustomerDAO {

	Connection con;

	public CustomerDAOimpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer findCustomerById(int id) throws SQLException {
		ResultSet rs = null;
		Customer cust = new Customer();

		try {
			rs = con.createStatement().executeQuery(
					"select cust_ID_PK,title, first_name, middle_name,last_name, suffix, email, company, display_name,print_on_check_as from customers where cust_ID_PK ="
							+ id);
			while (rs.next()) {
				cust.setCustID(rs.getInt("cust_ID_PK"));
				cust.setTitle(rs.getString("title"));
				cust.setFirstname(rs.getString("first_name"));
				cust.setMiddleName(rs.getString("middle_name"));
				cust.setLast_name(rs.getString("last_name"));
				cust.setSuffix(rs.getString("suffix"));
				cust.setEmail(rs.getString("email"));
				cust.setCompany(rs.getString("company"));
				cust.setDisplaName(rs.getString("display_name"));
				cust.setPrintOnCheckAs(rs.getString("print_on_check_as"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		return cust;
	}

	@Override
	public Order findOrderById(int id) throws SQLException {
		ResultSet rs = null;
		Order order = new Order();

		try {
			rs = con.createStatement().executeQuery(
					"select order_ID_PK, invoice_creation_date, delivery_due_date, payment_due_date,custom_message from orders where cust_ID_FK ="
							+ id);
			while (rs.next()) {
				order.setOrderIDPK(rs.getInt("order_ID_PK"));
				order.setInvoiceCreationDate(rs.getDate("invoice_creation_date"));
				order.setDeliveryDueDate(rs.getDate("delivery_due_date"));
				order.setPaymentDueDate(rs.getDate("payment_due_date"));
				order.setCustomMessage(rs.getString("custom_message"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		return order;

	}

	@Override
	public Customer findAddressById(int id) throws SQLException {
		ResultSet rs = null;
		Customer cust = new Customer();

		try {
			rs = con.createStatement().executeQuery(
					"select  billing_street, billing_city, billing_state, billing_zip, billing_country,shipping_street, shipping_city,shipping_state,shipping_zip, shipping_country, other_details from customers where cust_ID_PK="
							+ id);
			while (rs.next()) {
				cust.setBillingStreet(rs.getString("billing_street"));
				cust.setBillingCity(rs.getString("billing_city"));
				cust.setBillingState(rs.getString("billing_state"));
				cust.setBillingZip(rs.getString("billing_zip"));
				cust.setBillingCountry(rs.getString("billing_country"));
				cust.setShippingStreet(rs.getString("shipping_street"));
				cust.setShippingCity(rs.getString("shipping_city"));
				cust.setShippingState(rs.getString("shipping_state"));
				cust.setShippingZip(rs.getString("shipping_zip"));
				cust.setShippingCountry(rs.getString("shipping_country"));
				cust.setOtherDetails(rs.getString("other_details"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		return cust;
	}

	@Override
	public boolean addCustomer(Customer c) throws SQLException {
		ResultSet rs = null;
		try {
			String insertQuery = "insert into customers (title,first_name,middle_name,last_name,suffix,email,company,display_name,print_on_check_as) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, c.getTitle());
			pstmt.setString(2, c.getFirstname());
			pstmt.setString(3, c.getMiddleName());
			pstmt.setString(4, c.getLast_name());
			pstmt.setString(5, c.getSuffix());
			pstmt.setString(6, c.getEmail());
			pstmt.setString(7, c.getCompany());
			pstmt.setString(8, c.getDisplaName());
			pstmt.setString(9, c.getPrintOnCheckAs());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		return true;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		try {
			con.createStatement()
					.executeUpdate("update customers SET  title ='" + c.getTitle() + "', first_name ='"
							+ c.getFirstname() + "', middle_name='" + c.getMiddleName() + "', last_name='"
							+ c.getLast_name() + "',\r\n" + " suffix='" + c.getSuffix() + "', email='" + c.getEmail()
							+ "', company='" + c.getCompany() + "', display_name ='" + c.getDisplaName() + "', \r\n"
							+ " print_on_check_as='" + c.getPrintOnCheckAs() + "' WHERE cust_ID_PK=" + c.getCustID());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean updateAddress(Customer c) {
		try {
			con.createStatement()
					.executeUpdate("update customers SET billing_street='" + c.getBillingStreet() + "', billing_city='"
							+ c.getBillingCity() + "',  billing_state='" + c.getBillingState() + "',  billing_zip='"
							+ c.getBillingZip() + "',  billing_country='" + c.getBillingCountry()
							+ "',  shipping_street='" + c.getShippingStreet() + "', shipping_city ='"
							+ c.getShippingCity() + "', shipping_state='" + c.getShippingState() + "',  shipping_zip ='"
							+ c.getShippingZip() + " ', shipping_country='" + c.getShippingCountry()
							+ "',other_details='" + c.getOtherDetails() + "' where cust_ID_PK =" + c.getCustID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void addOrder() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOrder() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addAddress(Customer c) throws SQLException {
		try {
			con.createStatement()
					.executeUpdate("update customers set billing_street ='" + c.getBillingStreet() + "' ,billing_city='"
							+ c.getBillingCity() + "' ,billing_state='" + c.getBillingState() + "', billing_zip='"
							+ c.getBillingZip() + "', billing_country ='" + c.getBillingCountry()
							+ "',shipping_street ='" + c.getShippingStreet() + "',shipping_city='" + c.getShippingCity()
							+ "' ,shipping_state ='" + c.getShippingState() + "',shipping_zip ='" + c.getShippingZip()
							+ "',shipping_country='" + c.getShippingCountry() + "', other_details='"
							+ c.getOtherDetails() + "' where cust_ID_PK =" + c.getCustID());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
