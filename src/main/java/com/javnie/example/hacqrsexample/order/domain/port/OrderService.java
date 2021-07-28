package com.javnie.example.hacqrsexample.order.domain.port;

import com.javnie.example.hacqrsexample.order.domain.model.Order;
import com.javnie.example.hacqrsexample.order.domain.model.OrderId;
import com.javnie.example.hacqrsexample.order.domain.model.OrderItem;
import com.javnie.example.hacqrsexample.order.domain.model.OrderItemId;
import com.javnie.example.hacqrsexample.order.domain.port.command.OrderWriteRepository;
import com.javnie.example.hacqrsexample.order.domain.port.query.OrderReadRepository;
import com.javnie.example.hacqrsexample.order.shared.OrderBusinessLogicException;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class OrderService {

    private final OrderWriteRepository writeRepository;
    private final OrderReadRepository readRepository;

    public OrderService(OrderWriteRepository writeRepository, OrderReadRepository readRepository) {
        this.writeRepository = writeRepository;
        this.readRepository = readRepository;
    }

    public void create(Order order) {
        writeRepository.save(order);
    }

    public void deleteByOrderId(OrderId orderId) {
        writeRepository.delete(orderId);
    }

    public void addOrderItem(OrderId orderId, OrderItem orderItem) {
        Order order = readRepository.findById(orderId);
        if (isNull(order)) {
            throw new OrderBusinessLogicException();
        }
        order.getOrderItems().add(orderItem);
        writeRepository.save(order);
    }

    public void removeOrderItem(OrderId orderId, OrderItemId orderItemId) {
        Order order = readRepository.findById(orderId);
        if (nonNull(order)) {
            order.getOrderItems().remove(orderItemId);
        }
        writeRepository.save(order);
    }
}
