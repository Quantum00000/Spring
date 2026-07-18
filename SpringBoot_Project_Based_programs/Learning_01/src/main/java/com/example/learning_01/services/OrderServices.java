package com.example.learning_01.services;

import com.example.learning_01.dto.OrderItemRequest;
import com.example.learning_01.dto.OrderRequest;
import com.example.learning_01.entites.Order;
import com.example.learning_01.entites.OrderItem;
import com.example.learning_01.entites.Product;
import com.example.learning_01.repository.OrderItemRepository;
import com.example.learning_01.repository.OrderRepository;
import com.example.learning_01.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServices {


    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Transactional

    public Order createOrder(OrderRequest orderRequest){

        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal totalPrice =new BigDecimal(BigInteger.ZERO);
        Order order = new Order();

        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("CONFIRM");

        for(OrderItemRequest itemRequest : orderRequest.getItem()){
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(()-> new RuntimeException("Product not found , of id:"+itemRequest.getProductId()));

            //Check for stock quantity
            if(product.getStockQuantity()<itemRequest.getQuantity()){
                throw new RuntimeException("Certain product is out of stock:"+itemRequest.getProductId());
            }

            //Total price
            BigDecimal priceOfItem = product.getPrice().multiply(BigDecimal.valueOf(itemRequest.getQuantity()));
            totalPrice=totalPrice.add(priceOfItem);

            //setting latest stock quantity
            product.setStockQuantity(product.getStockQuantity()- itemRequest.getQuantity());
            productRepository.save(product);

            //Builder pattern to make obj
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(itemRequest.getQuantity())
                    .priceAtPurchase(product.getPrice())
                    .build();

            orderItems.add(orderItem);

            order.setTotalPrize(totalPrice);
            order.setOrderItems(orderItems);



        }

        return orderRepository.save(order);

    }

}
