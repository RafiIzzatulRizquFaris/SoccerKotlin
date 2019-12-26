package com.example.submission3kotlin

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.submission3kotlin.model.Favorite
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper(context: Context): ManagedSQLiteOpenHelper(context, "MyFavoriteDB.db", null, 1){

    companion object{
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(context: Context): MyDatabaseOpenHelper{
            if (instance == null){
                instance = MyDatabaseOpenHelper(context.applicationContext)
            }
            return instance as MyDatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
            Favorite.TABLE_NAME, true,
            Favorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            Favorite.ID_EVENT to TEXT + UNIQUE,
            Favorite.STR_HOME to TEXT,
            Favorite.STR_AWAY to TEXT,
            Favorite.SCORE_HOME to TEXT,
            Favorite.SCORE_AWAY to TEXT,
            Favorite.IMG_HOME to TEXT,
            Favorite.IMG_AWAY to TEXT,
            Favorite.DATE_EVENT to TEXT
            )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(Favorite.TABLE_NAME, true)
    }
}


val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)