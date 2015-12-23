package  com.weather.ui.component.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class AbstractHolder  extends RecyclerView.ViewHolder{

    public AbstractHolder(final View itemView) {
        super(itemView);
    }

    public abstract  <T> void bind(T Object);
}
