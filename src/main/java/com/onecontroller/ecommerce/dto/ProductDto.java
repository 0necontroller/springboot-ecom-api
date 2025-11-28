package com.onecontroller.ecommerce.dto;

import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import com.onecontroller.ecommerce.model.Category;

@Data
public class ProductDto {
    private String id;

    private String brand;
    private String name;
    private BigDecimal price;
    private Integer inventory;
    private String description;

    private Category category;

   private List<ImageDto> images;
}
