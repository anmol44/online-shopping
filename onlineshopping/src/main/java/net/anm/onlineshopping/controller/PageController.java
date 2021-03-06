package net.anm.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.anm.shoppingbackend.dao.CategoryDAO;
import net.anm.shoppingbackend.dao.ProductDAO;
import net.anm.shoppingbackend.dto.Category;
import net.anm.shoppingbackend.dto.Product;

@Controller
public class PageController {
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "home");
		logger.info("inside PageController index method- INFO");
		logger.debug("inside PageController index method - DEBUG");
		// passing the list of categories

		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "about us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "contact us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	/**
	 * methods to load all the products and based on the category
	 */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");

		// passing the list of categories

		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch a single category
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());

		// passing the list of categories

		mv.addObject("categories", categoryDAO.list());

		// passing the single category object

		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		// update the count view
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		return mv;
	}

	// @RequestMapping(value="/test")
	// public ModelAndView test(@RequestParam(value="greeting",required=false)String
	// greeting) {
	// if(greeting==null) {
	// greeting= "hello greeting is null";
	// }
	// ModelAndView mv = new ModelAndView("page");
	// mv.addObject("greeting",greeting);
	// return mv;
	// }
	// @RequestMapping(value="/test/{greeting}")
	// public ModelAndView test(@PathVariable(value="greeting",required=false)String
	// greeting) {
	// if(greeting==null) {
	// greeting= "hello greeting is null";
	// }
	// ModelAndView mv = new ModelAndView("page");
	// mv.addObject("greeting",greeting);
	// return mv;
	// }
}
