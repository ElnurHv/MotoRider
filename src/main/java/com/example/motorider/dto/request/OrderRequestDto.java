package com.example.motorider.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrderRequestDto {
    private LocalDate orderDate;
    private double totalPrice;

    private Long customerId;
    private List<Long> productIds;
}
