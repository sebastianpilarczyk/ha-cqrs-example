package com.javnie.example.hacqrsexample.order.domain.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class OrderItemUnitTest {

    private static final UUID ORDER_ITEM_ID = UUID.randomUUID();
    private static final String ORDER_ITEM_NAME = "Order Item 1";
    private static final int ORDER_ITEM_QUANTITY = 1;

    @Test
    public void shouldCreateOrderItem() {
        //given
        OrderItemId id = OrderItemId.of(ORDER_ITEM_ID);
        OrderItemName name = OrderItemName.of(ORDER_ITEM_NAME);
        OrderItemQuantity quantity = OrderItemQuantity.of(ORDER_ITEM_QUANTITY);

        //when
        OrderItem orderItem = OrderItem.of(id, name, quantity);

        //then
        assertThat(orderItem).isNotNull();
        assertThat(orderItem.getOrderItemId()).isNotNull();
        assertThat(orderItem.getOrderItemName()).isNotNull();
        assertThat(orderItem.getOrderItemQuantity()).isNotNull();
    }

    @Test
    public void shouldFailIfOrderItemIdIsNull() {
        //given
        OrderItemId id = null;
        OrderItemName name = OrderItemName.of(ORDER_ITEM_NAME);
        OrderItemQuantity quantity = OrderItemQuantity.of(ORDER_ITEM_QUANTITY);

        //when
        Throwable throwable = catchThrowable(() -> OrderItem.of(id, name, quantity));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable.getMessage()).isEqualTo("order.item.id.is.required");
    }

    @Test
    public void shouldFailIfOrderItemNameIsNull() {
        //given
        OrderItemId id = OrderItemId.of(ORDER_ITEM_ID);
        OrderItemName name = null;
        OrderItemQuantity quantity = OrderItemQuantity.of(ORDER_ITEM_QUANTITY);

        //when
        Throwable throwable = catchThrowable(() -> OrderItem.of(id, name, quantity));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable.getMessage()).isEqualTo("order.item.name.is.required");
    }

    @Test
    public void shouldFailIfOrderItemQuantityIsNull() {
        //given
        OrderItemId id = OrderItemId.of(ORDER_ITEM_ID);
        OrderItemName name = OrderItemName.of(ORDER_ITEM_NAME);
        OrderItemQuantity quantity = null;

        //when
        Throwable throwable = catchThrowable(() -> OrderItem.of(id, name, quantity));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable.getMessage()).isEqualTo("order.item.quantity.is.required");
    }
}
