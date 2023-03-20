package kira.formation.spring.equipes.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggerAspect {

//    private static final Logger log = LoggerFactory.getLogger(LoggerAspect.class);

    @AfterThrowing("execution(* kira.formation.spring.equipes.controllers.*.*(..))")
    public void before(JoinPoint jp){

    }
}
