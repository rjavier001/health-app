package com.kuger.healthservice.infraestructure.repository.mongodb;

import com.kuger.healthservice.domain.entity.Person;
import com.kuger.healthservice.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Primary
public class MongoDbOrderRepository implements PersonRepository {

  private final SpringDataMongoPersonRepository personRepository;

  @Autowired
  public MongoDbOrderRepository(final SpringDataMongoPersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public List<Person> findAll() {
    return personRepository.findAll();
  }

  @Override
  public Optional<Person> findById(final String id) {
    return personRepository.findById(id);
  }

  @Override
  public void save(final Person person) {
    personRepository.save(person);
  }

  @Override
  public void delete(String id) {
    personRepository.deleteById(id);
  }
}
