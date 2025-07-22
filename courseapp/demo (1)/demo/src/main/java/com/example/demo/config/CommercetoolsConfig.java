package com.example.demo.config;
import com.commercetools.api.client.ApiRoot;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.defaultconfig.ApiRootBuilder;
import com.commercetools.api.defaultconfig.ServiceRegion;
import io.vrap.rmf.base.client.oauth2.ClientCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommercetoolsConfig {

    @Bean
    public ProjectApiRoot commercetoolsClient() {
        String projectKey = "courseapp"; // <-- tvoje ime projekta u Commercetoolsu
        String clientId = "XQHrU9Y4ksjIj6ajOl4hQ1xK";
        String clientSecret = "zHYvB_22oSGiKgilTHsBtE4_Pp9n2NEV";

        ClientCredentials credentials = ClientCredentials.of()
                .withClientId(clientId)
                .withClientSecret(clientSecret)
                .build();

                

        return ApiRootBuilder.of()
                .defaultClient(credentials, ServiceRegion.GCP_EUROPE_WEST1)
                .build(projectKey);
    }
}
