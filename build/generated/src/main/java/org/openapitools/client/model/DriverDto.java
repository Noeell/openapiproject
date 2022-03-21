/*
 * Formel 1 API
 * A small sample API to grasp the basics of the OpenAPI Specification
 *
 * The version of the OpenAPI document: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * DriverDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-21T08:24:38.298162500+01:00[Europe/Berlin]")
public class DriverDto {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_PRENAME = "prename";
  @SerializedName(SERIALIZED_NAME_PRENAME)
  private String prename;

  public static final String SERIALIZED_NAME_AGE = "age";
  @SerializedName(SERIALIZED_NAME_AGE)
  private Integer age;

  public static final String SERIALIZED_NAME_RACING_TEAM = "racingTeam";
  @SerializedName(SERIALIZED_NAME_RACING_TEAM)
  private Object racingTeam;

  public static final String SERIALIZED_NAME_POINTS = "points";
  @SerializedName(SERIALIZED_NAME_POINTS)
  private Integer points;

  public static final String SERIALIZED_NAME_COUNTRY = "country";
  @SerializedName(SERIALIZED_NAME_COUNTRY)
  private String country;


  public DriverDto name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Müller", required = true, value = "")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public DriverDto prename(String prename) {
    
    this.prename = prename;
    return this;
  }

   /**
   * Get prename
   * @return prename
  **/
  @ApiModelProperty(example = "Hans", required = true, value = "")

  public String getPrename() {
    return prename;
  }


  public void setPrename(String prename) {
    this.prename = prename;
  }


  public DriverDto age(Integer age) {
    
    this.age = age;
    return this;
  }

   /**
   * Get age
   * minimum: 18
   * maximum: 100
   * @return age
  **/
  @ApiModelProperty(example = "20", required = true, value = "")

  public Integer getAge() {
    return age;
  }


  public void setAge(Integer age) {
    this.age = age;
  }


  public DriverDto racingTeam(Object racingTeam) {
    
    this.racingTeam = racingTeam;
    return this;
  }

   /**
   * Get racingTeam
   * @return racingTeam
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getRacingTeam() {
    return racingTeam;
  }


  public void setRacingTeam(Object racingTeam) {
    this.racingTeam = racingTeam;
  }


  public DriverDto points(Integer points) {
    
    this.points = points;
    return this;
  }

   /**
   * Get points
   * minimum: 0
   * maximum: 600
   * @return points
  **/
  @ApiModelProperty(example = "15", required = true, value = "")

  public Integer getPoints() {
    return points;
  }


  public void setPoints(Integer points) {
    this.points = points;
  }


  public DriverDto country(String country) {
    
    this.country = country;
    return this;
  }

   /**
   * Get country
   * @return country
  **/
  @ApiModelProperty(example = "Switzerland", required = true, value = "")

  public String getCountry() {
    return country;
  }


  public void setCountry(String country) {
    this.country = country;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DriverDto driverDto = (DriverDto) o;
    return Objects.equals(this.name, driverDto.name) &&
        Objects.equals(this.prename, driverDto.prename) &&
        Objects.equals(this.age, driverDto.age) &&
        Objects.equals(this.racingTeam, driverDto.racingTeam) &&
        Objects.equals(this.points, driverDto.points) &&
        Objects.equals(this.country, driverDto.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, prename, age, racingTeam, points, country);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DriverDto {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    prename: ").append(toIndentedString(prename)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    racingTeam: ").append(toIndentedString(racingTeam)).append("\n");
    sb.append("    points: ").append(toIndentedString(points)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

