package com.onecontroller.ecommerce.service.product;

import java.util.List;
import com.onecontroller.ecommerce.model.Product;

public interface IProductService {
    Product addProduct(Product product);

    Product getProduct(String productId);

    void updateProduct(Product product, String productId);
    void deleteProduct(String id);

    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String categoryId);
    List<Product> getProductsByBrand(String brandName);
    List<Product> getProductsByBrandAndCategory(String brandName, String categoryName);
    List<Product> getProductByName(String productName);
    List<Product> getProductByBrandAndName(String brandName, String productName);

    Long countProductsByBrandAndName(String brandName, String productName);
}