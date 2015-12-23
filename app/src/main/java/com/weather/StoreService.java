package com.weather;

import com.weather.data.http.ApiServices;
import com.weather.data.http.FailureCallBack;
import com.weather.data.http.ResponseCallback;
import com.weather.data.model.ForecastForDays;
import com.weather.data.model.ForecastForToday;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class StoreService {
  private static Store store = Store.getInstance();
  //Todo тестовое значение private
   static String countryCode= "ru";;


  public static void processForecastForToday(String city, final ResponseCallback<ForecastForToday> responseCallback,
      final FailureCallBack failureCallBack) {
    Call<ForecastForToday> call = ApiServices.getForecastForToday(city);
    call.enqueue(new Callback<ForecastForToday>() {
      @Override public void onResponse(Response<ForecastForToday> response, Retrofit retrofit) {
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

  public static void processForecastForFiveDays(String city, final ResponseCallback<ForecastForDays> responseCallback,
      final FailureCallBack failureCallBack) {
    Call<ForecastForDays> call = ApiServices.getForecastForFiveDays(city + "," + countryCode);
    call.enqueue(new Callback<ForecastForDays>() {
      @Override public void onResponse(Response<ForecastForDays> response, Retrofit retrofit) {
        if (response != null && response.body() != null) {
          //Todo  сохранение в базу данных;
        }
        if (responseCallback != null) responseCallback.onResponse(response, retrofit);
      }

      @Override public void onFailure(Throwable t) {
        if (failureCallBack != null) failureCallBack.onFailure(t);
      }
    });
    return;
  }

  public static void processForecastForSixteenDays(String city,
      final ResponseCallback<ForecastForDays> responseCallback, final FailureCallBack failureCallBack) {
    Call<ForecastForDays> call = ApiServices.getForecastForSixteenDays(city + "," + countryCode);
    call.enqueue(new Callback<ForecastForDays>() {
      @Override public void onResponse(Response<ForecastForDays> response, Retrofit retrofit) {
        if (response != null && response.body() != null) {
          //Todo  сохранение в базу данных;
        }
        if (responseCallback != null) responseCallback.onResponse(response, retrofit);
      }

      @Override public void onFailure(Throwable t) {
        if (failureCallBack != null) failureCallBack.onFailure(t);
      }
    });
    return;
  }

  public static void processHourlyHistorical(String city, final ResponseCallback<ForecastForDays> responseCallback,
      final FailureCallBack failureCallBack) {
     int start = 1;
    Call<ForecastForDays> call = ApiServices.getHourlyHistorical(city, start);
    call.enqueue(new Callback<ForecastForDays>() {
      @Override public void onResponse(Response<ForecastForDays> response, Retrofit retrofit) {
        if (response != null && response.body() != null) {
          //Todo  сохранение в базу данных;
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
