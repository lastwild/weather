package com.weather;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import com.weather.data.model.AbstractEntity;
import com.weather.data.model.City;
import com.weather.data.model.ForecastForDays;
import com.weather.data.model.ForecastForSexteenDays;
import com.weather.data.model.ForecastForToday;
import com.weather.data.model.HourlyHistorical;
import com.weather.data.model.annotations.Field;
import com.weather.data.model.annotations.Table;

public class Store<T extends AbstractEntity> extends SQLiteOpenHelper {
  private static Store store;

  public static synchronized Store getInstance() {
    if (store == null) {
      store = new Store();
    }
    return store;
  }

  private static String[] getProjection(final Class aClass) {
    final java.lang.reflect.Field[] fields = aClass.getFields();
    int size = fields.length;
    final String[] projection = new String[size];
    for (int i = 0; i < size; i++) {
      if (fields[i].getAnnotation(Field.class) != null) {
        final Field fild = fields[i].getAnnotation(Field.class);
        projection[i] = fild.nameFild();
      }
    }
    return projection;
  }

  private static String getTableName(final Class aClass) {
    final Table tableName = (Table) aClass.getAnnotation(Table.class);
    if (tableName != null) {
      return tableName.table();
    }
    return null;
  }

  private String createTable(final Class aClass) {
    final StringBuilder stringBuilder = new StringBuilder();
    final Table tableName = (Table) aClass.getAnnotation(Table.class);
    if (tableName != null) {
      final String name = tableName.table();
      stringBuilder.append("CREATE TABLE")
          .append(" ")
          .append(name)
          .append(" ")
          .append("(")
          .append(BaseColumns._ID)
          .append(" ")
          .append("EXT PRIMARY KEY,")
          .append(" ");
      final java.lang.reflect.Field[] fields = aClass.getFields();
      for (int i = 0; i < fields.length; i++) {
        if (fields[i].getAnnotation(Field.class) != null) {
          final Field fild = fields[i].getAnnotation(Field.class);
          final String fildName = fild.nameFild();
          final String fildType = fild.typeFild();
          stringBuilder.append(" ").append(fildName).append(" ").append(fildType);
        }
      }
      stringBuilder.append(");");
      Log.d("Debag", stringBuilder.toString());
      return stringBuilder.toString();
    }
    return null;
  }

  private Store() {
    super(Application.systemContext, Constants.DB.DB_NAME, null, Constants.DB.DB_VERSON);
  }

  @Override public void onCreate(final SQLiteDatabase db) {
    db.execSQL(createTable(City.class));
    db.execSQL(createTable(ForecastForDays.class));
    db.execSQL(createTable(ForecastForToday.class));
    db.execSQL(createTable(ForecastForSexteenDays.class));
    db.execSQL(createTable(HourlyHistorical.class));
  }

  @Override public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
  }

  public final void saveWeather(final T weather) {
    if (weather != null) {
      final SQLiteDatabase db = this.getWritableDatabase();
      final ContentValues cv = new ContentValues();
      db.beginTransaction();
      db.insert(getTableName(weather.getClass()), null, weather.toContentValues(cv, weather));
      db.setTransactionSuccessful();
      db.endTransaction();
    }
  }

  public final T loadWeatherWraper(final Class<T> clazz) {
    final SQLiteDatabase db = this.getWritableDatabase();
    final Cursor cursor = db.query(getTableName(clazz), getProjection(clazz), null, null, null, null, null);
    try {
      cursor.moveToFirst();
      try {
        return (T) clazz.newInstance().fromCursor(cursor);
      } catch (final InstantiationException e) {
        e.printStackTrace();
      } catch (final IllegalAccessException e) {
        e.printStackTrace();
      }
    } finally {
      cursor.close();
    }
    return null;
  }
}
