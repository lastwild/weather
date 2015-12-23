package com.weather.ui.component.holders;

import android.view.View;

public class SimpleHolder<String> extends  AbstractHolder {
  public SimpleHolder(final View itemView) {
    super(itemView);
  }

  @Override public <T> void bind(final T Object) {

  }
}
