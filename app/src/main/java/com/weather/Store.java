package com.weather;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.weather.data.model.City;
import com.weather.data.model.weather.WeatherWraper;

public class Store extends SQLiteOpenHelper {
  private static Store store;

  public static synchronized Store getInstance() {
    if (store == null) {
      store = new Store();
    }
    return store;
  }

  private Store() {
    super(Application.systemContext, Constants.DB.DB_NAME, null, Constants.DB.DB_VERSON);
  }

  @Override public void onCreate(SQLiteDatabase db) {
    db.execSQL(City.Table.CREATE);
    db.execSQL(WeatherWraper.Table.CREATE);
  }

  @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }

  public final void saveWeather(final WeatherWraper weather) {
    if (weather != null) {
      final SQLiteDatabase db = this.getWritableDatabase();
      final ContentValues cv = new ContentValues();
      db.beginTransaction();
      db.insert(WeatherWraper.Table.NAME_TABLE, null, weather.toContentValues(cv, weather));
      db.setTransactionSuccessful();
      db.endTransaction();
    }
  }

  public final WeatherWraper loadWeatherWraper() {
    final SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor =
        db.query(WeatherWraper.Table.NAME_TABLE, WeatherWraper.Table.PROJECTION, null, null, null, null, null);
    try {
      cursor.moveToFirst();
      return WeatherWraper.fromCursor(cursor);
    } finally {
      cursor.close();
    }
  }
}
