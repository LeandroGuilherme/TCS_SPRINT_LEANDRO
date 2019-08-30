package com.lojal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lojal.Service.ProductsService;
import com.lojal.dao.ProductsDao;
import com.lojal.model.ProductsModel;


@Controller
public class ProductsController {
	
	@Autowired
	private ProductsDao service;
	@Autowired
	private ProductsService servi;

   /* @GetMapping("/#paratabela")
    public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("product");
		mv.addObject("product", servi.findAll());
		
		return mv;
	}*/
	
	@RequestMapping("/new")
	public String viewHomePage(Model model) {
		
		List<ProductsModel> listProducts = service.listAll();
		
		model.addAttribute("listProducts", listProducts);
		
		return "new";
	}
	
	@RequestMapping("/#paracadastro")
	public String showNewProductPage(Model model) {
		
		ProductsModel product = new ProductsModel();
		model.addAttribute("product", product);
		
		return "#paracadastro";
	}


	@RequestMapping("/edit/{id_product}")
	public ModelAndView showEditProductPage(@PathVariable(name="id_product")long id_product) {
		ModelAndView mav = new ModelAndView("edit");
		ProductsModel product = service.get(id_product);
		mav.addObject("product", product);
		return mav; 
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(ProductsModel product) {
		
		service.save(product);
		return "redirect:/new";
	}
	
	@RequestMapping("/delete/{id_product}")
	public String deleteProduct(@PathVariable(name="id_product")long id_product) {
		service.delete(id_product);
		return "redirect:/new";
	}
	
	
	
	
	/*
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		
		List<ProductsModel> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		ProductsModel product = new ProductsModel();
		model.addAttribute("product", product);
		return "new";
		
	}
	@RequestMapping("/")
	public ModelAndView showEditProductPage(@PathVariable(name="id_product")long id_product) {
		ModelAndView mav = new ModelAndView("edit");
		ProductsModel product = service.get(id_product);
		mav.addObject("product", product);
		return mav;
		
	}
	
	@PostMapping(value = "/save")
	public String save(ProductsModel product){
	   service.save(product);
	   return "redirect:/";
	}
	
	@GetMapping("/delete/{id_product}")
	public String deleteProduct(@PathVariable(name="id_product")long id_product) {
		service.delete(id_product);
		return "redirect:/";
	}
	*/
}
