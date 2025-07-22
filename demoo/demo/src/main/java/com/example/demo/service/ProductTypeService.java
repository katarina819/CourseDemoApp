package com.example.demo.service;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product_type.*;
import com.commercetools.api.models.common.LocalizedString;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ProductTypeService {

    private final ProjectApiRoot commercetoolsClient;

    public ProductTypeService(ProjectApiRoot commercetoolsClient) {
        this.commercetoolsClient = commercetoolsClient;
    }

    public ProductType createProductType(String name, String description) {
        // Postavi lokalizirani naziv i opis Product Type-a
        LocalizedString localizedName = LocalizedString.of(Locale.ENGLISH, name);
        LocalizedString localizedDescription = LocalizedString.of(Locale.ENGLISH, description);

        // Kreiraj draft za Product Type
        ProductTypeDraft productTypeDraft = ProductTypeDraftBuilder.of()
            .name(name)
            .description(description)
            .build();

        // Pošalji zahtjev za kreiranje
        return commercetoolsClient
                .productTypes()
                .post(productTypeDraft)
                .executeBlocking()
                .getBody();
    }
}
