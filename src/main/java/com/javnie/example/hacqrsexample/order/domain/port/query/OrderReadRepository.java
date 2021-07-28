package com.javnie.example.hacqrsexample.order.domain.port.query;

import com.javnie.example.hacqrsexample.order.domain.model.Order;
import com.javnie.example.hacqrsexample.order.domain.model.OrderId;
import com.javnie.example.hacqrsexample.order.domain.port.query.view.OrderView;

import java.util.List;

public interface OrderReadRepository {

    Order findById(OrderId orderId);

    List<OrderView> findAll();

}
