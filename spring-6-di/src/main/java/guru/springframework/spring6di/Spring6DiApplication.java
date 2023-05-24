package guru.springframework.spring6di;

import guru.springframework.spring6di.controller.MyController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring6DiApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(Spring6DiApplication.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Spring6DiApplication.class, args);

		MyController controller = ctx.getBean(MyController.class);

		LOGGER.info("I am into Main Method");

		LOGGER.info(controller.sayHello());
	}
}
