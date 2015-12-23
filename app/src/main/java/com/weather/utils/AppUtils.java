package com.weather.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.StringRes;
import android.widget.Toast;
import com.weather.Application;

/**
 * Created by fife on 22.12.2015.
 */
public class AppUtils {
  private static Context context;
  private static AppUtils appUtils;

  public AppUtils(Context context) {
    this.context = context;
  }

  public static synchronized AppUtils getInstance() {
    if (appUtils == null) {
      appUtils = new AppUtils(Application.systemContext);
    }
    return appUtils;
  }

  public static void showToast(@StringRes int resId) {
    Toast toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
    toast.show();
  }

  public void showListDialog(@StringRes int resId, CharSequence[] items,
      final DialogInterface.OnClickListener listener) {
    AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(resId).setItems(items, listener).show();
  }
}
