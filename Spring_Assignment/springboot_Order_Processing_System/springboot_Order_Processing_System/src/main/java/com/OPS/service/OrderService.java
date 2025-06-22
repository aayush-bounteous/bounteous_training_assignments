package com.OPS.service;

import com.OPS.model.Order;
import com.OPS.model.OrderEvent;
import com.OPS.model.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;


import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {

    private final StateMachine<OrderState, OrderEvent> stateMachine;
    private final AtomicLong idGenerator = new AtomicLong();

    @Autowired
    public OrderService(StateMachine<OrderState, OrderEvent> stateMachine) {
        this.stateMachine = stateMachine;
    }

    // Create a new order
    public Order createOrder(String description) {
        Long id = idGenerator.incrementAndGet();
        Order order = new Order(id, description);
        System.out.println("✅ Created Order ID: " + id + ", State: " + order.getState());
        return order;
    }

    // Process an event on the order
    public void handleEvent(Order order, OrderEvent event) {
        // Set the state machine to current order's state
        stateMachine.stop();
        stateMachine.getStateMachineAccessor().doWithAllRegions(access ->
                access.resetStateMachine(order.getState()));
        stateMachine.start();

        // Send event
        boolean success = stateMachine.sendEvent(MessageBuilder.withPayload(event).build());

        // Update order state if transition happened
        if (success && stateMachine.getState() != null) {
            order.setState(stateMachine.getState().getId());
            System.out.println("➡️ Order ID " + order.getId() + " moved to state: " + order.getState());
        } else {
            System.out.println("❌ Invalid event: " + event + " from state: " + order.getState());
        }
    }
}