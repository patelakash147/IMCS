package service;

import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import cmn.UserInfo;
import dao.CustomerDAO;
import impl.CustomerDAOimpl;
import pojo.Customer;

public class CustomerServiceImpl implements CustomerService {
	CustomerDAO impl = new CustomerDAOimpl();
	Customer c = new Customer();

	@Override
	public boolean validateUser(UserInfo user, ServletConfig servletConfig) {
		Enumeration<String> initParams = servletConfig.getInitParameterNames();
		boolean validUser = false;
		while (initParams.hasMoreElements()) {
			String initParamName = initParams.nextElement();
			String initParamValue = servletConfig.getInitParameter(initParamName);
			if (user != null && user.getUserId().equals(initParamName) && user.getPassword().equals(initParamValue)) {
				validUser = true;
			}
		}
		return validUser;
	}

	public boolean addCustomer(HttpServletRequest request) throws SQLException {
		String title = request.getParameter("title");
		String fName = request.getParameter("fname");
		String mName = request.getParameter("mname");
		String lName = request.getParameter("lname");
		String suffix = request.getParameter("suffix");
		String email = request.getParameter("email");
		String company = request.getParameter("company");
		String display = request.getParameter("display");
		String check = request.getParameter("check");
		c.setTitle(title);
		c.setFirstname(fName);
		c.setMiddleName(mName);
		c.setLast_name(lName);
		c.setSuffix(suffix);
		c.setEmail(email);
		c.setCompany(company);
		c.setDisplaName(display);
		c.setPrintOnCheckAs(check);
		return impl.addCustomer(c);
	}

	public boolean UpdateCustomer(HttpServletRequest request) throws SQLException {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String fName = request.getParameter("fname");
		String mName = request.getParameter("mname");
		String lName = request.getParameter("lname");
		String suffix = request.getParameter("suffix");
		String email = request.getParameter("email");
		String company = request.getParameter("company");
		String display = request.getParameter("display");
		String check = request.getParameter("check");
		c.setCustID(Integer.parseInt(id));
		c.setTitle(title);
		c.setFirstname(fName);
		c.setMiddleName(mName);
		c.setLast_name(lName);
		c.setSuffix(suffix);
		c.setEmail(email);
		c.setCompany(company);
		c.setDisplaName(display);
		c.setPrintOnCheckAs(check);
		return impl.updateCustomer(c);
	}

	public boolean addAddress(HttpServletRequest request) throws SQLException {
		String id = request.getParameter("id");
		String bstreet = request.getParameter("bstreet");
		String bcity = request.getParameter("bcity");
		String bstate = request.getParameter("bstate");
		String bzip = request.getParameter("bzip");
		String bcountry = request.getParameter("bcountry");
		String street = request.getParameter("sstreet");
		String scity = request.getParameter("scity");
		String sstate = request.getParameter("sstate");
		String szip = request.getParameter("szip");
		String scountry = request.getParameter("scountry");
		String other = request.getParameter("odetails");
		c.setCustID(Integer.parseInt(id));
		c.setBillingStreet(bstreet);
		c.setBillingCity(bcity);
		c.setBillingCountry(bstate);
		c.setBillingZip(bzip);
		c.setBillingState(bcountry);
		c.setShippingCity(street);
		c.setShippingCountry(scity);
		c.setShippingState(sstate);
		c.setShippingStreet(szip);
		c.setShippingZip(scountry);
		c.setOtherDetails(other);
		return impl.addAddress(c);
	}

	public boolean updateAddress(HttpServletRequest request) throws SQLException {
		String id = request.getParameter("id");
		String bstreet = request.getParameter("bstreet");
		String bcity = request.getParameter("bcity");
		String bstate = request.getParameter("bstate");
		String bzip = request.getParameter("bzip");
		String bcountry = request.getParameter("bcountry");
		String street = request.getParameter("sstreet");
		String scity = request.getParameter("scity");
		String sstate = request.getParameter("sstate");
		String szip = request.getParameter("szip");
		String scountry = request.getParameter("scountry");
		String other = request.getParameter("odetails");
		c.setCustID(Integer.parseInt(id));
		c.setBillingStreet(bstreet);
		c.setBillingCity(bcity);
		c.setBillingCountry(bstate);
		c.setBillingZip(bzip);
		c.setBillingState(bcountry);
		c.setShippingCity(street);
		c.setShippingCountry(scity);
		c.setShippingState(sstate);
		c.setShippingStreet(szip);
		c.setShippingZip(scountry);
		c.setOtherDetails(other);
		impl.updateAddress(c);
		return true;
	}
}
