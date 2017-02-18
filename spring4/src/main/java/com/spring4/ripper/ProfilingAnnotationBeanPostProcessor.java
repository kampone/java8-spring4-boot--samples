package com.spring4.ripper;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;



@Component
public class ProfilingAnnotationBeanPostProcessor implements BeanPostProcessor{
    private Map<String, Class> map = new HashMap<>();
    private ProfilingConfig profilingConfig = new ProfilingConfig();

    public ProfilingAnnotationBeanPostProcessor() throws Exception {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(profilingConfig, new ObjectName("profilling", "name", "profilingConfig"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Class<?> aClass = o.getClass();
        if (aClass.isAnnotationPresent(Profiling.class)){
            map.put(s, aClass);
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        Class aClass = map.get(s);
        if(aClass != null) {
            return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (profilingConfig.isEnabled()) {
                        System.out.println("PROFILING START");
                        long before = System.nanoTime();
                        Object retVal = method.invoke(o, args);
                        long after = System.nanoTime();
                        System.out.println("PROFILING FINISH");
                        System.out.println(after - before);
                        return retVal;
                    } else {
                        return method.invoke(o, args);
                    }
                }
            });
        }
        return o;
    }

}
