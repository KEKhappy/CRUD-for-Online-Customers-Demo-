package team.MediaSoft.CRUDForCustomersDemo.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import team.MediaSoft.CRUDForCustomersDemo.exceptions.GenderNotAcceptableExceptionHandlerAspect;
import team.MediaSoft.CRUDForCustomersDemo.model.Customer;
import team.MediaSoft.CRUDForCustomersDemo.service.CustomerService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ver0/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService service;
    //todo

    @GetMapping
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }

    @PostMapping("/save")
    public Customer saveCustomer(@Valid @RequestBody Customer customer){
        if(customer.getGender().equalsIgnoreCase("male")
                || customer.getGender().equalsIgnoreCase("female")){
            return service.saveCustomer(customer);
        }
        else throw new GenderNotAcceptableExceptionHandlerAspect();
    }

    @PutMapping("/update")
    public Customer updateCustomer(@Valid @RequestBody Customer customer){
        if(customer.getGender().equalsIgnoreCase("male")
                || customer.getGender().equalsIgnoreCase("female")){
            return service.updateCustomer(customer);
        }
        else throw new GenderNotAcceptableExceptionHandlerAspect();
    }

    @PatchMapping("/{id}")
    public Customer getCustomerById(@Valid @PathVariable UUID id){
        return service.getCustomerById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomerById(@Valid @PathVariable UUID id){
        service.deleteCustomerById(id);
    }











}
