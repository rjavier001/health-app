package com.kuger.healthservice.infraestructure.configuration;

import com.kuger.healthservice.HealthServiceApplication;
import com.kuger.healthservice.domain.repository.PersonRepository;
import com.kuger.healthservice.domain.service.DomainPersonService;
import com.kuger.healthservice.domain.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = HealthServiceApplication.class)
public class BeanConfiguration {
  @Bean
  PersonService personService(final PersonRepository personRepository){
    return new DomainPersonService(personRepository);
  }
}
