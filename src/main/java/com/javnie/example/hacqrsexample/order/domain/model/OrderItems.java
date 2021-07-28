package com.javnie.example.hacqrsexample.order.domain.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public final class OrderItems {

    private final Set<OrderItem> orderItems;

    private OrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public static OrderItems create() {
        return new OrderItems(new HashSet<>());
    }

    public static OrderItems of(Collection<OrderItem> orderItems) {
        if (isNull(orderItems) || orderItems.isEmpty()) {
            return new OrderItems(new HashSet<>());
        }
        return new OrderItems(new HashSet<>(orderItems));
    }

    public void add(OrderItem orderItem) {
        if (nonNull(orderItem)) {
            orderItems.add(orderItem);
        }
    }

    public void remove(OrderItemId orderItemId) {
        orderItems.removeIf(orderItem -> orderItem.getOrderItemId().equals(orderItemId));
    }

    public Set<OrderItem> listAll() {
        return unmodifiableSet(orderItems);
    }
}
