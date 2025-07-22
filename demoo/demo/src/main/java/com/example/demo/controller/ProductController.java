package com.example.demo.controller;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.ProductPagedQueryResponse;
import java.util.concurrent.CompletableFuture;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.commercetools.api.models.product.Product;
import com.example.demo.dto.ProductDto;


@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
@GetMapping("/products")
    public List<ProductDto> getProducts() {
        return productService.getAllProducts();
    }
}
