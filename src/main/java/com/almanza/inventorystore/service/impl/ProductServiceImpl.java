package com.almanza.inventorystore.service.impl;

import com.almanza.inventorystore.models.ProductModel;
import com.almanza.inventorystore.models.ProductToAddModel;
import com.almanza.inventorystore.models.ProductToUpdateModel;
import com.almanza.inventorystore.service.ProductService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
  @Override
  public List<ProductModel> getProductService() {
    return List.of(
        new ProductModel(1,"Nike","Blue"),
        new ProductModel(2,"Puma","Black"),
        new ProductModel(3,"Adidas","White")
    );
  }

  @Override
  public ProductModel createProductService(ProductToAddModel productToAddModel) {
    Integer randomNum = (int) (Math.random()*500+1);
    return ProductModel.builder()
        .id(randomNum)
        .brand(productToAddModel.getBrand())
        .color(productToAddModel.getColor())
        .build();
  }

  @Override
  public ProductModel updateProductService(ProductToUpdateModel productToUpdateModel) {
    List<ProductModel> productList = new ArrayList<>(List.of(
        new ProductModel(1,"Nike","Blue"),
        new ProductModel(2,"Puma","Black"),
        new ProductModel(3,"Adidas","White")
    ));

    Optional<ProductModel> productToFind = productList.stream()
        .filter(shirtDto -> productToUpdateModel.getId().equals(shirtDto.getId()))
        .findAny();

    if (productToFind.isPresent()) {
      return ProductModel.builder()
          .color(productToUpdateModel.getColor())
          .id(productToUpdateModel.getId())
          .brand(productToUpdateModel.getBrand()).build();
    } else {
      return null;
    }
  }

  @Override
  public List<ProductModel> deleteProductService(Integer id) {

    List<ProductModel> productList = new LinkedList<ProductModel>(
        List.of(
            new ProductModel(1, "Clothing", "Blue"),
            new ProductModel(2, "Clothing", "Black"),
            new ProductModel(3, "Clothing", "Red")
        ));

    Optional<ProductModel> productToFind = productList.stream()
        .filter(productDTO -> id.equals(productDTO.getId()))
        .findAny();
    if (productToFind.isPresent()) {
      productList.remove(productToFind.get());
      return productList;
    }else {
      return null;
    }
  }
}
