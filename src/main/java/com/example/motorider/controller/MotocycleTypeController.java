package com.example.motorider.controller;

import com.example.motorider.dto.request.MotocycleTypeRequestDto;
import com.example.motorider.dto.response.MotorcycleTypeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.motorider.service.MotorcycleTypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/motocycleType")
public class MotocycleTypeController {
    private final MotorcycleTypeService motorcycleTypeService;


    @PostMapping("/create")
    public String createOrder(@RequestBody MotocycleTypeRequestDto motocycleTypeRequestDto) {

        return motorcycleTypeService.createMotorcycleType(motocycleTypeRequestDto);
    }

    @GetMapping("get-all")
    public List<MotorcycleTypeResponseDto> getAllOrders() {

        return motorcycleTypeService.getAllMotorcycleTypes();

    }

    @PutMapping("/update/{id}")
    public String updateOrder(@RequestBody MotocycleTypeRequestDto motocycleTypeRequestDto, @PathVariable Long id) {

        return motorcycleTypeService.updatemotorcycleType(motocycleTypeRequestDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return motorcycleTypeService.deleteMotorcycleType(id);

    }
}
