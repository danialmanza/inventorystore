package com.almanza.inventorystore.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductToUpdateDTO {
  private Integer id;
  private String brand;
  private String color;
}
