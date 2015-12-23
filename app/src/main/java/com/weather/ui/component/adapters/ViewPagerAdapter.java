package com.weather.ui.component.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
  private final List<Fragment> listFragment = new ArrayList<>();
  private final List<String> listTitle = new ArrayList<>();

  public ViewPagerAdapter(final FragmentManager fm) {
    super(fm);
  }

  @Override public Fragment getItem(final int position) {

    return listFragment.get(position);
  }

  @Override public int getCount() {
    return listFragment.size();
  }

  public void addFragment(final Fragment fragment, final String title) {
    listFragment.add(fragment);
    listTitle.add(title);
  }

  @Override public CharSequence getPageTitle(final int position) {
    return listTitle.get(position);
  }
}
