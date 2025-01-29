package com.example.motorider.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrderResponseDto {
    private Long id;

    private LocalDate orderDate;
    private double totalPrice;

    private CustomerResponseDto customer;
    private List<ProductResponseDto> products;


}
