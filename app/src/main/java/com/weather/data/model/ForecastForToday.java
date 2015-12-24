package com.weather.data.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.weather.data.http.ApiServices;
import com.weather.data.model.annotations.Field;
import com.weather.data.model.annotations.Table;
import java.util.ArrayList;
import java.util.List;

@Table(table = "forecast_today") public class ForecastForToday extends AbstractEntity<ForecastForToday> {
  public Integer id;
  @Field(nameFild = "coord", typeFild = "TEXT") public Coord coord;
  @Field(nameFild = "main", typeFild = "TEXT") public Main main;
  @Field(nameFild = "wind", typeFild = "TEXT") public Wind wind;
  @Field(nameFild = "base", typeFild = "TEXT") public String base;
  @Field(nameFild = "clouds", typeFild = "TEXT") public Clouds clouds;
  @Field(nameFild = "dt", typeFild = "TEXT") public Integer dt;
  @Field(nameFild = "sys", typeFild = "TEXT") public Sys sys;
  @Field(nameFild = "name", typeFild = "TEXT") public String name;
  @Field(nameFild = "cod", typeFild = "TEXT") public Integer cod;
  @Field(nameFild = "list_weather", typeFild = "TEXT") public List<Weather> weather = new ArrayList<Weather>();
  private static final Gson gson = ApiServices.gson;

  public interface Table {
    String COORD = "coord";
    String BASE = "base";
    String MAIN = "main";
    String WIND = "wind";
    String CLOUDS = "clouds";
    String DT = "dt";
    String SYS = "sys";
    String LIST_WEATHER = "list_weather";
  }

  public final ForecastForToday coord(final Coord coord) {
    this.coord = coord;
    return this;
  }

  public final ForecastForToday base(final String base) {
    this.base = base;
    return this;
  }

  public final ForecastForToday prime(final Main main) {
    this.main = main;
    return this;
  }

  public final ForecastForToday listWeather(final List<Weather> weather) {
    this.weather = weather;
    return this;
  }

  public final ForecastForToday wind(final Wind wind) {
    this.wind = wind;
    return this;
  }

  public final ForecastForToday clouds(final Clouds clouds) {
    this.clouds = clouds;
    return this;
  }

  public final ForecastForToday dt(final Integer dt) {
    this.dt = dt;
    return this;
  }

  public final ForecastForToday sys(final Sys sys) {
    this.sys = sys;
    return this;
  }

  @Override public ForecastForToday fromCursor(final Cursor cursor) {
    return new ForecastForToday().coord(
        gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.COORD)), Coord.class))
        .base(cursor.getString(cursor.getColumnIndex(Table.WIND)))
        .prime(gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.MAIN)), Main.class))
        .wind(gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.WIND)), Wind.class))
        .clouds(gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.CLOUDS)), Clouds.class))
        .dt(cursor.getInt(cursor.getColumnIndex(Table.DT)))
        .sys(gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.SYS)), Sys.class))
        .listWeather((ArrayList<Weather>) gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.LIST_WEATHER)),
            new TypeToken<ArrayList<Weather>>() {
            }.getType()));
  }

  @Override public ContentValues toContentValues(ContentValues cv, final ForecastForToday weather) {
    if (weather != null) {
      if (cv == null) {
        cv = new ContentValues();
      } else {
        cv.clear();
      }
      cv.put(ForecastForToday.Table.BASE, weather.base);
      cv.put(Table.COORD, gson.toJson(weather.coord));
      cv.put(Table.MAIN, gson.toJson(weather.main));
      cv.put(Table.WIND, gson.toJson(weather.wind));
      cv.put(Table.CLOUDS, gson.toJson(weather.clouds));
      cv.put(ForecastForToday.Table.DT, gson.toJson(weather.dt));
      //cv.put(Table.SYS, gson.toJson(weather.message));
      cv.put(Table.LIST_WEATHER, gson.toJson(weather.weather));
    }
    return cv;
  }
}
