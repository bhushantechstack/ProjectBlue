package com.testing.projectblue.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.testing.projectblue.pojo.ProjectBlue;
import com.testing.projectblue.repositories.HomeRepo;

@RestController
@CrossOrigin(origins = "*")
public class HomeController {
    @Autowired
    private HomeRepo homeRepo;
    @GetMapping("/")
    public String home() {
        return "Welcome to Project Blue!";
    }
    @Value("${ADMIN.USERNAME}")
    private String adminUsername;
    @Value("${ADMIN.PASSWORD}")
    private String adminPassword;
    
    private void verifyAdmin(String username, String password) {
        if (!adminUsername.equals(username) || !adminPassword.equals(password)) {
            throw new RuntimeException("Unauthorized access: Invalid username or password");
        }
        System.out.println("Admin access granted for user: " + username);
    }
    
    @PostMapping("/customer")
    public ProjectBlue customer(@RequestHeader("username") String username, @Deprecated @RequestHeader("password") String password, @RequestBody ProjectBlue customerData) {
        verifyAdmin(username, password);
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
    public String updateCustomer(@PathVariable Long id, @RequestHeader("username") String username, @Deprecated @RequestHeader("password") String password, @RequestBody ProjectBlue customerData) {
        verifyAdmin(username, password);
        homeRepo.findById(id).ifPresent(existingCustomer -> {
            existingCustomer.setName(customerData.getName());
            existingCustomer.setDescription(customerData.getDescription());
            homeRepo.save(existingCustomer);
        });
        System.out.println("Customer with ID " + id + " updated successfully");
        return "Customer updated successfully!";
    }

    @CacheEvict(value = "customerCache", key = "#id")
    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable Long id, @RequestHeader("username") String username, @Deprecated @RequestHeader("password") String password) {
        verifyAdmin(username, password);
        homeRepo.deleteById(id);
        return "Customer deleted successfully!";
    }
}
