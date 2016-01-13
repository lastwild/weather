package com.weather.ui.component.adapters;

import android.view.ViewGroup;
import com.weather.data.model.AbstractEntity;
import com.weather.ui.component.holders.ForecastHolder;
import java.util.List;

public class ForecastAdapter extends AbstractRecyclerAdapter<AbstractEntity> {
  public ForecastAdapter(final List<AbstractEntity> data) {
    super(data);
  }

  @Override public ForecastHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    return new ForecastHolder(viewGroup);
  }
}
