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
 * RacingTeamDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class RacingTeamDto   {

  @JsonProperty("name")
  private String name;

  @JsonProperty("teamBoss")
  private String teamBoss;

  @JsonProperty("engineProducer")
  private String engineProducer;

  @JsonProperty("country")
  private String country;

  @JsonProperty("points")
  private Integer points;

  public RacingTeamDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull @Size(min = 1, max = 255) 
  @Schema(name = "name", required = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RacingTeamDto teamBoss(String teamBoss) {
    this.teamBoss = teamBoss;
    return this;
  }

  /**
   * Get teamBoss
   * @return teamBoss
  */
  @NotNull @Size(min = 1, max = 255) 
  @Schema(name = "teamBoss", required = true)
  public String getTeamBoss() {
    return teamBoss;
  }

  public void setTeamBoss(String teamBoss) {
    this.teamBoss = teamBoss;
  }

  public RacingTeamDto engineProducer(String engineProducer) {
    this.engineProducer = engineProducer;
    return this;
  }

  /**
   * Get engineProducer
   * @return engineProducer
  */
  @NotNull @Size(min = 1, max = 255) 
  @Schema(name = "engineProducer", required = true)
  public String getEngineProducer() {
    return engineProducer;
  }

  public void setEngineProducer(String engineProducer) {
    this.engineProducer = engineProducer;
  }

  public RacingTeamDto country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
  */
  @NotNull @Size(min = 1, max = 255) 
  @Schema(name = "country", required = true)
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public RacingTeamDto points(Integer points) {
    this.points = points;
    return this;
  }

  /**
   * Get points
   * minimum: 0
   * maximum: 1200
   * @return points
  */
  @NotNull @Min(0) @Max(1200) 
  @Schema(name = "points", required = true)
  public Integer getPoints() {
    return points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RacingTeamDto racingTeamDto = (RacingTeamDto) o;
    return Objects.equals(this.name, racingTeamDto.name) &&
        Objects.equals(this.teamBoss, racingTeamDto.teamBoss) &&
        Objects.equals(this.engineProducer, racingTeamDto.engineProducer) &&
        Objects.equals(this.country, racingTeamDto.country) &&
        Objects.equals(this.points, racingTeamDto.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, teamBoss, engineProducer, country, points);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RacingTeamDto {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    teamBoss: ").append(toIndentedString(teamBoss)).append("\n");
    sb.append("    engineProducer: ").append(toIndentedString(engineProducer)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    points: ").append(toIndentedString(points)).append("\n");
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

