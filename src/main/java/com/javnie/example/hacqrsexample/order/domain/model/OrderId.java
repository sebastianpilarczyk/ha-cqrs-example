package com.javnie.example.hacqrsexample.order.domain.model;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

import static java.util.Objects.isNull;

public final class OrderId {

    private final UUID value;

    private OrderId(UUID value) {
        this.value = value;
    }

    public static OrderId create() {
        return new OrderId(UUID.randomUUID());
    }

    public static OrderId of(UUID value) {
        if (isNull(value)) {
            throw new IllegalArgumentException();
        }
        return new OrderId(value);
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderId)) return false;
        OrderId orderId = (OrderId) o;
        return getValue().equals(orderId.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderId.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
