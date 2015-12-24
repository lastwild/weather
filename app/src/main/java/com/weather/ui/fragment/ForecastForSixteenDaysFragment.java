package com.weather.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.weather.R;
import com.weather.StoreService;
import com.weather.data.http.ResponseCallback;
import com.weather.data.model.ForecastForDays;
import retrofit.Response;
import retrofit.Retrofit;

public class ForecastForSixteenDaysFragment extends AbstractFragment implements
    ResponseCallback<ForecastForDays> {

  @Override public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.f_sixteen_forecast, container, false);
    StoreService.processForecastForSixteenDays("Moscow", this, this);
    return view;
  }

  @Override public void onResponse(final Response<ForecastForDays> response, final Retrofit retrofit) {
    final Toast toast = Toast.makeText(getActivity(), getClass().getSimpleName() +" "+ "work test", Toast.LENGTH_LONG);
    toast.show();
  }
}
