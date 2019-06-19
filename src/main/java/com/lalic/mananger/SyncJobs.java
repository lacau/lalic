package com.lalic.mananger;

import com.lalic.mananger.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SyncJobs {

    @Autowired
    private SyncService syncService;

    @Scheduled(cron = "${lalic.config.cron.products.sync}")
    public void syncProducts() {
        syncService.syncProducts();
    }
}
