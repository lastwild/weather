package com.weather.ui.component.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.weather.ui.component.holders.AbstractHolder;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRecyclerAdapter<T> extends RecyclerView.Adapter<AbstractHolder> {
  private List<T> data = new ArrayList<>();

  public AbstractRecyclerAdapter(List<T> data) {
    if (data != null && !data.isEmpty()) {
      this.data.addAll(data);
    }
  }

  @Override public  abstract AbstractHolder onCreateViewHolder(ViewGroup viewGroup, int i);

  @Override public void onBindViewHolder(AbstractHolder holder, int position) {
    holder.bind(data.get(position));
  }

  @Override public int getItemCount() {
    return data.size();
  }
}
