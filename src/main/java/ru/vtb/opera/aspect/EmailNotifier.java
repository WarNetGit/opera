package ru.vtb.opera.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vtb.opera.service.OperaEmailService;

@Aspect
@Component
public class EmailNotifier {
    @Autowired
    OperaEmailService operaEmailService;

    @Pointcut("@annotation(EmailAnnotation)")
    public void callAtOperaServicePublic() {}

    @After("callAtOperaServicePublic()")
    public void afterCallAtMethod(JoinPoint jp) {
        operaEmailService.sendSimpleEmail("teg2006@yandex.ru", "opera", jp.getSignature().getName());
    }
}
