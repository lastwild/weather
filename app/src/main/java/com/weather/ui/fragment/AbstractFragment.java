package com.weather.ui.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.weather.data.http.FailureCallBack;

public class AbstractFragment extends Fragment implements FailureCallBack {

  @Override public void onAttach(final Context context) {
    super.onAttach(context);
  }
  @Override public void onFailure(final Throwable t) {
    final Toast toast = Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT);
    toast.show();
  }
}
