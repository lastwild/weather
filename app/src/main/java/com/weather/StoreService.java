package com.weather;

import com.weather.data.http.ApiServices;
import com.weather.data.http.FailureCallBack;
import com.weather.data.http.ResponseCallback;
import com.weather.data.model.weather.WeatherWraper;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class StoreService {
  private static Store store = Store.getInstance();

  public static void processForecastForToday(String city, final ResponseCallback<WeatherWraper> responseCallback,
      final FailureCallBack failureCallBack) {
    Call<WeatherWraper> call = ApiServices.getForecastForToday(city);
    call.enqueue(new Callback<WeatherWraper>() {
      @Override public void onResponse(Response<WeatherWraper> response, Retrofit retrofit) {
        if (response != null && response.body() != null) {
          store.saveWeather(response.body());
        }
        if (responseCallback != null) responseCallback.onResponse(response, retrofit);
      }

      @Override public void onFailure(Throwable t) {
        if (failureCallBack != null) failureCallBack.onFailure(t);
      }
    });
    return;
  } 
  
  public static void processForecastForFiveDays(String city, final ResponseCallback<WeatherWraper> responseCallback,
      final FailureCallBack failureCallBack) {
    Call<WeatherWraper> call = ApiServices.getForecastForFiveDays(city);
    call.enqueue(new Callback<WeatherWraper>() {
      @Override public void onResponse(Response<WeatherWraper> response, Retrofit retrofit) {
        if (response != null && response.body() != null) {
          store.saveWeather(response.body());
        }
        if (responseCallback != null) responseCallback.onResponse(response, retrofit);
      }

      @Override public void onFailure(Throwable t) {
        if (failureCallBack != null) failureCallBack.onFailure(t);
      }
    });
    return;
  }
}
