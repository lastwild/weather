package com.weather.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import com.weather.R;
import com.weather.Store;
import com.weather.StoreService;
import com.weather.data.http.ResponseCallback;
import com.weather.data.model.ForecastForToday;
import retrofit.Response;
import retrofit.Retrofit;

public class ForecastForTodayFragment extends AbstractFragment implements ResponseCallback<ForecastForToday> {
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

  @Override public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.f_today, container, false);
    StoreService.processForecastForToday("Москва", this, this);
    return view;
  }


  @Override public void onResponse(final Response<ForecastForToday> response, final Retrofit retrofit) {
    final ForecastForToday weatherWraper = Store.getInstance().loadWeatherWraper();
//    sunrise.setText(weatherWraper.sys.sunrise);
//    sunset.setText(weatherWraper.sys.sunset);
//    pressure.setText(weatherWraper.main.pressure.toString());
/*    temp.setText(weatherWraper.main.temp.toString());
    tempMin.setText(weatherWraper.main.tempMin.toString());
    tempMax.setText(weatherWraper.main.tempMax.toString());*/
  }
}
