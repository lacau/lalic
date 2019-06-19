package com.lalic.mananger.external;

import com.lalic.mananger.LalicConstants;
import com.lalic.mananger.external.response.ProductResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class XTechClient {

    private static HttpHeaders standardHeaders;

    @Value("${xtech.api.url}")
    private String apiUrl;

    @Value("${xtech.app.key}")
    private String appKey;

    @Value("${xtech.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    public List<ProductResponse> getProducts() {
        final String xTechUrl = apiUrl.concat("/products");
        final HttpEntity entity = new HttpEntity(getStandardHeaders());
        final ResponseEntity<List<ProductResponse>> products = restTemplate
            .exchange(xTechUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<List<ProductResponse>>() {
            });

        return products.getBody();
    }

    private HttpHeaders getStandardHeaders() {
        if (standardHeaders == null) {
            standardHeaders = createStandardHeaders();
        }
        return standardHeaders;
    }

    private HttpHeaders createStandardHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(LalicConstants.X_APP_KEY, appKey);
        headers.set(LalicConstants.X_API_KEY, apiKey);

        return headers;
    }
}
