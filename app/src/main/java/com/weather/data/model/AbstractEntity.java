package com.weather.data.model;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class AbstractEntity<T> {

  public abstract ContentValues toContentValues(ContentValues cv, final T weather);

  public abstract <T extends AbstractEntity> T fromCursor(Cursor cursor);
}
