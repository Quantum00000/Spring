package com.example.learning_01.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "Products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long  id;

@NotBlank(message="Product Name required")
@Column(nullable = false)
private String name;

@Column(nullable = false)
private String description;

@NotNull(message="Product price required")
@DecimalMin(value = "0.0", inclusive = false,message = "price should be > 0.0")
@Column(nullable = false)
private BigDecimal price;

@NotNull(message = "stock quantity required")
@Min(value = 0,message = "minimum value should be >= 0")
@Column(name = "stock_quantity",nullable = false)
private Integer stockQuantity;

//TODO RELATIONS

@JsonIgnore
@OneToMany(mappedBy = "product")
private List<OrderItem> orderItems;

}
