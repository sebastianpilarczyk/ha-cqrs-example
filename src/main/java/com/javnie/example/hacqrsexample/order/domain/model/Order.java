package com.javnie.example.hacqrsexample.order.domain.model;

import static java.util.Objects.isNull;

public class Order {

    private final OrderId orderId;
    private OrderItems orderItems;

    private Order(OrderId orderId, OrderItems orderItems) {
        this.orderId = orderId;
        this.orderItems = orderItems;
    }

    public static Order create() {
        return new Order(OrderId.create(), OrderItems.create());
    }

    public static Order of(OrderId orderId, OrderItems orderItems) {
        if (isNull(orderId)) {
            throw new IllegalArgumentException();
        }
        if (isNull(orderItems)) {
            orderItems = OrderItems.create();
        }
        return new Order(orderId, orderItems);
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public OrderItems getOrderItems() {
        return orderItems;
    }
}
