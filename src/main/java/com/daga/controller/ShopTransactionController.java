package com.daga.controller;

import com.daga.model.Customer;
import com.daga.model.Product;
import com.daga.model.ShopTransaction;
import com.daga.repository.CustomerRepository;
import com.daga.repository.ProductRepository;
import com.daga.repository.ShopTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Controller
public class ShopTransactionController {
    @Autowired
    ShopTransactionRepository shopTransactionRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public String transaction(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "transaction";
    }

    @RequestMapping(value = "/buyproducts", method = RequestMethod.POST)
    public ModelAndView saveCustomer(
            @RequestParam("first") String first,
            @RequestParam("last") String last,
            @RequestParam("street") String street,
            @RequestParam("zipcode") String zipcode,
            @RequestParam("city") String city,
            @RequestParam("ids") String ids) {
        Customer customer = customerRepository.findCustomerByFirstNameAndLastNameAndCity(first, last, city);

        if (customer == null) {
            customer = new Customer();
            customer.setFirstName(first);
            customer.setLastName(last);
            customer.setCity(city);
            customer.setStreet(street);
            customer.setZipCode(zipcode);
        }


        System.out.println(customer);
        System.out.println(ids);
        List<Integer> ids1 = Arrays.stream(ids.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        List<Product> products = new LinkedList<>();
        ShopTransaction shopTransaction = new ShopTransaction();
        shopTransaction.setQuantity(0);
        for (Integer i : ids1) {
            products.add(productRepository.findProductByProductID(i));
        }
        for (Product p : products)
            if (p.getUnitsOnStock() != 0) {
                p.setUnitsOnStock(p.getUnitsOnStock() - 1);
                p.addTransaction(shopTransaction);
                shopTransaction.addProduct(p);
                shopTransaction.setQuantity(shopTransaction.getQuantity() + 1);
            }


        shopTransaction.addCustomer(customer);
        customer.addTransaction(shopTransaction);

        ModelAndView model = new ModelAndView("finaltransaction");
        List<Customer> c = new LinkedList<>();
        c.add(customer);
        List<ShopTransaction> t = new LinkedList<>();
        t.add(shopTransaction);
        model.addObject("products", products);
        model.addObject("c", c);
        model.addObject("t", t);
        customerRepository.save(customer);
        productRepository.save(products);
        shopTransactionRepository.save(shopTransaction);
        return model;

    }
}
