package com.javnie.example.hacqrsexample.order.domain.model;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

import static java.util.Objects.isNull;

public final class OrderItemId {

    private final UUID value;

    private OrderItemId(UUID value) {
        this.value = value;
    }

    public static OrderItemId create() {
        return new OrderItemId(UUID.randomUUID());
    }

    public static OrderItemId of(UUID value) {
        if (isNull(value)) {
            throw new IllegalArgumentException();
        }
        return new OrderItemId(value);
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemId)) return false;
        OrderItemId that = (OrderItemId) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderItemId.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
