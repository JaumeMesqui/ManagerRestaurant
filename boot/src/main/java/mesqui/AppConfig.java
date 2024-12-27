package mesqui;

import mesqui.repositories.ManagerRepository;
import mesqui.services.ManagerService;
import mesqui.services.ManagerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ManagerService managerService(ManagerRepository managerRepository) {
        return new ManagerServiceImpl(managerRepository);
    }
}