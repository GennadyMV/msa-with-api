package ru.domrf.order.client.tooold;

import java.util.UUID;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.domrf.order.api.api.OrderApi;
import ru.domrf.order.api.dto.OrderDTO;
import ru.domrf.order.api.dto.RequestOrderDTO;

@FeignClient(
    name = "order-service",
    path = "/order",
    url = "${order-service.url}")
public interface OrderClientTooOldFeignVersion extends OrderApi {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    OrderDTO findOrderById(@PathVariable("id") UUID id);

    @RequestMapping(method = RequestMethod.POST)
    @Override
    OrderDTO createOrder(@RequestBody RequestOrderDTO orderDTO);
}
