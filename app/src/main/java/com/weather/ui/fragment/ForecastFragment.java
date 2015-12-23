package com.weather.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.weather.R;
import com.weather.ui.component.adapters.ImageAdapter;
import com.weather.ui.component.adapters.ViewPagerAdapter;

public class ForecastFragment extends AbstractFragment {
  @Bind(R.id.tab_layout) TabLayout tabLayout;
  @Bind(R.id.viewpager) ViewPager viewPager;
  @Bind(R.id.image_pager) ViewPager imagePager;

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.f_forecast, container, false);
    ButterKnife.bind(this, view);
    setupViewPagers(viewPager);
    tabLayout.setupWithViewPager(viewPager);
    return view;
  }

  private void setupViewPagers(ViewPager viewPager) {
    ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
    adapter.addFragment(new ForecastForFiveDaysFragment(), getString(R.string.current_weather));
    adapter.addFragment(new ForecastForTodayFragment(), getString(R.string.five_days_forecast));
    adapter.addFragment(new ForecastForSixteenDaysFragment(), getString(R.string.sixteen_days_forecast));
    viewPager.setAdapter(adapter);
    ImageAdapter imageAdapter = new ImageAdapter(getActivity());
    imagePager.setAdapter(imageAdapter);
    viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        imagePager.setCurrentItem(position);
      }

      @Override public void onPageSelected(int position) {

      }

      @Override public void onPageScrollStateChanged(int state) {

      }
    });
  }
}