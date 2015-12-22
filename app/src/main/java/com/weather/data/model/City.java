package com.weather.data.model;

import android.provider.BaseColumns;
import com.fasterxml.jackson.annotation.JsonProperty;

public class City {
  @JsonProperty("_id")
  int id;
  String name;
  String country;
  Coord coord;


  public Integer population;
  public Sys sys;


  public interface Table {
    String NAME = "city";
    String ID = BaseColumns._ID;
    String CITY_NAME = "name";

    String CREATE = "CREATE TABLE " + NAME + " (" + ID + " TEXT PRIMARY KEY, " + CITY_NAME + " TEXT);";
  }
}
