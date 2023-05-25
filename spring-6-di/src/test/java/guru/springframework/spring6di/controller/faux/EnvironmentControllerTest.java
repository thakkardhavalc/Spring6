package guru.springframework.spring6di.controller.faux;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles({"prod", "EN"})
@SpringBootTest
class EnvironmentControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnvironmentControllerTest.class);

    @Autowired
    EnvironmentController environmentController;

    @Test
    void getEnvironment() {

        LOGGER.info(environmentController.getEnvironment());
    }
}