package guru.springframework.spring6di;

import guru.springframework.spring6di.controller.MyController;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class Spring6DiApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(Spring6DiApplicationTests.class);

	@Autowired
	ApplicationContext context;

	@Autowired
	MyController myController;

	@Test
	void testAutoWireOfController() {

		LOGGER.info(myController.sayHello());
	}

	@Test
	void testGetControllerFromCtx() {
		MyController myController = context.getBean(MyController.class);

		LOGGER.info(myController.sayHello());
	}

	@Test
	void contextLoads() {
	}

}
