package com.loopsoft.todoapp.di

import android.content.Context
import androidx.room.Room
import com.loopsoft.todoapp.data.AppDatabase
import com.loopsoft.todoapp.utilities.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, AppDatabase::class.java, DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideAppDatabase(database: AppDatabase) = database.todoDao()

}