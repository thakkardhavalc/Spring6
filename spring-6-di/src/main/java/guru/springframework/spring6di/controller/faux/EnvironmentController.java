package guru.springframework.spring6di.controller.faux;

import guru.springframework.spring6di.services.faux.EnvironmentService;
import org.springframework.stereotype.Controller;

@Controller
public class EnvironmentController {

    private final EnvironmentService environmentService;

    public EnvironmentController(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    public String getEnvironment() {

        return "Your environment is: " +environmentService.getEnv();
    }
}
