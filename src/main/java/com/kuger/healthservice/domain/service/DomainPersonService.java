package com.kuger.healthservice.domain.service;

import com.kuger.healthservice.domain.entity.Person;
import com.kuger.healthservice.domain.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

public class DomainPersonService implements PersonService{

  private final PersonRepository personRepository;

  public DomainPersonService(final PersonRepository personRepository) {

    this.personRepository = personRepository;
  }

  @Override
  public List<Person> findAll() {
    return personRepository.findAll();
  }

  @Override
  public Optional<Person> findById(String id) {
    return personRepository.findById(id);
  }

  @Override
  public Person save(Person person) {
    personRepository.save(person);
    return person;
  }

  @Override
  public void deleteById(String id) {
    personRepository.delete(id);
  }

}
