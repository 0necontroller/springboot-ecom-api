package com.onecontroller.ecommerce.repository;

import com.onecontroller.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
