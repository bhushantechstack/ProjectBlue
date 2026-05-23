package com.testing.projectblue.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testing.projectblue.pojo.ProjectBlue;
import com.testing.projectblue.repositories.HomeRepo;

@RestController
public class HomeController {
    @Autowired
    private HomeRepo homeRepo;
    @GetMapping("/")
    public String home() {
        return "Welcome to Project Blue!";
    }
    
    @PostMapping("/customer")
    public ProjectBlue customer(@RequestBody ProjectBlue customerData) {
        homeRepo.save(customerData);
        System.out.println("Customer data saved: " + customerData);
        return customerData;
    }
    @Cacheable("customerCache")
    @GetMapping("/customers")
    public List<ProjectBlue> getCustomers() {
        return homeRepo.findAll().stream().toList();
    }
    @GetMapping("/test-exception")
    public String testGlobalException() {
        throw new RuntimeException("This is a test exception");
    }
    @CachePut(value = "customerCache", key = "#id")
    @PutMapping("/customer/{id}")
    public String updateCustomer(@PathVariable Long id, @RequestBody ProjectBlue customerData) {
        homeRepo.findById(id).ifPresent(existingCustomer -> {
            existingCustomer.setName(customerData.getName());
            existingCustomer.setDescription(customerData.getDescription());
            homeRepo.save(existingCustomer);
        });
        return "Customer updated successfully!";
    }

    @CacheEvict(value = "customerCache", key = "#id")
    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        homeRepo.deleteById(id);
        return "Customer deleted successfully!";
    }
}
