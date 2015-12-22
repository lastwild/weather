package com.weather.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.weather.R;
import com.weather.Store;
import com.weather.StoreService;
import com.weather.data.http.FailureCallBack;
import com.weather.data.http.ResponseCallback;
import com.weather.data.model.weather.WeatherWraper;
import retrofit.Response;
import retrofit.Retrofit;

public class ThreeFragment extends Fragment implements FailureCallBack, ResponseCallback<WeatherWraper> {

  TextView text;

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.f_three, container, false);
    StoreService.processForecastForToday("Москва", this, this);
    text = (TextView) view.findViewById(R.id.textView2);
    return view;
  }

  @Override public void onFailure(Throwable t) {
    Toast toast = Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT);
    toast.show();
  }

  @Override public void onResponse(Response<WeatherWraper> response, Retrofit retrofit) {
    WeatherWraper weatherWraper = Store.getInstance().loadWeatherWraper();
    text.setText(weatherWraper.base);
  }
}
