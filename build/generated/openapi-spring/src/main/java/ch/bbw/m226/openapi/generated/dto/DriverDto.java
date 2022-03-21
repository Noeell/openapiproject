package ch.bbw.m226.openapi.generated.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * DriverDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class DriverDto   {

  @JsonProperty("name")
  private String name;

  @JsonProperty("prename")
  private String prename;

  @JsonProperty("age")
  private Integer age;

  @JsonProperty("racingTeam")
  private Object racingTeam;

  @JsonProperty("points")
  private Integer points;

  @JsonProperty("country")
  private String country;

  public DriverDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull @Size(min = 1, max = 255) 
  @Schema(name = "name", example = "Müller", required = true)
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
  */
  @NotNull @Size(min = 1, max = 255) 
  @Schema(name = "prename", example = "Hans", required = true)
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
  */
  @NotNull @Min(18) @Max(100) 
  @Schema(name = "age", example = "20", required = true)
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
  */
  
  @Schema(name = "racingTeam", required = false)
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
  */
  @NotNull @Min(0) @Max(600) 
  @Schema(name = "points", example = "15", required = true)
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
  */
  @NotNull @Size(min = 1, max = 255) 
  @Schema(name = "country", example = "Switzerland", required = true)
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

