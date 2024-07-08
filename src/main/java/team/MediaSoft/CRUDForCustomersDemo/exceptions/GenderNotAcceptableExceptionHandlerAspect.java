package team.MediaSoft.CRUDForCustomersDemo.exceptions;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GenderNotAcceptableExceptionHandlerAspect extends RuntimeException{
    @Around("execution(* team.MediaSoft.CRUDForCustomersDemo.controller.*.*(..))")
    public Object handleException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Requested Gender is not acceptable.");
        }
    }
}
