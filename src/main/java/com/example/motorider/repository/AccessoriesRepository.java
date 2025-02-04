package com.example.motorider.repository;

import com.example.motorider.entity.Accessories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoriesRepository extends JpaRepository<Accessories, Long> {
}
