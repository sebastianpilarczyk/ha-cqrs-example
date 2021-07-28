package com.javnie.example.hacqrsexample.order.domain.model;

import java.util.Objects;
import java.util.StringJoiner;

import static java.util.Objects.isNull;

public final class OrderItemName {

    private final String value;

    private OrderItemName(String value) {
        this.value = value;
    }

    public static OrderItemName of(String value) {
        if (isNull(value) || value.isBlank()) {
            throw new IllegalArgumentException("order.item.name.is.required");
        }
        return new OrderItemName(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemName)) return false;
        OrderItemName that = (OrderItemName) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderItemName.class.getSimpleName() + "[", "]")
                .add("value='" + value + "'")
                .toString();
    }
}
