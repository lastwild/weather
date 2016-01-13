package com.weather.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.StringRes;
import android.widget.Toast;
import com.weather.Application;
import com.weather.R;

public class AppUtils {
  private static Context context;
  private static AppUtils appUtils;
  private static ProgressDialog progressDialog;

  public AppUtils(final Context context) {
    AppUtils.context = context;
  }

  public static synchronized AppUtils getInstance() {
    if (appUtils == null) {
      appUtils = new AppUtils(Application.systemContext);
    }
    return appUtils;
  }

  public static void showToast(final String string) {
    final Toast toast = Toast.makeText(context, string, Toast.LENGTH_LONG);
    toast.show();
  }

  public static void showListDialog(@StringRes final int resId, final CharSequence[] items,
      final DialogInterface.OnClickListener listener) {
    final AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(resId).setItems(items, listener).show();
  }

  public static void showProgress() {
    progressDialog = new ProgressDialog(context, R.style.CustomDialog);
    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    progressDialog.setMessage(context.getString(R.string.progress_message));
    progressDialog.show();
  }

  public static void hideProgress() {
    try {
      if (progressDialog != null && progressDialog.isShowing()) {
        progressDialog.dismiss();
        progressDialog = null;
      }
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
  }
}
