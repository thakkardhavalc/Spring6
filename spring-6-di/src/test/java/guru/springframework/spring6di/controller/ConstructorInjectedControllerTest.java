package guru.springframework.spring6di.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConstructorInjectedControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConstructorInjectedControllerTest.class);

    @Autowired
    ConstructorInjectedController constructorInjectedController;

    @Test
    void sayHello() {

        LOGGER.info(constructorInjectedController.sayHello());
    }
}