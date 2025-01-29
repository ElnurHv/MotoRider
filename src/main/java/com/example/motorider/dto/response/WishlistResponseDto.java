package com.example.motorider.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishlistResponseDto {
    private  Long id;

    private OrderResponseDto order;
    private CustomerResponseDto customer;

}
