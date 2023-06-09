package org.elshindr.Species_REST.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Logger Aspect
 * Affichages de logs suite à l'execution de méthodes ciblées
 */
@Aspect
@Component
public class LoggerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @After("execution(* org.elshindr.Species_REST.controllers..*(..)))")
    public void logService(JoinPoint jp) {
        log.info("=== J'execute la méthode {}", jp.getSignature().getName());
        log.info(" on entre dans le joinpoint : ", jp);
        log.info(" arguments {}: ", jp.getArgs());
        log.info(" bean : {}", jp.getTarget());
    }

    @Before("execution(* org.elshindr.Species_REST..get*(..))")
    public void logServiceGets(JoinPoint jp) {
        log.info("=== GET :: {} ", jp.getSignature().getName());
    }


    @Before("execution(public * org.elshindr.Species_REST.controllers..*(..))")
    public void logServicePublicControllers(JoinPoint jp) {
        log.info("=== CONTROLLERS PUBLIC :: {} ", jp.getSignature().getName());
    }


    @AfterThrowing("execution(* org.elshindr.Species_REST.repositories..save(..)))")
    public void logServiceExceptionCreate(JoinPoint jp) {
        log.info("=== ERREUR SAVE :: {} ", jp.getSignature().getName());
        log.info("== Arguments : {}", jp.getArgs());
        log.info("== Bean : {} ", jp.getTarget());
    }


/*
    @Around("within(org.elshindr.Species_REST.services..*)")
    public void logServiceChrono(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = point.proceed();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        log.info("=== La méthode {} a été exécutée en {} ms", point.getSignature().getName(), duration);
    }*/
}


