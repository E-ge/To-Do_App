package com.loopsoft.todoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.loopsoft.todoapp.model.TodoModel

@Database(entities = [TodoModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao
}