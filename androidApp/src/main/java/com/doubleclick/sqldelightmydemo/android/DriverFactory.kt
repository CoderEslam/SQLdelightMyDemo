package com.doubleclick.sqldelightmydemo.android

import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.doubleclick.sqldelightmydemo.android.MyDB



/**
 * Created By Eslam Ghazy on 1/22/2023
 */

fun Context.createDriver(): SqlDriver {
    return AndroidSqliteDriver(
        schema = MyDB.Schema,
        context = this,
        name = "mydb.db",
        callback = object : AndroidSqliteDriver.Callback(MyDB.Schema) {
            override fun onConfigure(db: SupportSQLiteDatabase) {
                super.onConfigure(db)
                db.setForeignKeyConstraintsEnabled(true)
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        })
}
