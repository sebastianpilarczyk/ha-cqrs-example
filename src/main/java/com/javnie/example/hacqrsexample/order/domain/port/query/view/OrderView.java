package com.javnie.example.hacqrsexample.order.domain.port.query.view;

import java.util.List;
import java.util.UUID;

public interface OrderView {

    UUID getOrderId();

    List<OrderItemView> getOrderItems();

}
