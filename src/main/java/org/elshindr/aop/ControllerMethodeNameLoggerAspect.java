package org.elshindr.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerMethodeNameLoggerAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

/*
    @After("execution(* org.elshindr.controlers..*(..)))")
    public void logService(JoinPoint jp){
        log.info("=== J'execute la méthode {}", jp.getSignature().getName());
        log.info(" on entre dans le joinpoint : ", jp);
        log.info(" arguments {}: ", jp.getArgs());
        log.info(" bean : {}", jp.getTarget());
    }

    @Before("execution(* org.elshindr..*.get*(..)) && !within(org.elshindr.*.*.models.*)")
    public void logServiceGets(JoinPoint jp) {
        log.info("=== Avant fonction commençant par 'Get' {} ", jp.getSignature().getName());
    }

    @Before("execution(public * org.elshindr.controlers..*(..))")
    public void logServiceNomMethodePublic(JoinPoint jp) {

        log.info("=== Nom de methode public {} ", jp.getSignature().getName());
    }

    @AfterThrowing("execution(* org.elshindr.repositories..save(..)))")
    public void logServiceExceptionCreate(JoinPoint jp){
        log.info("=== ERREUR dans {} ", jp.getSignature().getName());
        log.info("== Arguments : {}", jp.getArgs());
        log.info("== Bean : {} ", jp.getTarget());
    }


    @Around("execution(* org.elshindr.services..*(..)))")
    public void logServiceChrono(ProceedingJoinPoint point) throws Throwable {
        log.info("=== TEST CHRONO EXECUTION");
        long startTime = System.currentTimeMillis();

        Object resultn= point.proceed();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        log.info("=== La méthode {} a été exécutée en {} ms", point.getSignature().getName(), duration);
    }
*/
}


