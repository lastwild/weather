package com.weather.data.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.weather.Constants;
import com.weather.data.model.ForecastForDays;
import com.weather.data.model.ForecastForToday;
import retrofit.Call;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

public class ApiServices {
  private static ApiModule apiModule;
  private static OkHttpClient httpClient;
  public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  static {
    initHttpClient();
    initApiModule();
  }

  private static void initHttpClient() {
    httpClient = new OkHttpClient();
    final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    httpClient.interceptors().add(interceptor);
  }

  private static void initApiModule() {
    final Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.Server.BASE_URL)
        .addConverterFactory(JacksonConverterFactory.create())
        .client(httpClient)
        .build();
    apiModule = retrofit.create(ApiModule.class);
  }

  public static Call<ForecastForToday> getForecastForToday(final String city) {
    return apiModule.forecastForToday(city, Constants.Server.API_KEY);
  }

  public static Call<ForecastForDays> getForecastForFiveDays(final String city) {
    return apiModule.forecastForFiveDays(city, Constants.Server.API_KEY);
  }

  public static Call<ForecastForDays> getForecastForSixteenDays(final String city) {
    return apiModule.forecastForSixteenDays(city, Constants.COUNT, Constants.Server.API_KEY);
  }

  public static Call<ForecastForDays> getHourlyHistorical(final String city, final int start) {
    return apiModule.hourlyHistorical(city, Constants.TYPE, start, Constants.COUNT, Constants.Server.API_KEY);
  }
}
