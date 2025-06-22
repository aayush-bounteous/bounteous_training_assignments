package com.OPS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.StateMachineContext;

import java.util.List;
import java.util.Map;


public enum OrderState implements StateMachineContext<OrderState, OrderEvent> {
    NEW,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED;

    @Override
    public String getId() {
        return "";
    }

    @Override
    public List<StateMachineContext<OrderState, OrderEvent>> getChilds() {
        return List.of();
    }

    @Override
    public List<String> getChildReferences() {
        return List.of();
    }

    @Override
    public OrderState getState() {
        return null;
    }

    @Override
    public OrderEvent getEvent() {
        return null;
    }

    @Override
    public Map<OrderState, OrderState> getHistoryStates() {
        return Map.of();
    }

    @Override
    public Map<String, Object> getEventHeaders() {
        return Map.of();
    }

    @Override
    public ExtendedState getExtendedState() {
        return null;
    }
}
