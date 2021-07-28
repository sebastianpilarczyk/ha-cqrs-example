package com.javnie.example.hacqrsexample.order.domain.model;

import static java.util.Objects.isNull;

public class OrderItem {

    private final OrderItemId orderItemId;
    private final OrderItemName orderItemName;
    private final OrderItemQuantity orderItemQuantity;

    private OrderItem(OrderItemId orderItemId, OrderItemName orderItemName, OrderItemQuantity orderItemQuantity) {
        this.orderItemId = orderItemId;
        this.orderItemName = orderItemName;
        this.orderItemQuantity = orderItemQuantity;
    }

    public static OrderItem of(OrderItemId orderItemId, OrderItemName orderItemName, OrderItemQuantity orderItemQuantity) {
        checkPreconditions(orderItemId, orderItemName, orderItemQuantity);
        return new OrderItem(orderItemId, orderItemName, orderItemQuantity);
    }
    
    public OrderItemId getOrderItemId() {
        return orderItemId;
    }

    public OrderItemName getOrderItemName() {
        return orderItemName;
    }

    public OrderItemQuantity getOrderItemQuantity() {
        return orderItemQuantity;
    }

    private static void checkPreconditions(OrderItemId orderItemId, OrderItemName orderItemName, OrderItemQuantity orderItemQuantity) {
        if (isNull(orderItemId)) {
            throw new IllegalArgumentException("order.item.id.is.required");
        }
        if (isNull(orderItemName)) {
            throw new IllegalArgumentException("order.item.name.is.required");
        }
        if (isNull(orderItemQuantity)) {
            throw new IllegalArgumentException("order.item.quantity.is.required");
        }
    }
}
