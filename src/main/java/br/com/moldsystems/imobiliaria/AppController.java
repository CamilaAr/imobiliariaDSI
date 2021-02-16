package br.com.moldsystems.imobiliaria;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.moldsystems.models.House;
import br.com.moldsystems.service.Service;

@Controller
public class AppController {
	
	private Service service;
	public AppController() {
		service = new Service();
	}
	
	@RequestMapping("/")
	public ModelAndView indexPage() {
		return service.index();
	}
	
	@RequestMapping("/add")
	public ModelAndView addPage() {
		return service.addPage();
	}
	
	@RequestMapping(value="add-house", method = RequestMethod.GET)
	public ModelAndView add(House house) {
		return service.add(house);
	}
	
	public ModelAndView listOwner() {

		return new ModelAndView();
	}

	public ModelAndView listHouse() {

		return new ModelAndView();
	}
	@RequestMapping("/remove-house/")
	public ModelAndView removeHouse(@RequestParam("id") String id) {

		return new ModelAndView();
	}
	
	@RequestMapping("/remove-owner/")
	public ModelAndView removeOwner(@RequestParam("id") String id) {

		return new ModelAndView();
	}

}
