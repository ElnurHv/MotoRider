package com.example.motorider.service;

import com.example.motorider.dto.request.CartRequestDto;
import com.example.motorider.dto.response.CartResponseDto;
import com.example.motorider.entity.Cart;
import com.example.motorider.entity.Customer;
import com.example.motorider.entity.Orders;
import com.example.motorider.repository.CartRepository;
import com.example.motorider.repository.CustomerRepository;
import com.example.motorider.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;


    public String createCart(CartRequestDto requestDto) {
        Cart cart = modelMapper.map(requestDto, Cart.class);
        Orders orders = orderRepository.findById(requestDto.getOrderId()).orElse(null);
        Customer customer = customerRepository.findById(requestDto.getOrderId()).orElse(null);

        cart.setCustomer(customer);
        cart.setOrder(orders);
        cartRepository.save(cart);
        return "Cart created";
    }


    public String updateCart(CartRequestDto requestDto,Long id) {
        Cart cartFound = cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart not found"));
        modelMapper.map(requestDto, cartFound);
        cartRepository.save(cartFound);
        return "Cart updated";

    }


    public List<CartResponseDto> getCarts() {
        List<Cart> all = cartRepository.findAll();
        List<CartResponseDto> list = all.stream().map(m -> modelMapper.map(m, CartResponseDto.class)).toList();
        return list;
    }

    public String deleteCart(Long id) {
        cartRepository.deleteById(id);
        return "Cart deleted";
    }





}
