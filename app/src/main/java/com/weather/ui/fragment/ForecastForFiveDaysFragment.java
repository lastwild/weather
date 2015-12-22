package com.weather.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.weather.R;
import com.weather.Store;
import com.weather.StoreService;
import com.weather.data.http.FailureCallBack;
import com.weather.data.http.ResponseCallback;
import com.weather.data.model.ForecastForToday;
import com.weather.utils.AppUtils;

import retrofit.Response;
import retrofit.Retrofit;

public class ForecastForFiveDaysFragment extends Fragment implements FailureCallBack, ResponseCallback<ForecastForToday> {

    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_three, container, false);
        StoreService.processForecastForToday("Москва", this, this);
        text = (TextView) view.findViewById(R.id.textView2);
        return view;
    }

    @Override
    public void onFailure(Throwable t) {
        AppUtils.getInstance().showToast(R.string.check_internet);
    }

    @Override
    public void onResponse(Response<ForecastForToday> response, Retrofit retrofit) {
        ForecastForToday weatherWraper = Store.getInstance().loadWeatherWraper();
        text.setText(weatherWraper.base);
    }
}
