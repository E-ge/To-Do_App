package com.loopsoft.todoapp.repo

import com.loopsoft.todoapp.data.LocalDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(localDataSource: LocalDataSource) {
    val localDataSource = localDataSource
}