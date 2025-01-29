package com.example.motorider.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderRequestDto {
    private LocalDateTime orderDate;
    private BigDecimal totalPrice;

    private Long customerId;
    private List<Long> productIds;


}
