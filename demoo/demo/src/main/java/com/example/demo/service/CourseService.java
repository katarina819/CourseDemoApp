import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.product.*;
import com.commercetools.api.models.product_type.ProductTypeResourceIdentifier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.model.Course;
import java.util.Locale;
import com.commercetools.api.models.product_type.ProductTypeResourceIdentifierBuilder;



@Service
@RequiredArgsConstructor
public class CourseService {

    private final ProjectApiRoot commercetoolsClient;

    public void createCourseProduct(Course course) {
        // Priprema LocalizedString za naziv i slug
        LocalizedString name = LocalizedString.of(Locale.ENGLISH, course.getTitle());
        LocalizedString slug = LocalizedString.of(Locale.ENGLISH, course.getTitle().toLowerCase().replace(" ", "-"));

        // ID Product Type-a iz Commercetools (mora postojati u projektu)
        String productTypeId = "your-product-type-id";

        // Napravi ProductDraft
        ProductDraft productDraft = ProductDraftBuilder.of()
            .name(name)
            .slug(slug)
            .productType(ProductTypeResourceIdentifierBuilder.of().id(productTypeId).build())
            .description(LocalizedString.of(Locale.ENGLISH, course.getDescription()))
            .build();

        // Pošalji zahtjev na Commercetools
        commercetoolsClient
            .products()
            .post(productDraft)
            .executeBlocking(); 
    }
}
