package guru.springframework.spring6di.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware, BeanPostProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LifeCycleDemoBean.class);

    private String javaVar;

    public LifeCycleDemoBean() {

        LOGGER.info("## I am in the LifeCycleBean Constructor ##");
    }

    @Value("${java.specification.version}")
    public void setJavaVar(String javaVar) {

        this.javaVar = javaVar;
        LOGGER.info("## 1 Properties Set. Java version: " + this.javaVar);
    }

    @Override
    public void setBeanName(String name) {

        LOGGER.info("## 2 BeanNameAware My Bean Name is: " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

        LOGGER.info("## 3 BeanFactoryAware - Bean Factory has been set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        LOGGER.info("## 4 ApplicationContextAware - Application context has been set");
    }

    @PostConstruct
    public void postConstruct() {

        LOGGER.info("## 5 postConstruct The Post Construct annotated method has been called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        LOGGER.info("## 6 afterPropertiesSet Populate The LifeCycleBean has its properties");
    }

    @PreDestroy
    public void preDestroy() {

        LOGGER.info("## 7 The @PreDestroy annotated method has been called");
    }

    @Override
    public void destroy() throws Exception {

        LOGGER.info("## 8 DisposableBean.destroy The Lifecycle bean has been terminated");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof LifeCycleDemoBean demoBean) {
            LOGGER.info("Calling before Init");
            LOGGER.info(demoBean.beforeInit());
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof LifeCycleDemoBean demoBean) {
            LOGGER.info("Calling After Init");
            LOGGER.info(demoBean.afterInit());
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    public String beforeInit() {
        LOGGER.info("##  Before Init - Called by Bean Post Processor: ");
        return null;
    }

    public String afterInit() {
        LOGGER.info("##  After Init - Called by Bean Post Processor: ");
        return null;
    }
}
