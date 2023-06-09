package org.elshindr.Species_REST.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * CronService
 * Taches planifiées
 */
@Service
public class CronService {

    @Value("${utilisateur.name}")
    private String value;

    @Scheduled(cron= "${cron.value}")
    //@Scheduled(cron = "2 * * * * *")
    public void cron(){
        System.out.println( "\n ============== CRON SERVICE :: " + value + LocalDateTime.now()+ " ==============\n");
    }
}
