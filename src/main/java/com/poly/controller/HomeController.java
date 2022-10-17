package com.poly.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Products;
import com.poly.service.ProductService;


@Controller
public class HomeController {
	
	@Autowired
	private ProductService productsService;
	private static final int MAX_PAGESIZE = 4;

//	@Autowired
//	private UserService usersService;
	
	@GetMapping(value = {"/",""})
	public String doGetRedirectIndex() {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String doGetIndex(Model model, @RequestParam("typeId") Optional<Long> typeId) {
		if(typeId.isPresent()) {
			List<Products> list = productsService.findByProductTypes_Id(typeId.get());
			model.addAttribute("items", list);
		}
		else {
			List<Products> list = productsService.findAll();
			model.addAttribute("items", list);
		}
		return "user/index";
	}
	
	
	@RequestMapping("/index")
	public String index() {
		return "user/index";
	}
	
	@RequestMapping("/cart")
	public String shoppingCart() {
		return "user/shoppingCart";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "user/register";
	}
	
	@RequestMapping("/checkout")
	public String checkout() {
		return "user/checkout";
	}
	
	@RequestMapping("/forgotPassword")
	public String forgotpassword() {
		return "user/forgotPassword";
	}
	
	@RequestMapping("/detail")
	public String detail() {
		return "user/detail";
	}
	
	@RequestMapping("/detail/{id}")
	public String detailId(Model model, @PathVariable("id") Long id) {
		Products item = productsService.findById(id);
		model.addAttribute("item", item);
		return "user/detail";
	}
}
