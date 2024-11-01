package com.example.motorider.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="motocycleType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MotorcycleType implements Sellable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
//@OneToMany(mappedBy = "motorcycleType",cascade = CascadeType.ALL)
//private List<Product> products;
}
