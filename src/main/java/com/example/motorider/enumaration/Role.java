package com.example.motorider.enumaration;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public enum Role implements GrantedAuthority {
    ADMIN("ROLE_ADMIN"),
    EDITOR("ROLE_EDITOR"),
    USER("ROLE_USER");

    private final String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
