package com.weather.data.http;

import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by fife on 16.12.2015.
 */
public interface ResponseCallback<T> {
     void onResponse(Response<T> response, Retrofit retrofit);
}
