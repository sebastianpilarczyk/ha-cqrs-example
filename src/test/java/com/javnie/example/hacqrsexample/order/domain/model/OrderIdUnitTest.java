package com.javnie.example.hacqrsexample.order.domain.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class OrderIdUnitTest {

    @Test
    public void shouldCreateNewOrderId() {
        //when
        OrderId orderId = OrderId.create();

        //then
        assertThat(orderId).isNotNull();
    }

    @Test
    public void shouldCreateOrderIdFromValue() {
        //given
        UUID inputValue = UUID.randomUUID();

        //when
        OrderId orderId = OrderId.of(inputValue);

        //then
        assertThat(orderId).isNotNull();
        assertThat(orderId.getValue()).isEqualTo(inputValue);
    }

    @Test
    public void shouldFailIfCreateOrderIdUsingNullAsValue() {
        //given
        UUID inputValue = null;

        //when
        Throwable throwable = catchThrowable(() -> OrderId.of(inputValue));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }
}
