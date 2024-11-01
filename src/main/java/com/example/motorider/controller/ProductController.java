package com.example.motorider.controller;

import com.example.motorider.dto.request.ProductRequestDto;
import com.example.motorider.dto.response.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.motorider.service.ProductService;

import java.util.List;

@RestController


@RequestMapping("/api/v1/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public String createProduct(@RequestBody ProductRequestDto productRequestDto) {

        return productService.createProduct(productRequestDto);
    }

    @GetMapping("/get-all")
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();

    }

    @PutMapping("/update/{id}")
    public String updateProduct(@RequestBody ProductRequestDto productRequestDto, @PathVariable Long id) {
        return productService.updateProduct(productRequestDto, id);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);

    }

    @GetMapping("/price-greater-than")
    public List<ProductRequestDto> getProductsByPriceGreaterThan(@RequestParam double price) {
        return productService.getByPriceGreather(price);

    }

    @GetMapping("/price-less-than")
    public List<ProductRequestDto> getProductsByPriceLessThan(@RequestParam double price) {
        return productService.getByPriceless(price);
    }

    @GetMapping("/by-name")
    public List<ProductRequestDto> getProductsByName(@RequestParam String name) {
    return productService.getProductByName(name);
    }

    @GetMapping("/last-added")
    public List<ProductRequestDto> getLastAddedProducts() {
        return productService.getLastAdded();
    }


}
