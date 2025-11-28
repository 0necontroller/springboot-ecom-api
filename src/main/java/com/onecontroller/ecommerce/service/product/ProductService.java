package com.onecontroller.ecommerce.service.product;

import java.util.List;

import com.onecontroller.ecommerce.exceptions.ProductNotFoundException;
import com.onecontroller.ecommerce.model.Product;
import com.onecontroller.ecommerce.repository.ProductRepository;

class  ProductService implements IProductService {
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product getProduct(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(()-> new ProductNotFoundException("Product Not Found!"));
    }

    @Override
    public void updateProduct(Product product, String productId) {

    }

    @Override
    public void deleteProduct(String id) {

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public List<Product> getProductsByCategory(String categoryId) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByBrand(String brandName) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByBrandAndCategory(String brandName, String categoryName) {
        return List.of();
    }

    @Override
    public List<Product> getProductByName(String productName) {
        return List.of();
    }

    @Override
    public List<Product> getProductByBrandAndName(String brandName, String productName) {
        return List.of();
    }

    @Override
    public Long countProductsByBrandAndName(String brandName, String productName) {
        return 0L;
    }
}
