package com.weather.data.model;

import java.util.ArrayList;

public class WeatherList {
  public Integer dt;
  public Main main;
  public java.util.List<Weather> weather = new ArrayList<Weather>();
  public Clouds clouds;
  public Wind wind;
  public Rain rain;
  public Pod sys;
  public String dtTxt;
  public Snow snow;
}
