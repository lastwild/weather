package com.weather.ui.component.adapters;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.weather.ui.component.holders.AbstractHolder;
import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerAdapter<T, VH extends AbstractHolder> extends RecyclerView.Adapter<VH> {
  private int res;
  private List<T> data = new ArrayList<T>();

  public RecyclerAdapter(final List<T> data, @LayoutRes int res) {
    if (data != null) {
      this.data = data;
      this.res = res;
    }
  }

  @Override public VH onCreateViewHolder(ViewGroup parent, int viewType) {
/*    View v = LayoutInflater.from(parent.getContext()).inflate(res, parent, false);
    AbstractHolder holder = new<VH> AbstractHolder(v);
    return holder;*/
    return null;
  }

  @Override public void onBindViewHolder(final VH holder, final int position) {
    holder.bind(data.get(position));
  }

  @Override public int getItemCount() {
    return data.size();
  }
}
