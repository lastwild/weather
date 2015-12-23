package com.weather.data.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.weather.data.http.ApiServices;

import java.util.ArrayList;

public class ForecastForDays {
    public City city;
    public String cod;
    public Float message;
    public Integer cnt;
    public ArrayList<WeatherList> listWeather = new ArrayList<WeatherList>();
    private final static Gson gson = ApiServices.gson;

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

    public interface Table {
        String NAME_TABLE_FIVE_DAYS = "forecast_five_days";
        String NAME_TABLE_SEXTEEN_DAYS = "forecast_five_days";
        String ID = BaseColumns._ID;
        String CITY = "coord";
        String COD = "base";
        String MESSAGE = "main";
        String CNT = "wind";
        String LIST_WEATHER = "clouds";

        String[] PROJECTION = {CITY, COD, MESSAGE, CNT, LIST_WEATHER};

        String BILDER = " ("
                + ID
                + " TEXT PRIMARY KEY, "
                + CITY
                + " TEXT, "
                + COD
                + " TEXT, "
                + MESSAGE
                + " TEXT, "
                + CNT
                + " TEXT, "
                + LIST_WEATHER
                + " TEXT);";

        String CREATE_FORECAST_FOR_FIVE_DAYS = "CREATE TABLE" + NAME_TABLE_FIVE_DAYS + BILDER;
        String CREATE_FORECAST_FOR_SIXTEEN_DAYS = "CREATE TABLE" + NAME_TABLE_SEXTEEN_DAYS + BILDER;
    }


    public static ContentValues toContentValues(ContentValues cv, final ForecastForDays weather) {
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

    public static ForecastForDays fromCursor(final Cursor cursor) {
        return new ForecastForDays()
                .city(gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.CITY)), City.class))
                .cod(cursor.getString(cursor.getColumnIndex(Table.COD)))
                .message((float) cursor.getColumnIndex(Table.MESSAGE))
                .cnt(cursor.getColumnIndex(Table.CNT))
                .listWeather((ArrayList<WeatherList>) gson.fromJson(cursor.getString(cursor.getColumnIndex(Table.LIST_WEATHER)), new TypeToken<ArrayList<Weather>>() {
                }.getType()));
    }
}
