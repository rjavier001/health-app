package com.kuger.healthservice.infraestructure.repository.mongodb;

import com.kuger.healthservice.domain.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoPersonRepository extends MongoRepository<Person, String> {

}
