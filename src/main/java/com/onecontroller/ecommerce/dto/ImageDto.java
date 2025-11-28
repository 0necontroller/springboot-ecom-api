package com.onecontroller.ecommerce.dto;

import lombok.Data;
import com.onecontroller.ecommerce.model.Product;

@Data
public class ImageDto {
    private String id;
    private String fileType;
    private String fileName;
    private String s3Key;
    private Product product;
}
