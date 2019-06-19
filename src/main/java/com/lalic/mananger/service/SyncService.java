package com.lalic.mananger.service;

import com.lalic.mananger.external.XTechClient;
import com.lalic.mananger.external.response.ProductResponse;
import com.lalic.mananger.repository.ProductRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SyncService {

    @Autowired
    private XTechClient xTechClient;

    @Autowired
    private ProductRepository productRepository;

    @Async
    public void syncProducts() {
        log.info("Start syncing products...");
        final List<ProductResponse> products = xTechClient.getProducts();
        if (!products.isEmpty()) {
            log.info("Products count: {}", products.size());

        } else {
            log.info("No products for sync.");
        }

        log.info("End syncing products!");
    }
}
