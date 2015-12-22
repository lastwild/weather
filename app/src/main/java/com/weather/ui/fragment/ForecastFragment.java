package com.weather.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.weather.R;
import com.weather.ui.component.adapters.ImageAdapter;
import com.weather.ui.component.adapters.ViewPagerAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ForecastFragment extends Fragment {
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewPager;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapse_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(R.id.image_pager)
    ViewPager imagePager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_forecast, container, false);
        ButterKnife.bind(this, view);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setPadding(0, 5, 0, 0);
        ImageAdapter imageAdapter = new ImageAdapter(getActivity());
        imagePager.setAdapter(imageAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                imagePager.setCurrentItem(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new ForecastForFiveDaysFragment(), getString(R.string.forestTest));
        adapter.addFragment(new ForecastForTodayFragment(), getString(R.string.forestTest));
        adapter.addFragment(new ForecastForTodayFragment(), getString(R.string.forestTest));
        viewPager.setAdapter(adapter);
    }
}