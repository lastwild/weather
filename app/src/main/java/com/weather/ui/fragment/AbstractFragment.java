package com.weather.ui.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.weather.R;
import com.weather.data.http.FailureCallBack;
import com.weather.utils.AppUtils;

public class AbstractFragment extends Fragment implements FailureCallBack {

  @Override public void onAttach(Context context) {
    super.onAttach(context);
  }
  @Override public void onFailure(Throwable t) {
    AppUtils.getInstance().showToast(R.string.check_internet);
  }
}
