package com.almanza.inventorystore.controller;

import com.almanza.inventorystore.models.ProductModel;
import com.almanza.inventorystore.models.ProductToAddModel;
import com.almanza.inventorystore.models.ProductToUpdateModel;
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
  ResponseEntity<List<ProductModel>> getProduct();

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<ProductModel> createProduct(@RequestBody ProductToAddModel productToAddModel);

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<ProductModel> updateProduct(@RequestBody ProductToUpdateModel productToUpdateModel);

  @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<ProductModel>> deleteProduct(@PathVariable Integer id);
}
