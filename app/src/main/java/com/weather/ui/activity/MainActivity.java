package com.weather.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.weather.R;
import com.weather.ui.component.adapters.ViewPagerAdapter;
import com.weather.ui.fragment.ForecastForTodayFragment;
import com.weather.ui.fragment.ThreeFragment;

public class MainActivity extends AbstractActvity {
  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.tabs) TabLayout tabLayout;
  @Bind(R.id.viewpager) ViewPager viewPager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.a_main);
    ButterKnife.bind(this);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    setupViewPager(viewPager);
    tabLayout.setupWithViewPager(viewPager);
  }

  private void setupViewPager(ViewPager viewPager) {
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
    adapter.addFragment(new ForecastForTodayFragment(), R.string.tab_today_weather);
    adapter.addFragment(new ThreeFragment(), R.string.tab_three_days_weather);
    viewPager.setAdapter(adapter);
  }
}
