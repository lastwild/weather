package com.weather.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import com.weather.R;

public class ForecastForTodayFragment extends Fragment {
  @Bind(R.id.sunrise) TextView sunrise;
  @Bind(R.id.sunset) TextView sunset;
  @Bind(R.id.main) TextView main;
  @Bind(R.id.description) TextView description;
  @Bind(R.id.pressure) TextView pressure;
  @Bind(R.id.temp) TextView temp;
  @Bind(R.id.humidity) TextView humidity;
  @Bind(R.id.tempMin) TextView tempMin;
  @Bind(R.id.tempMax) TextView tempMax;
  @Bind(R.id.speed) TextView speed;
  @Bind(R.id.allClouds) TextView allClouds;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_today, container, false);
        return view;

      //sunrise.setText(weather.sys.sunrise);
      //sunset.setText(weather.sys.sunset);
      //main.setText(weather.prime.);
      //description.setText(weather.);
      //pressure.setText(weather.prime.pressure);
      //temp.setText(weather.prime.temp);
      //humidity.setText();
      //tempMin.setText(weather.prime.tempMin);
      //tempMax.setText(weather.prime.tempMax);
    }
}
