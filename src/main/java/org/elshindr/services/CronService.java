package org.elshindr.services;

import org.springframework.scheduling.annotation.Scheduled;

public class CronService {
    @Scheduled(cron= "0 * * * * *")
    public void cron(){
        System.out.println("\n\n ==============CRON==============\n\n");
    }
}
