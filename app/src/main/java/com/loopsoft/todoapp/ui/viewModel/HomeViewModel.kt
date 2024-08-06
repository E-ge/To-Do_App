package com.loopsoft.todoapp.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.loopsoft.todoapp.model.Priority
import com.loopsoft.todoapp.model.TodoModel
import com.loopsoft.todoapp.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application, private val repository: Repository
): AndroidViewModel(application) {

    val todoList = repository.localDataSource.getAllTodo().asLiveData()

    fun insertTodo(){
        viewModelScope.launch {
            repository.localDataSource.insertTodo(TodoModel(title = "deneme", description =  "deneme", priority = Priority.LOW, isChecked = true))
        }
    }
}