package com.example.demo;
import com.example.demo.service.ProductTypeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.commercetools.api.models.product_type.ProductType;

@Component
public class StartupRunner {

    private final ProductTypeService productTypeService;

    public StartupRunner(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostConstruct
    public void run() {
        ProductType newProductType = productTypeService.createProductType("Course", "Product Type for courses");
        System.out.println("Created Product Type ID: " + newProductType.getId());
    }
}
