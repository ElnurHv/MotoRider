package com.example.motorider.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private LocalDateTime createdDateTime;

    private MotorcycleTypeResponseDto motorcycleType;
    private List<CategoryResponseDto> categories;
}
