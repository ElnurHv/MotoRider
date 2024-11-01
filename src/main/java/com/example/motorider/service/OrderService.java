package com.example.motorider.service;

import com.example.motorider.dto.request.OrderRequestDto;
import com.example.motorider.dto.response.OrderResponseDto;
import com.example.motorider.entitiy.Customer;
import com.example.motorider.entitiy.Orders;
import com.example.motorider.entitiy.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.motorider.repository.CustomerRepository;
import com.example.motorider.repository.OrderRepository;
import com.example.motorider.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    public String createOrder(OrderRequestDto orderRequestDto) {
        Orders orders = modelMapper.map(orderRequestDto, Orders.class);
        Customer customer = customerRepository.findById(orderRequestDto.getCustomerId()).orElseThrow();

        List<Long> productIds = orderRequestDto.getProductIds();
        List<Product> list = productIds.stream().map(a -> productRepository.findById(a).orElseThrow(() -> new RuntimeException("Order not found" + a))).toList();

        orders.setCustomer(customer);
        orders.setProducts(list);
        orderRepository.save(orders);
        return "Order created";

    }


    public List<OrderResponseDto> getAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        List<OrderResponseDto> orderResponseDtos = orders.stream().map(s -> modelMapper.map(s, OrderResponseDto.class)).toList();
        return orderResponseDtos;
    }


    public String UpdateOrder(OrderRequestDto orderRequestDto, Long orderId) {
        Orders orders = orderRepository.findById(orderId).orElseThrow();
        modelMapper.map(orderRequestDto, orders);
        orderRepository.save(orders);
        return "Order updated";
    }


    public String deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
        return "Order deleted";
    }


}
