package com.example.demo.service; 
import com.commercetools.api.models.type.FieldContainer;
import com.commercetools.api.models.product.Attribute;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductPagedQueryResponse;
import com.example.demo.dto.ProductDto;
import org.springframework.stereotype.Service;
import com.commercetools.api.models.type.CustomFields;
import com.commercetools.api.models.product.ProductVariant;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProjectApiRoot apiRoot;

    public ProductService(ProjectApiRoot apiRoot) {
        this.apiRoot = apiRoot;
    }

    // Dohvati raw proizvode iz Commercetools
    public List<Product> getAllProductsRaw() {
    ProductPagedQueryResponse response = apiRoot
        .products()
        .get()
        .addQueryParam("where", "masterData(published=true)")
        .addQueryParam("limit", "100") // povećaš broj rezultata
        .executeBlocking()
        .getBody();

    return response.getResults();
}

    // Vraća samo publishane proizvode kao DTO
    public List<ProductDto> getAllProducts() {
        return getAllProductsRaw().stream()
                .map(this::mapToDto)
                .filter(Objects::nonNull) // filtriraj null (nepublikovane)
                .collect(Collectors.toList());
    }

    // Mapiraj product u DTO, ali samo ako je publishan
    private ProductDto mapToDto(Product product) {
    String id = product.getId();
    var current = product.getMasterData().getCurrent();
    var masterVariant = current.getMasterVariant();
    String name = current.getName() != null ? current.getName().get("en-GB") : null;
    String description = current.getDescription() != null ? current.getDescription().get("en-GB") : null;

    Integer priceCentAmount = null;
    String priceCurrencyCode = null;

    if (masterVariant != null
        && masterVariant.getPrices() != null
        && !masterVariant.getPrices().isEmpty()) {
        var price = masterVariant.getPrices().get(0).getValue();
        Long centAmountLong = price.getCentAmount();
        priceCentAmount = (centAmountLong != null) ? centAmountLong.intValue() : null;
        priceCurrencyCode = price.getCurrencyCode();
    }

    String startDate = null;
    String duration = null;

    List<Attribute> attributes = masterVariant.getAttributes();

    if (attributes != null) {
        for (Attribute attribute : attributes) {
            if ("startDate".equals(attribute.getName())) {
                startDate = (String) attribute.getValue();
            } else if ("duration".equals(attribute.getName())) {
                duration = (String) attribute.getValue();
            }
        }
    }

    return new ProductDto(id, name, description, priceCentAmount, priceCurrencyCode, startDate, duration);
}

}
