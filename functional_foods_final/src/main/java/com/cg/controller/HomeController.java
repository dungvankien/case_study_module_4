package com.cg.controller;


import com.cg.model.Product;
import com.cg.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ModelAndView showHomePage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//
//        return modelAndView;

        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }
}
