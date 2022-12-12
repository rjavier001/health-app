package com.kuger.healthservice.domain.service;

import com.kuger.healthservice.domain.entity.Person;

import java.util.List;
import java.util.Optional;
public interface PersonService {
  List<Person> findAll();
  Optional<Person> findById(String id);
  Person save(Person person);

  default void deleteById(String id) {

  }
}
