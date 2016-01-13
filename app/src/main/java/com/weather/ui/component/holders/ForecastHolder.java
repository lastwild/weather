package com.weather.ui.component.holders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import com.weather.R;
import com.weather.data.model.WeatherList;

public class ForecastHolder extends AbstractHolder implements View.OnClickListener {
  private WeatherList item;
  @Bind(R.id.temp) TextView temp;
  @Bind(R.id.pressure) TextView pressure;
  @Bind(R.id.sunset) TextView sunset;
  @Bind(R.id.tempMin) TextView tempMin;
  @Bind(R.id.tempMax) TextView tempMax;

  public ForecastHolder(ViewGroup itemView) {
    super(itemView, R.layout.i_forecast);
    itemView.setOnClickListener(this);
  }

  @Override public void bind(Object object) {
    //TODO выбрать адекватные данные
    item = (WeatherList) object;
    temp.setText(item.temp.day.toString());
    pressure.setText(item.main.pressure.toString());
    sunset.setText(item.main.seaLevel.toString());
    tempMin.setText(item.temp.max.toString());
    tempMax.setText(item.temp.min.toString());
  }

  @Override public void onClick(View v) {

  }
}
