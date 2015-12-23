package com.weather.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.weather.R;
import com.weather.StoreService;
import com.weather.data.http.ResponseCallback;
import com.weather.data.model.ForecastForDays;
import retrofit.Response;
import retrofit.Retrofit;

public class HourlyHistoricalFragment extends AbstractFragment implements ResponseCallback<ForecastForDays> {

  @Override public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.f_history, container, false);
    StoreService.processHourlyHistorical("Москва", this, this);
    return view;
  }

  @Override public void onResponse(final Response<ForecastForDays> response, final Retrofit retrofit) {

  }
}
