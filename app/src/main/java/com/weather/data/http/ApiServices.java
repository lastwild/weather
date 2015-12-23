package com.weather.data.http;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.weather.Constants;
import com.weather.data.model.ForecastForDays;
import com.weather.data.model.ForecastForToday;
import retrofit.Call;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

public class ApiServices {
  static ApiModule apiModule;
  static OkHttpClient httpClient;

  static {
    initHttpClient();
    initApiModule();
  }

  private static void initHttpClient() {
    httpClient = new OkHttpClient();
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    httpClient.interceptors().add(interceptor);
  }

  private static void initApiModule() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.Server.BASE_URL)
        .addConverterFactory(JacksonConverterFactory.create())
        .client(httpClient)
        .build();
    apiModule = retrofit.create(ApiModule.class);
  }

  public static Call<ForecastForToday> getForecastForToday(String city) {
    return apiModule.forecastForToday(city, Constants.Server.API_KEY);
  }

  public static Call<ForecastForDays> getForecastForFiveDays(String city) {
    return apiModule.forecastForFiveDays(city, Constants.Server.API_KEY);
  }

  public static Call<ForecastForDays> getForecastForSixteenDays(String city) {
    return apiModule.forecastForSixteenDays(city, Constants.COUNT, Constants.Server.API_KEY);
  }

  public static Call<ForecastForDays> getHourlyHistorical(String city, int start) {
    return apiModule.hourlyHistorical(city, Constants.TYPE, start, Constants.COUNT, Constants.Server.API_KEY);
  }
}
