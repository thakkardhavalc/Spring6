package guru.springframework.spring6di.controller;

import guru.springframework.spring6di.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorInjectedControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConstructorInjectedControllerTest.class);

    ConstructorInjectedController constructorInjectedController;

    @BeforeEach
    void setUp() {
        constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());
    }

    @Test
    void sayHello() {

        LOGGER.info(constructorInjectedController.sayHello());
    }
}