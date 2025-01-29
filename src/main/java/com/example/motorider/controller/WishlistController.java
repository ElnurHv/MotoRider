package com.example.motorider.controller;

import com.example.motorider.dto.request.WishlistRequestDto;
import com.example.motorider.dto.response.WishlistResponseDto;
import com.example.motorider.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;


    @PostMapping("/create")
    public String createWishlist(@RequestBody WishlistRequestDto wishlistRequestDto) {
        return wishlistService.createWishlist(wishlistRequestDto);
    }

    @GetMapping("/get-all")
    public List<WishlistResponseDto> getAllWishlists() {
        return wishlistService.getAllWishlists();
    }

    @PutMapping("/update/{id}")
    public String updateWishlist(@RequestBody WishlistRequestDto wishlistRequestDto, @PathVariable Long id) {
        return wishlistService.updateWishlist(wishlistRequestDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteWishlist(@PathVariable Long id) {
        return wishlistService.deleteWishlist(id);
    }
}
