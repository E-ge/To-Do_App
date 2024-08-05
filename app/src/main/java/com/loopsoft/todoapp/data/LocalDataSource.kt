package com.loopsoft.todoapp.data

import com.loopsoft.todoapp.model.TodoModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val todoDao: TodoDao
) {

    fun getAllTodo():Flow<List<TodoModel>>{
        return todoDao.getAllTodo()
    }
    fun searchTodo(searchQuery :String):Flow<List<TodoModel>>{
        return todoDao.searchTodo(searchQuery)
    }
    suspend fun insertTodo(todoModel: TodoModel){
        todoDao.insertTodo(todoModel)
    }
    suspend fun getTodo(todoId :Int) :TodoModel{
        return todoDao.getTodo(todoId)
    }
    suspend fun updateTodo(todoModel: TodoModel){
        todoDao.updateTodo(todoModel)
    }
    suspend fun deletTodo(todoModel: TodoModel){
        todoDao.deleteTodo(todoModel)
    }
}