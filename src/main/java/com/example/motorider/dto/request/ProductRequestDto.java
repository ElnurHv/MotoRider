package com.example.motorider.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

public class ProductRequestDto {
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private LocalDateTime createdDateTime;

    private Long motorcycleTypeId;
    private List<Long> categoryIds;
}
