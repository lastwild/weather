package com.weather.ui.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import com.weather.R;
import com.weather.ui.component.adapters.ImageAdapter;
import com.weather.ui.component.adapters.ViewPagerAdapter;
import com.weather.ui.fragment.ForecastForFiveDaysFragment;
import com.weather.ui.fragment.ForecastForTodayFragment;

public class MainActivity extends AbstractActvity {
  TabLayout tabLayout;
  ViewPager viewPager;
  Toolbar toolbar;
  CollapsingToolbarLayout collapsingToolbarLayout;
  private ViewPager imagePager;
  private ImageView imageView;
  ImageAdapter imageAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.a_main);
  //  ButterKnife.bind(this);
    tabLayout = (TabLayout) this.findViewById(R.id.htab_tabs);
    viewPager = (ViewPager) this.findViewById(R.id.htab_viewpager);
    imagePager = (ViewPager) this.findViewById(R.id.image_pager);
    toolbar = (Toolbar) this.findViewById(R.id.htab_toolbar);
    collapsingToolbarLayout = (CollapsingToolbarLayout) this.findViewById(R.id.htab_collapse_toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    setupViewPager(viewPager);
    tabLayout.setupWithViewPager(viewPager);
    tabLayout.setPadding(0, 5, 0, 0);
    imageAdapter = new ImageAdapter(MainActivity.this);
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
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
  }

  private void setupViewPager(ViewPager viewPager) {
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new ForecastForFiveDaysFragment(), getString(R.string.forestTest));
    adapter.addFragment(new ForecastForTodayFragment(), getString(R.string.forestTest));
    viewPager.setAdapter(adapter);
  }
}