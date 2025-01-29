package com.example.motorider.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   @CreationTimestamp
    private LocalDateTime orderDate;
    private BigDecimal totalPrice;

    @Override
    public String toString() {
        return "Orders{" +
                "orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", id=" + id +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "order_spare_parts",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "spare_part_id")
    )
    private List<Product> products;

}
