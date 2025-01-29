package com.example.motorider.service;

import com.example.motorider.dto.request.WishlistRequestDto;
import com.example.motorider.dto.response.WishlistResponseDto;
import com.example.motorider.entity.Customer;
import com.example.motorider.entity.Orders;
import com.example.motorider.entity.WishList;
import com.example.motorider.repository.CustomerRepository;
import com.example.motorider.repository.OrderRepository;
import com.example.motorider.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;



    public String createWishlist(WishlistRequestDto wishlistRequestDto) {
     WishList wishList = modelMapper.map(wishlistRequestDto, WishList.class);
        Orders orders = orderRepository.findById(wishlistRequestDto.getOrderId()).orElse(null);
        Customer customer = customerRepository.findById(wishlistRequestDto.getCustomerId()).orElse(null);

        wishList.setCustomer(customer);
        wishList.setOrder(orders);
        wishlistRepository.save(wishList);
        return "Wishlist created";

    }

    public List<WishlistResponseDto> getAllWishlists() {
        List<WishList> all = wishlistRepository.findAll();
        List<WishlistResponseDto> wishlistResponseDtos = all.stream().map(l->modelMapper.map(l,WishlistResponseDto.class)).toList();
        return wishlistResponseDtos;
    }

    public String updateWishlist(WishlistRequestDto wishlistRequestDto,Long id) {
        WishList wishList = wishlistRepository.findById(id).orElseThrow(()->new RuntimeException("Wishlist not found"));
        modelMapper.map(wishlistRequestDto, wishList);
        wishlistRepository.save(wishList);
        return "Wishlist updated";
    }

    public String deleteWishlist(Long id) {
        wishlistRepository.deleteById(id);
        return "Wishlist deleted";
    }
}
