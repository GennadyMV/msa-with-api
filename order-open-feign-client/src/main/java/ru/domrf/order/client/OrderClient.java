package ru.domrf.order.client;

import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.domrf.order.api.api.OrderApi;
import ru.domrf.order.api.dto.OrderDTO;
import ru.domrf.order.api.dto.RequestOrderDTO;

@FeignClient(
    value = "order-service",
    path = "/order",
    url = "${order-service.url}")
public interface OrderClient extends OrderApi {

    @GetMapping("/{id}")
    @Override
    OrderDTO findOrderById(@PathVariable("id") UUID id);

    @PostMapping
    @Override
    OrderDTO createOrder(@RequestBody RequestOrderDTO orderDTO);
}
