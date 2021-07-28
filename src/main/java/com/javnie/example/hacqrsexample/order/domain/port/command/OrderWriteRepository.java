package com.javnie.example.hacqrsexample.order.domain.port.command;

import com.javnie.example.hacqrsexample.order.domain.model.Order;
import com.javnie.example.hacqrsexample.order.domain.model.OrderId;

public interface OrderWriteRepository {

    void save(Order order);

    void delete(OrderId orderId);

}
