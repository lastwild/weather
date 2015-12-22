package com.weather.data.http;

import com.weather.Constants;
import com.weather.data.model.weather.WeatherWraper;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ApiModule {

   @GET(Constants.Server.GET_FORECAST_FOR_TODAY) Call<WeatherWraper> forecastForToday(@Query("q") String city,
      @Query("appid") String apikey);

  @GET(Constants.Server.GET_FORECAST_FOR_FIVE_DAYS) Call<WeatherWraper> forecastForFiveDays(@Query("id") String city,@Query("appid") String apikey);
}
