package com.almanza.inventorystore.controller;

import com.almanza.inventorystore.controller.dto.ProductDTO;
import com.almanza.inventorystore.controller.dto.ProductToAddDTO;
import com.almanza.inventorystore.controller.dto.ProductToUpdateDTO;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductController {

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<ProductDTO>> getProduct();

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<ProductDTO> createProduct(@RequestBody ProductToAddDTO shirtToAddDto);

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductToUpdateDTO shirtToUpdateDto);

  @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<ProductDTO>> deleteProduct(@PathVariable Integer id);
}
