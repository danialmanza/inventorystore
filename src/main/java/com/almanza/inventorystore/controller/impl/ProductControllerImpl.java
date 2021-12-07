package com.almanza.inventorystore.controller.impl;

import com.almanza.inventorystore.controller.ProductController;
import com.almanza.inventorystore.models.ProductModel;
import com.almanza.inventorystore.models.ProductToAddModel;
import com.almanza.inventorystore.models.ProductToUpdateModel;
import com.almanza.inventorystore.service.ProductService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/inventory")
@AllArgsConstructor
public class ProductControllerImpl implements ProductController {

  private ProductService productService;

  @Override
  public ResponseEntity<List<ProductModel>> getProduct() {
    return ResponseEntity.status(HttpStatus.OK).body(productService.getProductService());
  }

  @Override
  public ResponseEntity<ProductModel> createProduct(ProductToAddModel productToAddModel) {
    return ResponseEntity.status(HttpStatus.OK).body(productService.createProductService(
        productToAddModel));
  }

  @Override
  public ResponseEntity<ProductModel> updateProduct(ProductToUpdateModel productToUpdateModel) {

      return ResponseEntity.status(HttpStatus.OK).body(
          productService.updateProductService(productToUpdateModel
          ));
  }

  @Override
  public ResponseEntity<List<ProductModel>> deleteProduct(Integer id) {

      return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProductService(id));
  }
}
