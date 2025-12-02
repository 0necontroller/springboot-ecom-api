package com.onecontroller.ecommerce.service.product;

import java.util.List;
import java.util.Optional;

import com.onecontroller.ecommerce.dto.ImageDto;
import com.onecontroller.ecommerce.dto.ProductDto;
import com.onecontroller.ecommerce.exceptions.ProductNotFoundException;
import com.onecontroller.ecommerce.model.Category;
import com.onecontroller.ecommerce.model.Image;
import com.onecontroller.ecommerce.model.Product;
import com.onecontroller.ecommerce.repository.CategoryRepository;
import com.onecontroller.ecommerce.repository.ImageRepository;
import com.onecontroller.ecommerce.repository.ProductRepository;
import com.onecontroller.ecommerce.request.AddProductRequest;
import com.onecontroller.ecommerce.request.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class  ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ImageRepository imageRepository;

    @Override
    public Product addProduct(AddProductRequest request) {
        Category category = Optional.ofNullable(categoryRepository.findByName(request.getCategory().getName()))
                .orElseGet(()-> {
                    Category newCategory = new Category();
                    return categoryRepository.save(newCategory);
                });
       request.setCategory(category);

        return productRepository.save(createProduct(request, category));
    }
    private Product createProduct(AddProductRequest request, Category category){
        return new Product(
                request.getName(),
                request.getBrand(),
                request.getPrice(),
                request.getInventory(),
                request.getDescription(),
                category
        );
    }

    @Override
    public Product getProduct(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(()-> new ProductNotFoundException("Product Not Found!"));
    }

    @Override
    public Product updateProduct(ProductUpdateRequest request) {
        return productRepository.findById(request.getId())
                .map(existingProduct -> updateExistingProduct(request, existingProduct))
                .map(productRepository::save)
                .orElseThrow(()-> new ProductNotFoundException(("Product Not Found!")));
    }
    private Product updateExistingProduct(ProductUpdateRequest request, Product existingProduct){
        existingProduct.setName(request.getName());
        existingProduct.setBrand(request.getBrand());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setInventory(request.getInventory());
        existingProduct.setDescription(request.getDescription());

        Category category = categoryRepository.findByName(request.getCategory().getName());
        existingProduct.setCategory(category);

        return existingProduct;
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
        ProductDto productDto = modelMapper.map(product, ProductDto.class);

        List<ImageDto> productImagesDto = imageRepository.findByProductId(product.getId())
                .stream()
                .map(image-> modelMapper.map(image, ImageDto.class))
                .toList();

        productDto.setImages(productImagesDto);

        return productDto;
    }
}
