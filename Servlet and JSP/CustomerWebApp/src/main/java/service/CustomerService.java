package service;

import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import cmn.UserInfo;

public interface CustomerService {

	boolean validateUser(UserInfo user, ServletConfig servletConfig);

	public boolean addCustomer(HttpServletRequest request) throws SQLException;

	public boolean UpdateCustomer(HttpServletRequest request) throws SQLException;

	public boolean addAddress(HttpServletRequest request) throws SQLException;

	public boolean updateAddress(HttpServletRequest request) throws SQLException;

}
