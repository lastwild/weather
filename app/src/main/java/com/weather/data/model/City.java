package com.weather.data.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weather.data.model.annotations.Field;
import com.weather.data.model.annotations.Table;

@JsonIgnoreProperties(ignoreUnknown = true) @Table(table = "city") public class City extends AbstractEntity<City> {
  Integer id;
  @Field(nameFild = "name", typeFild = "TEXT") String name;
  @Field(nameFild = "country", typeFild = "TEXT") String country;
  @Field(nameFild = "coord", typeFild = "TEXT") Coord coord;
  @JsonIgnore @Field(nameFild = "population", typeFild = "TEXT") public Integer population;
  @JsonIgnore @Field(nameFild = "sys", typeFild = "TEXT") public Sys sys;

  @Override public ContentValues toContentValues(final ContentValues cv, final City weather) {
    return null;
  }

  @Override public <T extends AbstractEntity> T fromCursor(final Cursor cursor) {
    return null;
  }

  public interface Table {
    String ID = BaseColumns._ID;
    String CITY_NAME = "name";
    String COUNTRY = "country";
  }
}
