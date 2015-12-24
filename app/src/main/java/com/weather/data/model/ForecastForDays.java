package com.weather.data.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.weather.data.http.ApiServices;
import com.weather.data.model.annotations.Field;
import com.weather.data.model.annotations.Table;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)@Table(table = "forecast_five_days") public class ForecastForDays extends AbstractEntity<ForecastForDays> {
  private static final Gson gson = ApiServices.gson;
  @Field(nameFild = "city", typeFild = "TEXT") public City city;
  @Field(nameFild = "cod", typeFild = "TEXT") public String cod;
  @Field(nameFild = "message", typeFild = "TEXT") public Float message;
  @Field(nameFild = "cnt", typeFild = "TEXT") public Integer cnt;
  @Field(nameFild = "weather_list", typeFild = "TEXT") public ArrayList<WeatherList> listWeather =
      new ArrayList<WeatherList>();

  interface Table {
    String CITY = "city";
    String COD = "cod";
    String MESSAGE = "main";
    String CNT = "wind";
    String LIST_WEATHER = "clouds";
  }

  public ForecastForDays city(final City city) {
    this.city = city;
    return this;
  }

  public ForecastForDays cod(final String cod) {
    this.cod = cod;
    return this;
  }

  public ForecastForDays message(final Float message) {
    this.message = message;
    return this;
  }

  public ForecastForDays cnt(final Integer cnt) {
    this.cnt = cnt;
    return this;
  }

  public ForecastForDays listWeather(final ArrayList<WeatherList> listWeather) {
    this.listWeather = listWeather;
    return this;
  }

  @Override public ForecastForDays fromCursor(final Cursor cursor) {
    return new ForecastForDays().city(gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.CITY)), City.class))
        .cod(cursor.getString(cursor.getColumnIndex(Table.COD)))
        .message((float) cursor.getColumnIndex(Table.MESSAGE))
        .cnt(cursor.getColumnIndex(Table.CNT))
        .listWeather((ArrayList<WeatherList>) gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.LIST_WEATHER)),
            new TypeToken<ArrayList<Weather>>() {
            }.getType()));
  }

  @Override public ContentValues toContentValues(ContentValues cv, final ForecastForDays weather) {
    if (weather != null) {
      if (cv == null) {
        cv = new ContentValues();
      } else {
        cv.clear();
      }
      cv.put(Table.CITY, gson.toJson(weather.city));
      cv.put(Table.COD, gson.toJson(weather.cod));
      cv.put(Table.MESSAGE, gson.toJson(weather.message));
      cv.put(Table.CNT, gson.toJson(weather.cnt));
      cv.put(Table.LIST_WEATHER, gson.toJson(weather.listWeather));
    }
    return cv;
  }
}
