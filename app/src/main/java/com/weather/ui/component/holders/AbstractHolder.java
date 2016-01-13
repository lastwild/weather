package  com.weather.ui.component.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class AbstractHolder<T> extends RecyclerView.ViewHolder {
  public final Context context;
  public AbstractHolder(View itemView) {
    super(itemView);
    this.context = itemView.getContext();
  }

  public AbstractHolder(ViewGroup parent, int layout) {
    this(LayoutInflater.from(parent.getContext()).inflate(layout, parent, false));
  }

  abstract public void bind(T item);
}
