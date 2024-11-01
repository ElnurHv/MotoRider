package com.example.motorider.controller;

import com.example.motorider.dto.request.CustomerRequestDto;
import com.example.motorider.dto.response.CustomerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.motorider.service.CustomerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping("/create")
    public String createOrder(@RequestBody CustomerRequestDto customerRequestDto) {

        return customerService.createCustomer(customerRequestDto);
    }

    @GetMapping("get-all")
    public List<CustomerResponseDto> getAllOrders() {

        return customerService.getAllCustomers();

    }

    @PutMapping("/update/{id}")
    public String updateOrder(@RequestBody CustomerRequestDto customerRequestDto, @PathVariable Long id) {

        return customerService.updateCustomer(customerRequestDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return customerService.deleteCustomer(id);

    }
}
