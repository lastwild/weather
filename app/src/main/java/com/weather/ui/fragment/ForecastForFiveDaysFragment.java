package com.weather.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.weather.R;
import com.weather.StoreService;
import com.weather.data.http.FailureCallBack;
import com.weather.data.http.ResponseCallback;
import com.weather.data.model.ForecastForDays;
import retrofit.Response;
import retrofit.Retrofit;

public class ForecastForFiveDaysFragment extends AbstractFragment
    implements FailureCallBack, ResponseCallback<ForecastForDays> {

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.f_five_forecast, container, false);
    StoreService.processForecastForFiveDays("Москва", this, this);
    return view;
  }

  @Override public void onResponse(Response<ForecastForDays> response, Retrofit retrofit) {

  }
}
