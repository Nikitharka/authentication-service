package com.example.authentication_service.controller;

import com.example.authentication_service.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public ResponseEntity<ApiResponse<List<String>>> getAllOrders() {

        List<String> orders = List.of(
                "Order-101: Laptop",
                "Order-102: Mobile",
                "Order-103: Headphones"
        );

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Orders fetched successfully",
                        orders
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> getOrderById(
            @PathVariable String id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Order fetched successfully",
                        "Order-" + id + ": Sample order details"
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createOrder() {

        return ResponseEntity
                .status(201)
                .body(new ApiResponse<>(
                        true,
                        "Order created successfully",
                        "New sample order created"
                ));
    }
}