package com.spring4.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WarResolver implements Condition{
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        boolean isWar = System.getProperties().keySet().contains("war");
        boolean value = (boolean) annotatedTypeMetadata.getAnnotationAttributes(War.class.getName()).get("value");
        return isWar && value || !isWar && !value;
    }
}
