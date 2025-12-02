package com.onecontroller.ecommerce.repository;

import com.onecontroller.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findByName(String name);
}
