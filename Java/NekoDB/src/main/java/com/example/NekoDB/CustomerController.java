package com.example.NekoDB;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository repo;
// see next slide
    @GetMapping("/")
    public String listCustomers(Model model) {
        model.addAttribute("customers", repo.findAll());
        model.addAttribute("customer", new Customer());
        return "index";
    }
    @PostMapping("/create")
    public String addCustomer(@ModelAttribute Customer customer) {
        System.out.println("Saving customer: " + customer);
        repo.save(customer);
        return "redirect:/";
    }
    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model){
        List<Customer> customers = repo.findByName(query);
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer());
        return "index"; // Return to the same page with search results
    }
}