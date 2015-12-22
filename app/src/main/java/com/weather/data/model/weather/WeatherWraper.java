package com.weather.data.model.weather;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

public class WeatherWraper {
  public Coord coord;
  public List<Weather> weather = new ArrayList<Weather>();
  public String base;
  public Main main;
  public Wind wind;
  public Clouds clouds;
  public Integer dt;
  public Sys sys;
  public Integer id;
  public String name;
  public Integer cod;

  private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

  public final WeatherWraper coord(final Coord coord) {
    this.coord = coord;
    return this;
  }

  public final WeatherWraper base(final String base) {
    this.base = base;
    return this;
  }

  public final WeatherWraper prime(final Main main) {
    this.main = main;
    return this;
  }

  public final WeatherWraper listWeather(final List<Weather> weather) {
    this.weather = weather;
    return this;
  }

  public final WeatherWraper wind(final Wind wind) {
    this.wind = wind;
    return this;
  }

  public final WeatherWraper clouds(final Clouds clouds) {
    this.clouds = clouds;
    return this;
  }

  public final WeatherWraper dt(final Integer dt) {
    this.dt = dt;
    return this;
  }

  public final WeatherWraper sys(final Sys sys) {
    this.sys = sys;
    return this;
  }

  public interface Table {
    String NAME_TABLE = "weather";
    String ID = BaseColumns._ID;
    String COORD = "coord";
    String BASE = "base";
    String MAIN = "main";
    String WIND = "wind";
    String CLOUDS = "clouds";
    String DT = "dt";
    String SYS = "sys";
    String WEATHER = "list_weather";

    String[] PROJECTION = { COORD, BASE, MAIN, WIND, CLOUDS, DT, SYS, WEATHER };

    String CREATE = "CREATE TABLE "
        + NAME_TABLE
        + " ("
        + ID
        + " TEXT PRIMARY KEY, "
        + COORD
        + " TEXT, "
        + BASE
        + " TEXT, "
        + MAIN
        + " TEXT, "
        + WIND
        + " TEXT, "
        + CLOUDS
        + " TEXT, "
        + DT
        + " INTEGER, "
        + WEATHER
        + " TEXT, "
        + SYS
        + " TEXT);";
  }

  public static ContentValues toContentValues(ContentValues cv, WeatherWraper weather) {
    if(weather!= null) {
      if (cv == null) {
        cv = new ContentValues();
      } else {
        cv.clear();
      }
      cv.put(WeatherWraper.Table.BASE, weather.base);
      cv.put(Table.COORD, gson.toJson(weather.coord));
      cv.put(Table.MAIN, gson.toJson(weather.main));
      cv.put(Table.WIND, gson.toJson(weather.wind));
      cv.put(Table.CLOUDS, gson.toJson(weather.clouds));
      cv.put(WeatherWraper.Table.DT, gson.toJson(weather.dt));
      //cv.put(Table.SYS, gson.toJson(weather.message));
      cv.put(Table.WEATHER, gson.toJson(weather.weather));
    }
      return cv;
  }

  public static WeatherWraper fromCursor(Cursor cursor) {
    return new WeatherWraper().coord(gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.COORD)), Coord.class))
        .base(cursor.getString(cursor.getColumnIndex(Table.WIND)))
        .prime(gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.MAIN)), Main.class))
        .wind(gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.WIND)), Wind.class))
        .clouds(gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.CLOUDS)), Clouds.class))
        .dt(cursor.getInt(cursor.getColumnIndex(Table.DT)))
        .sys(gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.SYS)), Sys.class));
    //.sys(gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.WEATHER)),  List<Weather>.));
  }
}
