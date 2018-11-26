package model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class F implements ApplicationContextAware,
        ApplicationEventPublisherAware,
        BeanClassLoaderAware,
        BeanFactoryAware,
        BeanNameAware,
        MessageSourceAware,
        ResourceLoaderAware,
        InitializingBean {

    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Set bean classloader: " + classLoader);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Set beanfactory: " + beanFactory);
    }

    public void setBeanName(String s) {
        System.out.println("Set bean bame: " + s);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Set applicationContext: " + applicationContext);
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("Set applicationEventPublisher: " + applicationEventPublisher);
    }

    public void setMessageSource(MessageSource messageSource) {
        System.out.println("Set messageSource: " + messageSource);
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("Set resourceLoader: " + resourceLoader);
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet method");
    }

    @PostConstruct
    public void init() {
        System.out.println("init method invoked...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy method invoked...");
    }
}
