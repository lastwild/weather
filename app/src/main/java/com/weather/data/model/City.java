package com.weather.data.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weather.data.http.ApiServices;
import com.weather.data.model.annotations.Field;
import com.weather.data.model.annotations.Table;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true) @Table(table = "city") public class City extends AbstractEntity<City> {
  private static final Gson gson = ApiServices.gson
  @Field(nameFild = "name", typeFild = "TEXT")
  String name;
  @Field(nameFild = "country", typeFild = "TEXT")
  String country;
  @Field(nameFild = "coord", typeFild = "TEXT")
  Coord coord;
  @Field(nameFild = "population", typeFild = "TEXT")
  public Integer population;
  @Field(nameFild = "sys", typeFild = "TEXT")
  public Sys sys;
  ;

  public interface Table {
    String CITY_NAME = "name";
    String COUNTRY = "country";
    String COORD = "country";
    String POPULATION = "country";
    String SYS = "country";
  }

  public City id() {
    return this;
  }

  public City name() {
    return this;
  }

  public City country() {
    return this;
  }

  public City coord() {
    return this;
  }

  public City population() {
    return this;
  }

  public City sys() {
    return this;
  }

  @Override
  public <T extends AbstractEntity> T fromCursor(final Cursor cursor) {
    return null;
  }

  @Override
  public ContentValues toContentValues(ContentValues cv, final City city) {
    if (city != null) {
      if (cv == null) {
        cv = new ContentValues();
      } else {
        cv.clear();
      }
      cv.put(Table.CITY_NAME, gson.toJson(city.name));
      cv.put(Table.COORD, gson.toJson(city.coord));
      cv.put(Table.COUNTRY, gson.toJson(city.country));
      cv.put(Table.POPULATION, gson.toJson(city.population));
      cv.put(Table.SYS, gson.toJson(city.sys));
    }
    return cv;
  }
}
