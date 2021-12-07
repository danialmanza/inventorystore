package com.almanza.inventorystore.service;

import com.almanza.inventorystore.models.ProductModel;
import com.almanza.inventorystore.models.ProductToAddModel;
import com.almanza.inventorystore.models.ProductToUpdateModel;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductService {

  List<ProductModel> getProductService();

 ProductModel createProductService(@RequestBody ProductToAddModel shirtToAddDto);

  ProductModel updateProductService(@RequestBody ProductToUpdateModel shirtToUpdateDto);

  List<ProductModel> deleteProductService(@PathVariable Integer id);
}
