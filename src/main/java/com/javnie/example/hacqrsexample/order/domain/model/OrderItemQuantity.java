package com.javnie.example.hacqrsexample.order.domain.model;

import java.util.Objects;
import java.util.StringJoiner;

public final class OrderItemQuantity {

    private final int value;

    public OrderItemQuantity(int value) {
        this.value = value;
    }

    public static OrderItemQuantity of(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("order.item.quantity.should.be.greater.than.zero");
        }
        return new OrderItemQuantity(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemQuantity)) return false;
        OrderItemQuantity that = (OrderItemQuantity) o;
        return getValue() == that.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderItemQuantity.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
