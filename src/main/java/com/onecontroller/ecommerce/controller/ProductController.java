package com.onecontroller.ecommerce.controller;

import com.onecontroller.ecommerce.dto.ProductDto;
import com.onecontroller.ecommerce.exceptions.ProductNotFoundException;
import com.onecontroller.ecommerce.model.Product;
import com.onecontroller.ecommerce.response.ApiResponse;
import com.onecontroller.ecommerce.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import static org.springframework.http.HttpStatus.NOT_FOUND;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/products")
public class ProductController {
    private final IProductService productService;

    @GetMapping("all")
    public ResponseEntity<ApiResponse> getAllProducts(){
        try {
            List<Product> products = productService.getAllProducts();
            List<ProductDto> productsDto = productService.getProductsDto(products);

            ApiResponse response = ApiResponse.success(productsDto, "Fetched all products");
            return ResponseEntity.ok(response);
        }catch (ProductNotFoundException err){
            ApiResponse response = ApiResponse.error(err.getMessage());
            return ResponseEntity.status(NOT_FOUND).body(response);
        }
    }
}
