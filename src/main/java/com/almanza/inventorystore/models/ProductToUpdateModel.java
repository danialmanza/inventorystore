package com.almanza.inventorystore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductToUpdateModel {
  private Integer id;
  private String brand;
  private String color;
}
