package com.onecontroller.ecommerce.repository;

import com.onecontroller.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product> findByCategoryId(String categoryId);

    List<Product> findByBrand(String brandName);

    List<Product> findByBrandAndCategoryName(String brandName, String categoryName);

    List<Product> findByName(String productName);

    List<Product> findByBrandAndName(String brandName, String productName);

    Long countByBrandAndName(String brandName, String productName);
}
