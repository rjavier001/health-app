package com.kuger.healthservice.infraestructure.configuration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.kuger.healthservice.infraestructure.repository.mongodb.SpringDataMongoPersonRepository;


@EnableMongoRepositories(basePackageClasses = SpringDataMongoPersonRepository.class)
public class MongoDBConfiguration {
}
