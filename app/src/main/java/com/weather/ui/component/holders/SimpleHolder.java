package com.weather.ui.component.holders;

import android.view.View;

public class SimpleHolder<String> extends  AbstractHolder {
  public SimpleHolder(View itemView) {
    super(itemView);
  }

  @Override public <T> void bind(T Object) {

  }
}
