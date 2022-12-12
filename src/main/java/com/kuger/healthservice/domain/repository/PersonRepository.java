package com.kuger.healthservice.domain.repository;

import com.kuger.healthservice.domain.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
  List<Person> findAll();
  Optional<Person> findById(String id);
  void save(Person person);
  void delete(String id);
}

