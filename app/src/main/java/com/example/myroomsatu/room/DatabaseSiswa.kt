package com.example.myroomsatu.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Siswa::class],
    version = 1,
    exportSchema = false
)
abstract class DatabaseSiswa : RoomDatabase() {

    abstract fun siswaDao(): SiswaDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseSiswa? = null

        fun getDatabase(context: Context): DatabaseSiswa {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseSiswa::class.java,
                    "db_siswa"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}