package com.kuger.healthservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "Person")
public class Person {
  @Id
  private String id;

  @Indexed(unique = true)
  @NotNull(message = "dni cannot be empty")
  private String dni;
  @NotNull(message = "firstName cannot be empty")
  private String firstName;
  @NotNull(message = "lastName cannot be empty")
  private String lastName;
  @Email
  @Indexed(unique = true)
  private String email;
  private String phoneNum;
  private String address;

  private LocalDate dateBorn;

  private List<BloodInfo> bloodInfo;

}
