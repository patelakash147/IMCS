package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.model.Customer;
import com.model.Order;
import com.model.Product;
import com.service.ICutomerService;

@Controller
@RequestMapping("/home")
public class CustomerController {

	@Autowired
	ICutomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public String greeting(Model model) {
		model.addAttribute("page", "body.jsp");
		return "home";
	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String displayCustomer(Model model) {
		model.addAttribute("page", "pages/csdisplay.jsp");
		return "home4";
	}

	@RequestMapping(value = "/display", method = RequestMethod.POST)
	public ModelAndView loadUser(@RequestParam int id, HttpSession session) {
		session.setAttribute("sid", id);
		ModelAndView modelandView = new ModelAndView("home2");
		Customer user = customerService.findCustomerById(id);
		modelandView.addObject("user", user);
		modelandView.addObject("page", "pages/csdisplay.jsp");
		return modelandView;
	}

	@RequestMapping(value = "/customer/update", method = RequestMethod.GET)
	public ModelAndView updateCustomer(HttpSession session) {
		int id = (int) session.getAttribute("sid");
		ModelAndView modelandView = new ModelAndView("home2");
		modelandView.addObject("page", "pages/updatecustomer.jsp");
		Customer user = customerService.findCustomerById(id);
		modelandView.addObject("user", user);
		return modelandView;
	}

	@RequestMapping(value = "/customer/update", method = RequestMethod.POST)
	public ModelAndView updateCustomer(HttpSession session, @RequestParam String title, @RequestParam String fname,
			@RequestParam String mname, @RequestParam String lname, @RequestParam String suffix,
			@RequestParam String email, @RequestParam String company, @RequestParam String display,
			@RequestParam String check) {
		int id = (int) session.getAttribute("sid");
		ModelAndView modelandView = new ModelAndView("home2");
		Customer c = new Customer();
		c.setCustIDPK(id);
		c.setTitle(title);
		c.setFirstName(fname);
		c.setMiddleName(mname);
		c.setLastName(lname);
		c.setSuffix(suffix);
		c.setEmail(email);
		c.setCompany(company);
		c.setDisplayName(display);
		c.setPrintOnCheckAs(check);
		customerService.createCustomer(c);
		modelandView.addObject("page", "pages/cusupdated.jsp");
		return modelandView;
	}

	@RequestMapping(value = "/address/display", method = RequestMethod.GET)
	public ModelAndView displayAddress(HttpSession session) {
		int id = (int) session.getAttribute("sid");
		ModelAndView modelandView = new ModelAndView("home2");
		Customer user = customerService.findCustomerById(id);
		modelandView.addObject("user", user);
		modelandView.addObject("page", "pages/displayaddress.jsp");
		return modelandView;
	}

	@RequestMapping(value = "/address/update", method = RequestMethod.GET)
	public ModelAndView updateAddress(HttpSession session) {
		int id = (int) session.getAttribute("sid");
		ModelAndView modelandView = new ModelAndView("home2");
		modelandView.addObject("page", "pages/updateaddress.jsp");
		Customer user = customerService.findCustomerById(id);
		modelandView.addObject("user", user);
		return modelandView;
	}

	@RequestMapping(value = "/address/update", method = RequestMethod.POST)
	public ModelAndView updateAddress(HttpSession session, @RequestParam String bstreet, @RequestParam String bcity,
			@RequestParam String bstate, @RequestParam String bzip, @RequestParam String bcountry,
			@RequestParam String sstreet, @RequestParam String scity, @RequestParam String sstate,
			@RequestParam String szip, @RequestParam String scountry, @RequestParam String odetails) {
		int id = (int) session.getAttribute("sid");
		ModelAndView modelandView = new ModelAndView("home2");
		modelandView.addObject("page", "pages/addupdated.jsp");
		Customer c = new Customer();
		c.setCustIDPK(id);
		c.setBillingStreet(bstreet);
		c.setBillingCity(bcity);
		c.setBillingState(bstate);
		c.setBillingZip(bzip);
		c.setBillingCountry(bcountry);
		c.setShippingStreet(sstreet);
		c.setShippingCity(scity);
		c.setShippingState(sstate);
		c.setShippingZip(szip);
		c.setShippingCountry(scountry);
		c.setOtherDetails(odetails);
		customerService.createCustomer(c);
		return modelandView;
	}

	@RequestMapping(value = "/order/display", method = RequestMethod.GET)
	public ModelAndView displayOrder(HttpSession session) {
		int id = (int) session.getAttribute("sid");
		ModelAndView modelandView = new ModelAndView("home2");
		List<Order> o = customerService.getOrderbyID(id);
		Product p = customerService.getProductbyID(11);
		System.out.println(p.getName());
		modelandView.addObject("user", o);
		modelandView.addObject("page", "pages/displayorder.jsp");
		return modelandView;
	}

	@RequestMapping(value = "/order/product/{id}", method = RequestMethod.GET)
	public ModelAndView displayProduct(@PathVariable int id, HttpSession session) {
		ModelAndView modelandView = new ModelAndView("home2");
		Product user = customerService.getProductbyID(id);
		modelandView.addObject("user", user);
		modelandView.addObject("page", "pages/displayproduct.jsp");
		return modelandView;
	}

	@RequestMapping(value = "/order/update", method = RequestMethod.GET)
	public String updateOrder(Model model) {
		model.addAttribute("page", "pages/updateorder.jsp");
		return "home2";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String addCustomer(Model model) {
		model.addAttribute("page", "pages/addcustomer.jsp");
		return "home3";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public ModelAndView addCustomerPost(HttpSession session, @RequestParam String title, @RequestParam String fname,
			@RequestParam String mname, @RequestParam String lname, @RequestParam String suffix,
			@RequestParam String email, @RequestParam String company, @RequestParam String display,
			@RequestParam String check) {
		ModelAndView modelandView = new ModelAndView("home3");
		Customer c = new Customer();
		c.setTitle(title);
		c.setFirstName(fname);
		c.setMiddleName(mname);
		c.setLastName(lname);
		c.setSuffix(suffix);
		c.setEmail(email);
		c.setCompany(company);
		c.setDisplayName(display);
		c.setPrintOnCheckAs(check);
		customerService.createCustomer(c);
		int id = customerService.custIDreturn();
		session.setAttribute("createID", id);
		modelandView.addObject("id", id);
		modelandView.addObject("page", "pages/cusadded.jsp");
		return modelandView;
	}

	@RequestMapping(value = "/address/add", method = RequestMethod.GET)
	public String addAddress(Model model) {
		model.addAttribute("page", "pages/addaddress.jsp");
		return "home3";
	}

	@RequestMapping(value = "/address/add", method = RequestMethod.POST)
	public ModelAndView addAddress(HttpSession session, @RequestParam String bstreet, @RequestParam String bcity,
			@RequestParam String bstate, @RequestParam String bzip, @RequestParam String bcountry,
			@RequestParam String sstreet, @RequestParam String scity, @RequestParam String sstate,
			@RequestParam String szip, @RequestParam String scountry, @RequestParam String odetails) {
		int id = (int) session.getAttribute("createID");
		ModelAndView modelandView = new ModelAndView("home3");
		modelandView.addObject("page", "pages/addadded.jsp");
		Customer c = new Customer();
		c.setCustIDPK(id);
		c.setBillingStreet(bstreet);
		c.setBillingCity(bcity);
		c.setBillingState(bstate);
		c.setBillingZip(bzip);
		c.setBillingCountry(bcountry);
		c.setShippingStreet(sstreet);
		c.setShippingCity(scity);
		c.setShippingState(sstate);
		c.setShippingZip(szip);
		c.setShippingCountry(scountry);
		c.setOtherDetails(odetails);
		customerService.createCustomer(c);
		return modelandView;
	}
}