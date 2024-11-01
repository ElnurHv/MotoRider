package com.example.motorider.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
