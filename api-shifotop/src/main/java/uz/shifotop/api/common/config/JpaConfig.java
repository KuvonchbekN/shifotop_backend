package uz.shifotop.api.common.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"uz.shifotop.api"})
@EnableJpaRepositories(basePackages ={"uz.shifotop.api"})
public class JpaConfig {
}
