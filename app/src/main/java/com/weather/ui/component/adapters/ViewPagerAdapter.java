package com.weather.ui.component.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
  private final List<Fragment> listFragment = new ArrayList<>();
  private final List<String> listTitle = new ArrayList<>();
  private final Context context;

  public ViewPagerAdapter(FragmentManager fm, Context context) {
    super(fm);
    this.context = context;
  }

  @Override
  public Fragment getItem(int position) {
    return listFragment.get(position);
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return listTitle.get(position);
  }

  @Override
  public int getCount() {
    return listFragment.size();
  }

  public ViewPagerAdapter addFragment(Fragment fragment,int resourse){
    listFragment.add(fragment);
    listTitle.add(context.getResources().getString(resourse));
    return this;
  }

}