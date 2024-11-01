package com.example.motorider.service;

import com.example.motorider.dto.request.CustomerRequestDto;
import com.example.motorider.dto.response.CustomerResponseDto;
import com.example.motorider.entitiy.Customer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.motorider.repository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;


    public String createCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = modelMapper.map(customerRequestDto, Customer.class);
        customerRepository.save(customer);
        return "Customer created";
    }


    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDto> customerList = customers.stream().map(c -> modelMapper.map(c, CustomerResponseDto.class)).toList();
        return customerList;
    }

    public String updateCustomer(CustomerRequestDto customerRequestDto, Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        modelMapper.map(customerRequestDto, customer);
        customerRepository.save(customer);
        return "Customer updated";
    }

    public String deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return "Customer deleted";
    }
}
