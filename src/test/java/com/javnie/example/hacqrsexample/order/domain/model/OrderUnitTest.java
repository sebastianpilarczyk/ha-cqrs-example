package com.javnie.example.hacqrsexample.order.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class OrderUnitTest {

    @Test
    public void shouldCreateOrder() {
        //when
        Order order = Order.create();

        //then
        assertThat(order).isNotNull();
    }

    @Test
    public void shouldCreateOrderWithCorrectOrderId() {
        //given
        OrderId orderId = OrderId.create();
        OrderItems orderItems = OrderItems.create();

        //when
        Order order = Order.of(orderId, orderItems);

        //then
        assertThat(order).isNotNull();
    }

    @Test
    public void shouldCreateOrderWithCorrectEmptyListOfOrderItems() {
        //given
        OrderId orderId = OrderId.create();
        OrderItems orderItems = OrderItems.create();

        //when
        Order order = Order.of(orderId, orderItems);

        //then
        assertThat(order).isNotNull();
    }

    @Test
    public void shouldCreateOrderIfOrderItemsIsNull() {
        //given
        OrderId orderId = OrderId.create();
        OrderItems orderItems = null;

        //when
        Order order = Order.of(orderId, orderItems);

        //then
        assertThat(order).isNotNull();
    }

    @Test
    public void shouldFailIfTryingToCreateOrderWithNullOrderId() {
        //given
        OrderId orderId = null;
        OrderItems orderItems = OrderItems.create();

        //when
        Throwable throwable = catchThrowable(() -> Order.of(orderId, orderItems));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void shouldGetOrderIdIfOrderHasBeenCreatedCorrectly() {
        //given
        OrderId orderId = OrderId.create();
        OrderItems orderItems = OrderItems.create();

        //when
        Order order = Order.of(orderId, orderItems);

        //then
        assertThat(order.getOrderId()).isNotNull();
    }

    @Test
    public void shouldGetOrderItemsIfOrderHasBeenCreatedCorrectly() {
        //given
        OrderId orderId = OrderId.create();
        OrderItems orderItems = OrderItems.create();

        //when
        Order order = Order.of(orderId, orderItems);

        //then
        assertThat(order.getOrderItems()).isNotNull();
    }
}
