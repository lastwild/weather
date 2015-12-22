package com.weather;

public interface Constants {
  interface DB {
    final int DB_VERSON = 1;
    final String DB_NAME = "Wiather_DB";
  }

   interface Server{
      String API_KEY ="436588bd14220804aeb31e3c23706c2b";
    // String API_KEY ="3c59af1750149b8a6ba9970b1d18d5e7";
      String BASE_URL ="http://api.openweathermap.org/";
      String GET_FORECAST_FOR_TODAY ="data/2.5/weather";
      String GET_FORECAST_FOR_FIVE_DAYS ="data/2.5/forecast";
   }
}
