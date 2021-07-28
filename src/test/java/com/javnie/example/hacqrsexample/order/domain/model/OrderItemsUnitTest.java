package com.javnie.example.hacqrsexample.order.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.emptySet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class OrderItemsUnitTest {

    @Test
    public void shouldCreateNewOrderItems() {
        //when
        OrderItems orderItems = OrderItems.create();

        //then
        assertThat(orderItems).isNotNull();
        assertThat(orderItems.listAll()).isEmpty();
    }

    @Test
    public void shouldCreateOrderItemsFromListOfIts() {
        //given
        Set<OrderItem> inputValues = createTestSet();

        //when
        OrderItems orderItems = OrderItems.of(inputValues);

        //then
        assertThat(orderItems).isNotNull();
        assertThat(orderItems.listAll()).hasSize(2);
    }

    @Test
    public void shouldCreateOrderItemsIfInputListIsNull() {
        //given
        Set<OrderItem> inputValues = null;

        //when
        OrderItems orderItems = OrderItems.of(inputValues);

        //then
        assertThat(orderItems).isNotNull();
        assertThat(orderItems.listAll()).isEmpty();
    }

    @Test
    public void shouldCreateOrderItemsIfInputListIsEmpty() {
        //given
        Set<OrderItem> inputValues = emptySet();

        //when
        OrderItems orderItems = OrderItems.of(inputValues);

        //then
        assertThat(orderItems).isNotNull();
        assertThat(orderItems.listAll()).isEmpty();
    }

    @Test
    public void shouldAddNewOrderItem() {
        //given
        OrderItems orderItems = OrderItems.create();
        OrderItem orderItem = createTestOrderItem();

        //when
        orderItems.add(orderItem);

        //then
        assertThat(orderItems.listAll()).hasSize(1);
    }

    @Test
    public void shouldRemoveExistsOrderItem() {
        //given
        OrderItems orderItems = OrderItems.create();
        OrderItem orderItem = createTestOrderItem();
        orderItems.add(orderItem);

        //when
        orderItems.remove(orderItem.getOrderItemId());

        //then
        assertThat(orderItems.listAll()).isEmpty();
    }

    @Test
    public void shouldListAllOrderItemsAsUnmodifiableList() {
        //given
        OrderItems orderItems = OrderItems.create();
        OrderItem orderItem = createTestOrderItem();
        orderItems.add(orderItem);

        //when
        Throwable throwable = catchThrowable(() -> orderItems.listAll().clear());

        //then
        assertThat(throwable).isInstanceOf(UnsupportedOperationException.class);
    }

    private OrderItem createTestOrderItem() {
        return OrderItem.of(OrderItemId.create(), OrderItemName.of("Test 1"), OrderItemQuantity.of(1));
    }

    private Set<OrderItem> createTestSet() {
        OrderItem orderItem1 = OrderItem.of(OrderItemId.create(), OrderItemName.of("Test 1"), OrderItemQuantity.of(1));
        OrderItem orderItem2 = OrderItem.of(OrderItemId.create(), OrderItemName.of("Test 2"), OrderItemQuantity.of(1));
        return Stream.of(orderItem1, orderItem2).collect(Collectors.toSet());
    }
}
