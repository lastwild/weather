package com.weather.ui.component.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.weather.R;

public class ImageAdapter extends PagerAdapter {
  Context context;
  LayoutInflater inflater;
  int[] mResources = {
      R.drawable.one,
      R.drawable.two,
      R.drawable.three
  };

  public ImageAdapter(Context context) {
    this.context = context;
    inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    return mResources.length;
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
    return view == (object);
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
    View itemView = inflater.inflate(R.layout.i_pager, container, false);

    ImageView imageView = (ImageView) itemView.findViewById(R.id.image_view);
    imageView.setImageResource(mResources[position]);

    container.addView(itemView);

    return itemView;
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((LinearLayout) object);
  }
}

