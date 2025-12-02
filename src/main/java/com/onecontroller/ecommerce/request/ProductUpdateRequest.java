package com.onecontroller.ecommerce.request;

import com.onecontroller.ecommerce.model.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateRequest {
    private String id;
    private String brand;
    private String name;
    private BigDecimal price;
    private Integer inventory;
    private String description;
    private Category category;
}
