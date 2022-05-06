package ru.domrf.order.orderservice.controller;

import java.time.LocalDate;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.domrf.order.api.api.OrderApi;
import ru.domrf.order.api.dto.OrderDTO;
import ru.domrf.order.api.dto.RequestOrderDTO;

@RestController
@RequestMapping("/order")
public class OrderController implements OrderApi {

    @GetMapping("/{id}")
    public OrderDTO findOrderById(@PathVariable UUID id) {
        return OrderDTO.builder()
            .id(id)
            .build();
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody RequestOrderDTO orderDTO) {
        return OrderDTO.builder()
            .id(UUID.randomUUID())
            .amount(orderDTO.getAmount())
            .description(orderDTO.getDescription())
            .date(LocalDate.now())
            .build();
    }
}
