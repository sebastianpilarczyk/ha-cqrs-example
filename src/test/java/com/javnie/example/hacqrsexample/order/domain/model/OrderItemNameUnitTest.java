package com.javnie.example.hacqrsexample.order.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class OrderItemNameUnitTest {

    @Test
    public void shouldCreateOrderItemName() {
        //when
        OrderItemName orderItemName = OrderItemName.of("Test order item name");

        //then
        assertThat(orderItemName).isNotNull();
    }

    @Test
    public void shouldFailIfInputValueIsNull() {
        //given
        String inputValue = null;

        //when
        Throwable throwable = catchThrowable(() -> OrderItemName.of(inputValue));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable.getMessage()).isEqualTo("order.item.name.is.required");
    }

    @Test
    public void shouldFailIfInputValueIsBlank() {
        //given
        String inputValue = "             ";

        //when
        Throwable throwable = catchThrowable(() -> OrderItemName.of(inputValue));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable.getMessage()).isEqualTo("order.item.name.is.required");
    }
}
