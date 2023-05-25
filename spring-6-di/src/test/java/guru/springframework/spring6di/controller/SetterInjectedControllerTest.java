package guru.springframework.spring6di.controller;

import guru.springframework.spring6di.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class SetterInjectedControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SetterInjectedControllerTest.class);

    SetterInjectedController setterInjectedController;

    @BeforeEach
    void setUp() {

        setterInjectedController = new SetterInjectedController();
        setterInjectedController.SetterInjectedController(new GreetingServiceImpl());
    }

    @Test
    void sayHello() {

        LOGGER.info(setterInjectedController.sayHello());
    }
}