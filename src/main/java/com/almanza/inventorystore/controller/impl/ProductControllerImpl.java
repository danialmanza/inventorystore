package com.almanza.inventorystore.controller.impl;

import com.almanza.inventorystore.controller.ProductController;
import com.almanza.inventorystore.controller.dto.ProductDTO;
import com.almanza.inventorystore.controller.dto.ProductToAddDTO;
import com.almanza.inventorystore.controller.dto.ProductToUpdateDTO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/inventory")
public class ProductControllerImpl implements ProductController {

  @Override
  public ResponseEntity<List<ProductDTO>> getProduct() {
    return ResponseEntity.status(HttpStatus.OK).body(List.of(
        new ProductDTO(1,"Nike","Blue"),
        new ProductDTO(2,"Puma","Black"),
        new ProductDTO(3,"Adidas","White")
    ));
  }

  @Override
  public ResponseEntity<ProductDTO> createProduct(ProductToAddDTO productToAddDTO) {
    Integer randomNum = (int) (Math.random()*500+1);
    return ResponseEntity.status(HttpStatus.OK).body(ProductDTO.builder()
        .id(randomNum)
        .brand(productToAddDTO.getBrand())
        .color(productToAddDTO.getColor())
        .build());
  }

  @Override
  public ResponseEntity<ProductDTO> updateProduct(ProductToUpdateDTO productToUpdateDTO) {
    List<ProductDTO> productList = new ArrayList<>(List.of(
        new ProductDTO(1,"Nike","Blue"),
        new ProductDTO(2,"Puma","Black"),
        new ProductDTO(3,"Adidas","White")
    ));

    Optional<ProductDTO> productToFind = productList.stream()
        .filter(shirtDto -> productToUpdateDTO.getId().equals(shirtDto.getId()))
        .findAny();
    if (productToFind.isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).body(ProductDTO.builder()
          .color(productToUpdateDTO.getColor())
          .id(productToUpdateDTO.getId())
          .brand(productToUpdateDTO.getBrand()).build());
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @Override
  public ResponseEntity<List<ProductDTO>> deleteProduct(Integer id) {

    List<ProductDTO> productList = new LinkedList<ProductDTO>(
        List.of(
            new ProductDTO(1, "Clothing", "Blue"),
            new ProductDTO(2, "Clothing", "Black"),
            new ProductDTO(3, "Clothing", "Red")
        ));

    Optional<ProductDTO> productToFind = productList.stream()
        .filter(productDTO -> id.equals(productDTO.getId()))
        .findAny();
    if (productToFind.isPresent()) {
      productList.remove(productToFind.get());
      System.out.println(productList);
      return ResponseEntity.status(HttpStatus.OK).body(productList);
    }else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
