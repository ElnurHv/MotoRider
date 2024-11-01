package com.example.motorider.controller;

import com.example.motorider.dto.request.AccessoriesRequestDto;
import com.example.motorider.dto.response.AccessoriesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.motorider.service.AccessoriesService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accessories")
public class AccessoriesController {
    private final AccessoriesService accessoriesService;

    @PostMapping("/create")
    public String createOrder(@RequestBody AccessoriesRequestDto accessoriesRequestDto) {

        return accessoriesService.createAccessories(accessoriesRequestDto);
    }

    @GetMapping("get-all")
    public List<AccessoriesResponseDto> getAllOrders() {

        return accessoriesService.getAllAccessories();

    }

    @PutMapping("/update/{id}")
    public String updateOrder(@RequestBody AccessoriesRequestDto accessoriesRequestDto, @PathVariable Long id) {

        return accessoriesService.updateAccessories(accessoriesRequestDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return accessoriesService.deleteAccessories(id);

    }
}
