package com.weather.ui.activity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.weather.R;
import com.weather.ui.fragment.ForecastFragment;
import com.weather.utils.AppUtils;

public class MainActivity extends AppCompatActivity {
  @Bind(R.id.drawer_layout) DrawerLayout drawer;
  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.edit_city) EditText editCity;
  ActionBarDrawerToggle mDrawerToggle;

  @Override protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.a_main);
    ButterKnife.bind(this);
    addDrawerItems();
    setupDrawer();
    setActionBar();
    switchFragment();
    editCity.setOnTouchListener(new View.OnTouchListener() {
      @Override public boolean onTouch(final View v, final MotionEvent event) {
        //Todo test data
        final String[] testArray = { "test", "test" };
        AppUtils.showListDialog(R.string.forestTest, testArray, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(final DialogInterface dialog, final int which) {

          }
        }); return false;
      }
    });
  }


  private void setActionBar() {
    if (toolbar != null) {
      setSupportActionBar(toolbar);
    }
    final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
    actionBar.setDisplayHomeAsUpEnabled(true);
    actionBar.setHomeButtonEnabled(true);
  }

  private void switchFragment() {
    getSupportFragmentManager().beginTransaction().add(R.id.conteiner, new ForecastFragment()).commit();
  }

  private void addDrawerItems() {

  }

  private void setupDrawer() {
    mDrawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.forestTest, R.string.forestTest) {

      @Override public void onDrawerOpened(final View drawerView) {
        super.onDrawerOpened(drawerView);
        invalidateOptionsMenu();
      }

      @Override public void onDrawerClosed(final View view) {
        super.onDrawerClosed(view);
        invalidateOptionsMenu();
      }
    };

    mDrawerToggle.setDrawerIndicatorEnabled(true);
    drawer.setDrawerListener(mDrawerToggle);
  }

  @Override protected void onPostCreate(final Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    mDrawerToggle.syncState();
  }

  @Override public void onConfigurationChanged(final Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    mDrawerToggle.onConfigurationChanged(newConfig);
  }

  @Override public boolean onOptionsItemSelected(final MenuItem item) {
    return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
  }
}
