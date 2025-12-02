package com.onecontroller.ecommerce.service.product;

import java.util.List;

import com.onecontroller.ecommerce.dto.ProductDto;
import com.onecontroller.ecommerce.model.Product;
import com.onecontroller.ecommerce.request.AddProductRequest;
import com.onecontroller.ecommerce.request.ProductUpdateRequest;

public interface IProductService {
    Product addProduct(AddProductRequest product);

    Product getProduct(String productId);

    Product updateProduct(ProductUpdateRequest product);
    void deleteProduct(String id);

    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String categoryId);
    List<Product> getProductsByBrand(String brandName);
    List<Product> getProductsByBrandAndCategory(String brandName, String categoryName);
    List<Product> getProductByName(String productName);
    List<Product> getProductByBrandAndName(String brandName, String productName);

    Long countProductsByBrandAndName(String brandName, String productName);
    ProductDto convertToDto(Product product);
}