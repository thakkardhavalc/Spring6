package guru.springframework.spring6di.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SetterInjectedControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SetterInjectedControllerTest.class);

    @Autowired
    SetterInjectedController setterInjectedController;

    @Test
    void sayHello() {

        LOGGER.info(setterInjectedController.sayHello());
    }
}