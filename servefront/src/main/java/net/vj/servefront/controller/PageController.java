package net.vj.servefront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.vj.servebackend.dao.CategoryDAO;
import net.vj.servebackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting", "Welcome to spring web MVC");
		mv.addObject("title", "Home");
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting", "Welcome to spring web MVC");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "contact")
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting", "Welcome to spring web MVC");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	/*
	 * 
	 * Methods to load all Products and based on category
	 * 
	 * */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting", "Welcome to spring web MVC");
		mv.addObject("title", "All Products");
		
		//passing The list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting", "Welcome to spring web MVC");
		
		/*
		 * categoryDAO to fetch a single category
		 * */
		Category category = null;
		
		category = categoryDAO.get(id);
				
		
		mv.addObject("title", category.getName());
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		// Passing the single category object
		mv.addObject("category", category);
		
		
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	// @RequestMapping(value="/test")
	// public ModelAndView test(@RequestParam(value="greeting",
	// required=false)String greeting) {
	// if (greeting == null) {
	// greeting = "Hello World !";
	// }
	// ModelAndView mv = new ModelAndView("page");
	// mv.addObject("greeting",greeting);
	// return mv;
	// }
	// @RequestMapping(value="/test/{greeting}")
	// public ModelAndView test(@PathVariable("greeting")String greeting) {
	// if (greeting == null) {
	// greeting = "Hello World !";
	// }
	// ModelAndView mv = new ModelAndView("page");
	// mv.addObject("greeting",greeting);
	// return mv;
	// }
}
