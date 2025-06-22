package com.OPS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {
  @Id
  Long id;
  String description;
  @Enumerated(EnumType.STRING)
  OrderState state;

  public Order(Long id, String description) {
  }
}
