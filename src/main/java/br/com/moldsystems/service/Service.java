package br.com.moldsystems.service;

import org.springframework.web.servlet.ModelAndView;

import br.com.moldsystems.dao.HouseDao;
import br.com.moldsystems.dao.PersonDao;
import br.com.moldsystems.models.House;



public class Service {
	
	private HouseDao daoHouse;
	private PersonDao daoPerson;
	public Service() {
		daoHouse = new HouseDao();
		daoPerson = new PersonDao();
	}
	
	
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	public ModelAndView addPage() {
		ModelAndView model = new ModelAndView("add");
		model.addObject("owners", daoPerson.list());
		return model;
	}
	
	public ModelAndView add(House house) {
		daoHouse.insert(house);
		return new ModelAndView("index");
	}
}
