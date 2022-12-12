package com.kuger.healthservice.domain.entity;

import com.kuger.healthservice.domain.BloodInfoLvlRisk;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.UUID;


@Document(collection = "BloodInfo")
public class BloodInfo {

  @Id
  private String id;

  private LocalDate dateCreated;
  @Max(100)
  @Min(0)
  private float sugarBlood;
  @Max(100)
  @Min(0)
  private float fatBlood;
  @Max(100)
  @Min(0)
  private float oxyBlood;

  private String illnessRisk;



  public BloodInfo(String id, LocalDate dateCreated, float sugarBlood, float fatBlood, float oxyBlood, String illnessRisk) {
    this.id = UUID.randomUUID().toString();
    this.dateCreated = LocalDate.now();
    this.sugarBlood = sugarBlood;
    this.fatBlood = fatBlood;
    this.oxyBlood = oxyBlood;
    this.illnessRisk = calcHealthRisk();
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LocalDate getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(LocalDate dateCreated) {
    this.dateCreated = dateCreated;
  }

  public float getSugarBlood() {
    return sugarBlood;
  }

  public void setSugarBlood(float sugarBlood) {
    this.sugarBlood = sugarBlood;
  }

  public float getFatBlood() {
    return fatBlood;
  }

  public void setFatBlood(float fatBlood) {
    this.fatBlood = fatBlood;
  }

  public float getOxyBlood() {
    return oxyBlood;
  }

  public void setOxyBlood(float oxyBlood) {
    this.oxyBlood = oxyBlood;
  }

  public String getIllnessRisk() {
    return illnessRisk;
  }

  public void setIllnessRisk(String illnessRisk) {
    this.illnessRisk = illnessRisk;
  }

  public String calcHealthRisk() {
    String status=BloodInfoLvlRisk.NOAPPLY.toString();
    if (sugarBlood > 70 && fatBlood > 88.5 && oxyBlood < 60) {
      status = BloodInfoLvlRisk.HIGH.toString();
    }
    if ((sugarBlood > 50 && sugarBlood < 70) && (fatBlood > 62.2 && fatBlood < 88.8) && (oxyBlood > 60 && oxyBlood < 70)) {
      status = BloodInfoLvlRisk.MEDIUM.toString();
    }
    if ((sugarBlood < 50 && fatBlood < 62.2 && oxyBlood > 70)) {
      status = BloodInfoLvlRisk.LOW.toString();
    }
    return status;
  }
}
