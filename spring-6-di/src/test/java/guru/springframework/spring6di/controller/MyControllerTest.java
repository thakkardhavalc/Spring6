package guru.springframework.spring6di.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class MyControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyControllerTest.class);

    @Test
    void sayHello() {

        MyController myController = new MyController();

        LOGGER.info(myController.sayHello());
    }
}