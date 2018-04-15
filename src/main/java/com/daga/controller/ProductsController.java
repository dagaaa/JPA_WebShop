package com.daga.controller;

import com.daga.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductsController {

    @Autowired
    ProductRepository productRepository;


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String productsList(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @RequestMapping(value = "/choosecategory", method = RequestMethod.POST)
    public ModelAndView productCategory(@RequestParam("category") String category) {
        ModelAndView modelandview = new ModelAndView("products");
        modelandview.addObject("products", productRepository.findProductsByCategoryName(category));
        return modelandview;
    }


}
