package com.javnie.example.hacqrsexample.order.domain.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class OrderItemIdUnitTest {

    @Test
    public void shouldCreateNewOrderItemId() {
        //when
        OrderItemId orderItemId = OrderItemId.create();

        //then
        assertThat(orderItemId).isNotNull();
    }

    @Test
    public void shouldCreateOrderItemIdFromValue() {
        //given
        UUID inputValue = UUID.randomUUID();

        //when
        OrderItemId orderItemId = OrderItemId.of(inputValue);

        //then
        assertThat(orderItemId).isNotNull();
        assertThat(orderItemId.getValue()).isEqualTo(inputValue);
    }

    @Test
    public void shouldFailIfCreateOrderIdUsingNullInputValue() {
        //given
        UUID inputValue = null;

        //when
        Throwable throwable = catchThrowable(() -> OrderItemId.of(inputValue));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }
}
