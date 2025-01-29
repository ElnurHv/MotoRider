package com.example.motorider.security;
import com.example.motorider.enumaration.Role;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;

    private String email;
    private String password;

    private Role role;
}
