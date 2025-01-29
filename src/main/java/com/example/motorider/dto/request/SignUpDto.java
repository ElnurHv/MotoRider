package com.example.motorider.dto.request;


import com.example.motorider.enumaration.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignUpDto {
    private String email;

    private String password;

    private Role role;


    public SignUpDto(String email, String password) {
        this.email = email;
        this.password = password;

    }

}
