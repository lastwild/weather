package com.weather.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.weather.R;

public class AbstractActvity extends AppCompatActivity {
  private ListView mDrawerList;
  private DrawerLayout drawer;
  private ArrayAdapter<String> adapter;
  private ActionBarDrawerToggle mDrawerToggle;
  private String mActivityTitle;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.a_abstract);

    mDrawerList = (ListView) findViewById(R.id.navList);
    drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    mActivityTitle = getTitle().toString();

    addDrawerItems();
    setupDrawer();

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
  }

  private void addDrawerItems() {
    String[] osArray = { "Android", "iOS", "Windows", "OS X", "Linux" };
    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
    mDrawerList.setAdapter(adapter);

    mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(AbstractActvity.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
      }
    });
  }

  private void setupDrawer() {
    mDrawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.drawer_open, R.string.drawer_close) {

      @Override public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);
        getSupportActionBar().setTitle("Navigation!");
        invalidateOptionsMenu();
      }

      @Override public void onDrawerClosed(View view) {
        super.onDrawerClosed(view);
        getSupportActionBar().setTitle(mActivityTitle);
        invalidateOptionsMenu();
      }
    };

    mDrawerToggle.setDrawerIndicatorEnabled(true);
    drawer.setDrawerListener(mDrawerToggle);
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    mDrawerToggle.syncState();
  }

  @Override public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    mDrawerToggle.onConfigurationChanged(newConfig);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }

    if (mDrawerToggle.onOptionsItemSelected(item)) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
