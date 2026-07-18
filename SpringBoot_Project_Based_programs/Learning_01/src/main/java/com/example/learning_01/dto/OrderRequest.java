package com.example.learning_01.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

    @NotBlank(message = "Customer Name required")
    private String customerName;

    @Email(message = "Enter a valid Email")
    @NotBlank(message = "Email should not be blank")
    private String customerEmail;

    @Valid
    @NotEmpty(message = "There should be at least one item")
    private List<OrderItemRequest> item;
}
