package com.MVC.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Flight;
import com.service.IAirlineOperation;

@Controller
public class FlightMVCcontroller {
	
	@Autowired
	IAirlineOperation arilineDAO;
	
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String greeting(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/display", method = RequestMethod.POST)
	public ModelAndView searchFlight(@RequestParam int id) {
		ModelAndView modelandView = new ModelAndView("home");
		Flight user = arilineDAO.findFlightbyID(id);
		System.out.println("jvab"+user.getAirlineName());
		modelandView.addObject("user", user);
		return modelandView;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateCustomer(Model model) {
		ModelAndView modelandView = new ModelAndView("update");
		return modelandView;
	}
 
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateCustomer(@ModelAttribute("f") Flight f ) {
		ModelAndView modelandView = new ModelAndView("update");
		arilineDAO.updateFlightDetails(f);
		modelandView.addObject("message", "Flight details updated");
		return modelandView;
	}
}
