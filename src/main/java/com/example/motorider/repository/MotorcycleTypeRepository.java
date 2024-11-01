package com.example.motorider.repository;

import com.example.motorider.entitiy.MotorcycleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorcycleTypeRepository extends JpaRepository<MotorcycleType, Long> {
}
