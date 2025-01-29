package com.example.motorider.service;

import com.example.motorider.dto.request.CategoryRequestDto;
import com.example.motorider.dto.response.CategoryResponseDto;
import com.example.motorider.entity.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.motorider.repository.CategoryRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    public String createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = modelMapper.map(categoryRequestDto, Category.class);
        categoryRepository.save(category);
        return "Successfully created category";
    }


    public List<CategoryResponseDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDto> list = categories.stream().map(a -> modelMapper.map(a, CategoryResponseDto.class)).toList();
        return list;

    }

    public String updateCategory(CategoryRequestDto categoryRequestDto, Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        modelMapper.map(categoryRequestDto, category);
        categoryRepository.save(category);
        return "Succesfully updated category";


    }

    public String deleteCategory (Long id) {
        categoryRepository.deleteById(id);
        return "Deleted Category ";
    }


}
