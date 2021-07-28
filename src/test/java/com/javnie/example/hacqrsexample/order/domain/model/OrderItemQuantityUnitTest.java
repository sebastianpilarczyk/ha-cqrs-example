package com.javnie.example.hacqrsexample.order.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class OrderItemQuantityUnitTest {

    @Test
    public void shouldCreateOrderItemQuantity() {
        //when
        OrderItemQuantity orderItemQuantity = OrderItemQuantity.of(1);

        //then
        assertThat(orderItemQuantity).isNotNull();
    }

    @Test
    public void shouldFailIfInputValueIsLessThanOne() {
        //given
        int inputValue = 0;

        //when
        Throwable throwable = catchThrowable(() -> OrderItemQuantity.of(inputValue));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable.getMessage()).isEqualTo("order.item.quantity.should.be.greater.than.zero");
    }

    @Test
    public void shouldGetCorrectValueIfOrderItemQuantityHasBeenCreated() {
        //when
        OrderItemQuantity orderItemQuantity = OrderItemQuantity.of(1);

        //then
        assertThat(orderItemQuantity.getValue()).isEqualTo(1);
    }
}
