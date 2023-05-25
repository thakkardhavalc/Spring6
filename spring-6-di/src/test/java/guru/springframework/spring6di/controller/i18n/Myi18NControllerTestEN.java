package guru.springframework.spring6di.controller.i18n;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("EN")
@SpringBootTest
class Myi18NControllerTestEN {

    private static final Logger LOGGER = LoggerFactory.getLogger(Myi18NControllerTestEN.class);

    @Autowired
    Myi18NController myi18NController;

    @Test
    void sayHello() {

        LOGGER.info(myi18NController.sayHello());
    }
}