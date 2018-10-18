package com.luczak.m.coreapp.database;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = Db.NAME, version = Db.VERSION)
public class Db {
    public static final String NAME = "Db";
    public static final int VERSION = 1;
}
