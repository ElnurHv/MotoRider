package com.example.motorider.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="accessories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accessories implements Sellable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable();
    }

    @Override
    public String getDescription() {
        return "Parts" +name;
    }
}
