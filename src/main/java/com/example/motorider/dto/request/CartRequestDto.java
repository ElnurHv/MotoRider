package com.example.motorider.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequestDto {
    private Long productId;
    private Long orderId;
}
