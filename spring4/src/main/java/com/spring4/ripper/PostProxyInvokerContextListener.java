package com.spring4.ripper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

@Component
public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Autowired
    private Map<String, Class> postProxyDefinitionMap;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            try {
                if (postProxyDefinitionMap.containsKey(name)) {
                    Class<?> originalClass = postProxyDefinitionMap.get(name);;
                    Method[] declaredMethods = originalClass.getDeclaredMethods();
                    for (Method declaredMethod : declaredMethods) {
                        if (declaredMethod.isAnnotationPresent(PostProxy.class)) {
                            Object bean = applicationContext.getBean(name);
                            Method method = bean.getClass().getMethod(declaredMethod.getName(), declaredMethod.getParameterTypes());
                            method.invoke(bean);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
