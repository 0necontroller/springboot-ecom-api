package com.onecontroller.ecommerce.service.product;

import java.util.List;

import com.onecontroller.ecommerce.dto.ProductDto;
import com.onecontroller.ecommerce.exceptions.ProductNotFoundException;
import com.onecontroller.ecommerce.model.Product;
import com.onecontroller.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class  ProductService implements IProductService {
    private final ProductRepository productRepository;

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
        productRepository.findById(id).
                ifPresentOrElse(productRepository::delete,
                        ()->{ throw new ProductNotFoundException("Product Not Found!");
                });

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Product> getProductsByBrand(String brandName) {
        return productRepository.findByBrand(brandName);
    }

    @Override
    public List<Product> getProductsByBrandAndCategory(String brandName, String categoryName) {
        return productRepository.findByBrandAndCategoryName(brandName, categoryName);
    }

    @Override
    public List<Product> getProductByName(String productName) {
        return productRepository.findByName(productName);
    }

    @Override
    public List<Product> getProductByBrandAndName(String brandName, String productName) {
        return productRepository.findByBrandAndName(brandName, productName);
    }

    @Override
    public Long countProductsByBrandAndName(String brandName, String productName) {
        return productRepository.countByBrandAndName(brandName, productName);
    }

    @Override
    public ProductDto convertToDto(Product product) {
        return null;
    }
}
