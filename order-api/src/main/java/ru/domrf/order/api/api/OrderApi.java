package ru.domrf.order.api.api;

import java.util.UUID;
import ru.domrf.order.api.dto.OrderDTO;
import ru.domrf.order.api.dto.RequestOrderDTO;

public interface OrderApi {
    OrderDTO findOrderById(UUID id);
    OrderDTO createOrder(RequestOrderDTO orderDTO);
}
