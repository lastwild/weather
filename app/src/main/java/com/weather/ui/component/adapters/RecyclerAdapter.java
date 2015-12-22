package  com.weather.ui.component.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.weather.ui.component.holders.AbstractHolder;
import java.util.ArrayList;
import java.util.List;


public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<AbstractHolder> {
    private List<T> list = new ArrayList<T>();

    public RecyclerAdapter(List<T> list) {
        this.list = list;
    }

    @Override public abstract AbstractHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override public void onBindViewHolder(AbstractHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override public int getItemCount() {
        return list.size();
    }
}
