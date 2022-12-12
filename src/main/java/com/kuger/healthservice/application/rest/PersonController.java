package com.kuger.healthservice.application.rest;


import com.kuger.healthservice.domain.entity.BloodInfo;
import com.kuger.healthservice.domain.entity.Person;
import com.kuger.healthservice.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api")
public class PersonController {
  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping("/person")
  public ResponseEntity<Person> createPerson(@RequestBody Person person) {
    try {
      Person _person = personService.save(person);
      return new ResponseEntity<>(_person, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @PutMapping("/person-newBloodTest/{id}")
  public ResponseEntity<Person> createBloodTest(@PathVariable("id") String id, @RequestBody BloodInfo bloodInfo) {
    try {
      ArrayList<BloodInfo> bloodInfoArrayList= new ArrayList<BloodInfo>();
      Optional<Person> personData = personService.findById(id);

      if (personData.isPresent()) {
        Person _person = personData.get();
        if(_person.getBloodInfo()!= null){
          _person.getBloodInfo().forEach(item-> {
            System.out.println(item);
            bloodInfoArrayList.add(item);
          });
        }
        bloodInfoArrayList.add(new BloodInfo( UUID.randomUUID().toString(), LocalDate.now(),bloodInfo.getSugarBlood(),bloodInfo.getFatBlood(), bloodInfo.getOxyBlood(), bloodInfo.calcHealthRisk()));
        _person.setBloodInfo(bloodInfoArrayList);
        return new ResponseEntity<>(personService.save(_person), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/person")
  public ResponseEntity<List<Person>> getAllPerson() {
    try {
      List<Person> data = new ArrayList<Person>();

      personService.findAll().forEach(data::add);
      if (data.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }else{
        return new ResponseEntity<>(data, HttpStatus.OK);
      }

    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/person/{id}")
  public ResponseEntity<Person> getPersonById(@PathVariable("id") String id) {
    Optional<Person> personData = personService.findById(id);

    if (personData.isPresent()) {
      return new ResponseEntity<>(personData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/person/{id}")
  public ResponseEntity<Person> updatePerson(@PathVariable("id") String id, @RequestBody Person person) {
    Optional<Person> personData = personService.findById(id);

    if (personData.isPresent()) {
      Person _person = personData.get();
      _person.setDni(person.getDni() != null? person.getDni():_person.getDni());
      _person.setFirstName(person.getFirstName() != null? person.getFirstName():_person.getFirstName());
      _person.setLastName(person.getLastName() != null? person.getLastName():_person.getLastName());
      _person.setEmail(person.getEmail() != null? person.getEmail():_person.getEmail());
      _person.setPhoneNum(person.getPhoneNum() != null? person.getPhoneNum():_person.getPhoneNum());
      _person.setAddress(person.getAddress() != null? person.getAddress():_person.getAddress());
      _person.setDateBorn(person.getDateBorn() != null? person.getDateBorn():_person.getDateBorn());
      _person.setBloodInfo(person.getBloodInfo() != null? person.getBloodInfo():_person.getBloodInfo());
      return new ResponseEntity<>(personService.save(_person), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/person/{id}")
  public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") String id) {
    try {
      personService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
