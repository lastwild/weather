package com.weather.data.http;

import com.weather.Constants;
import com.weather.data.model.ForecastForDays;
import com.weather.data.model.ForecastForToday;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ApiModule {

  @GET(Constants.Server.GET_FORECAST_FOR_TODAY) Call<ForecastForToday> forecastForToday(@Query("q") String city,
      @Query("appid") String apikey);

  @GET(Constants.Server.GET_FORECAST_FOR_FIVE_DAYS) Call<ForecastForDays> forecastForFiveDays(@Query("q") String city,
      @Query("appid") String apikey);

  @GET(Constants.Server.GET_FORECAST_FOR_SIXTEEN_DAYS) Call<ForecastForDays> forecastForSixteenDays(
      @Query("q") String city, @Query("cnt") int numberDays, @Query("appid") String apiKey);

  @GET(Constants.Server.GET_HISTORICAL_DATA) Call<ForecastForDays> hourlyHistorical(@Query("q") String city,
      @Query("typeFild") String type, @Query("start") int start, @Query("cnt") int count,
      @Query("appid") String apiKey);
}
