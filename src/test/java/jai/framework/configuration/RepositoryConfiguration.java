package jai.framework.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"jai.framework.domain"})
@EnableJpaRepositories(basePackages = {"jai.framework.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
