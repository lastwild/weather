package com.weather.data.model;

import android.provider.BaseColumns;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.weather.data.model.weather.Coord;

public class City {
  @JsonProperty("_id")
  int id;
  String name;
  String country;
  Coord coord;


  public interface Table {
    String NAME = "city";
    String ID = BaseColumns._ID;
    String CITY_NAME = "name";

    String CREATE = "CREATE TABLE " + NAME + " (" + ID + " TEXT PRIMARY KEY, " + CITY_NAME + " TEXT);";
  }
}
