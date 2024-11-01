package com.example.motorider.controller;


import com.example.motorider.dto.request.CategoryRequestDto;
import com.example.motorider.dto.response.CategoryResponseDto;
import com.example.motorider.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/create")
    public String createOrder(@RequestBody CategoryRequestDto categoryRequestDto) {

        return categoryService.createCategory(categoryRequestDto);
    }

    @GetMapping("get-all")
    public List<CategoryResponseDto> getAllOrders() {

        return categoryService.getAllCategory();

    }

    @PutMapping("/update/{id}")
    public String updateOrder(@RequestBody CategoryRequestDto categoryRequestDto, @PathVariable Long id) {

        return categoryService.updateCategory(categoryRequestDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return categoryService.deleteCategory(id);
    }

}
