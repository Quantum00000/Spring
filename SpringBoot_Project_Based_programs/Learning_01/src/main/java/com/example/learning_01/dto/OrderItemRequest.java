package com.example.learning_01.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemRequest {

    @NotNull(message = "Product id required")
    private Long productId;

    @NotNull(message = "Product quantity required")
    @Min(value = 1,message = "Atleast 1 product is required")
    private Integer quantity;
}
