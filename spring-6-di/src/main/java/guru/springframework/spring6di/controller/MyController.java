package guru.springframework.spring6di.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    public String sayHello() {

        LOGGER.info("I am into the controller");

        return "Hello Everyone";
    }
}
