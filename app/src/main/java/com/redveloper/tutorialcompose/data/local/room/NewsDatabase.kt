package com.redveloper.tutorialcompose.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.redveloper.tutorialcompose.data.local.entity.NewsEntity
import com.redveloper.tutorialcompose.data.local.room.dao.NewsDao

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao

    companion object {
        @Volatile
        private var instance: NewsDatabase? = null
        fun getInstance(context: Context): NewsDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java, "News.db"
                ).build()
            }
    }
}