package com.weather.data.model;

import java.util.ArrayList;

public class ForecastForFiveDays {
  public City city;
  public String cod;
  public Float message;
  public Integer cnt;
  public ArrayList<WeatherList> list = new ArrayList();
}
