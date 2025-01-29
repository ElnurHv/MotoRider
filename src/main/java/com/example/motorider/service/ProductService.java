package com.example.motorider.service;

import com.example.motorider.dto.request.ProductRequestDto;
import com.example.motorider.dto.response.ProductResponseDto;
import com.example.motorider.entity.Category;
import com.example.motorider.entity.MotorcycleType;
import com.example.motorider.entity.Product;
import com.example.motorider.repository.CategoryRepository;
import com.example.motorider.repository.MotorcycleTypeRepository;
import com.example.motorider.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final MotorcycleTypeRepository motorcycleTypeRepository;
    private final CategoryRepository categoryRepository;



    public String createProduct(ProductRequestDto productRequestDto) {
        Product product = modelMapper.map(productRequestDto, Product.class);
        MotorcycleType motorcycleType = motorcycleTypeRepository.findById(productRequestDto.getMotorcycleTypeId()).orElseThrow();

        List<Long> categoryIds = productRequestDto.getCategoryIds();
        List<Category> categoryList = categoryIds.stream().map(c -> categoryRepository.findById(c).orElseThrow(() -> new RuntimeException("Category not found" + c))).toList();

        product.setMotorcycleType(motorcycleType);
        product.setCategories(categoryList);
        productRepository.save(product);
        return "Product created";
    }


    public String updateProduct(ProductRequestDto productRequestDto, Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        modelMapper.map(productRequestDto, product);
        productRepository.save(product);
        return "Product updated";
    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAllByQuantityGreaterThan(0);
        return products.stream().map(p -> modelMapper.map(p, ProductResponseDto.class)).toList();
    }


    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Product deleted";
    }

    public List<ProductRequestDto> getProductByName(String name) {
        return productRepository.findByName(name).stream().map(a -> modelMapper.map(a, ProductRequestDto.class)).toList();
    }

    public List<ProductRequestDto> getByPriceless(double price) {
        return productRepository.findByPriceLessThan(price).stream().map(a -> modelMapper.map(a, ProductRequestDto.class)).toList();
    }

    public List<ProductRequestDto> getByPriceGreather(double price) {
        return productRepository.findByPriceGreaterThan(price).stream().map(g -> modelMapper.map(g, ProductRequestDto.class)).toList();
    }

    public List<ProductResponseDto> getLastAdded(){
        return productRepository.findByOrderByCreatedDateTime().stream().map(p -> modelMapper.map(p, ProductResponseDto.class)).toList();
    }



}
