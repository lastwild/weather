package com.weather.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {
  @JsonIgnore public Integer speed;
  @JsonIgnore public Integer deg;
}
