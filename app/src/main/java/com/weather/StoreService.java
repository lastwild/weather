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
  private final static Store store = Store.getInstance();
  //Todo тестовое значение private
   static String countryCode= "ru";


  public static void processForecastForToday(final String city, final ResponseCallback<ForecastForToday> responseCallback,
      final FailureCallBack failureCallBack) {
    final Call<ForecastForToday> call = ApiServices.getForecastForToday(city);
    call.enqueue(new Callback<ForecastForToday>() {
      @Override public void onResponse(final Response<ForecastForToday> response, final Retrofit retrofit) {
        if (response != null && response.body() != null) {
          store.saveWeather(response.body());
        }
        if (responseCallback != null) {
          responseCallback.onResponse(response, retrofit);
        }
      }

      @Override public void onFailure(final Throwable t) {
        if (failureCallBack != null) {
          failureCallBack.onFailure(t);
        }
      }
    });
  }

  public static void processForecastForFiveDays(final String city, final ResponseCallback<ForecastForDays> responseCallback,
      final FailureCallBack failureCallBack) {
    final Call<ForecastForDays> call = ApiServices.getForecastForFiveDays(city + "," + countryCode);
    call.enqueue(new Callback<ForecastForDays>() {
      @Override public void onResponse(final Response<ForecastForDays> response, final Retrofit retrofit) {
        if (response != null && response.body() != null) {
          //Todo  сохранение в базу данных;
        }
        if (responseCallback != null) {
          responseCallback.onResponse(response, retrofit);
        }
      }

      @Override public void onFailure(final Throwable t) {
        if (failureCallBack != null) {
          failureCallBack.onFailure(t);
        }
      }
    });
  }

  public static void processForecastForSixteenDays(final String city,
      final ResponseCallback<ForecastForDays> responseCallback, final FailureCallBack failureCallBack) {
    final Call<ForecastForDays> call = ApiServices.getForecastForSixteenDays(city + "," + countryCode);
    call.enqueue(new Callback<ForecastForDays>() {
      @Override public void onResponse(final Response<ForecastForDays> response, final Retrofit retrofit) {
        if (response != null && response.body() != null) {
          //Todo  сохранение в базу данных;
        }
        if (responseCallback != null) {
          responseCallback.onResponse(response, retrofit);
        }
      }

      @Override public void onFailure(final Throwable t) {
        if (failureCallBack != null) {
          failureCallBack.onFailure(t);
        }
      }
    });
  }

  public static void processHourlyHistorical(final String city, final ResponseCallback<ForecastForDays> responseCallback,
      final FailureCallBack failureCallBack) {
     final int start = 1;
    final Call<ForecastForDays> call = ApiServices.getHourlyHistorical(city, start);
    call.enqueue(new Callback<ForecastForDays>() {
      @Override public void onResponse(final Response<ForecastForDays> response, final Retrofit retrofit) {
        if (response != null && response.body() != null) {
          //Todo  сохранение в базу данных;
        }
        if (responseCallback != null) {
          responseCallback.onResponse(response, retrofit);
        }
      }

      @Override public void onFailure(final Throwable t) {
        if (failureCallBack != null) {
          failureCallBack.onFailure(t);
        }
      }
    });
  }
}
