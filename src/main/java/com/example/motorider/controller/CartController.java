package com.example.motorider.controller;

import com.example.motorider.dto.request.CartRequestDto;
import com.example.motorider.dto.response.CartResponseDto;
import com.example.motorider.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;


    @PostMapping("/create")
    public String createCart(@RequestBody CartRequestDto cartRequestDto) {
        return cartService.createCart(cartRequestDto);
    }


    @GetMapping("/get-all")
    public List<CartResponseDto> getAllCarts() {
        return cartService.getCarts();
    }

    @PutMapping("/update/{id}")
    public String updateCart( @RequestBody CartRequestDto cartRequestDto,@PathVariable Long id) {
        return cartService.updateCart(cartRequestDto, id);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteCart(@PathVariable Long id) {
        return cartService.deleteCart(id);
    }

}
