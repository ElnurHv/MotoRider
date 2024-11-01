package com.example.motorider.controller;

import com.example.motorider.dto.request.OrderRequestDto;
import com.example.motorider.dto.response.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.motorider.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/create")
    public String createOrder(@RequestBody OrderRequestDto orderRequestDto) {

        return orderService.createOrder(orderRequestDto);
    }

    @GetMapping("get-all")
    public List<OrderResponseDto> getAllOrders() {

        return orderService.getAllOrders();

    }

    @PutMapping("/update/{id}")
    public String updateOrder(@RequestBody OrderRequestDto orderRequestDto, @PathVariable Long id) {

        return orderService.UpdateOrder(orderRequestDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);

    }
}
