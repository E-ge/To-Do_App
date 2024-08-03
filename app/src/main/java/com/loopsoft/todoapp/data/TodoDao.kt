package com.loopsoft.todoapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.loopsoft.todoapp.model.TodoModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("Select * from base_table")
    fun getAllTodo(): Flow<List<TodoModel>>

    @Query("Select * from base_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchTodo(searchQuery: String) : Flow<List<TodoModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todoModel: TodoModel)

    @Update
    suspend fun updateTodo(todoModel: TodoModel)

    @Query("SELECT * from base_table WHERE id=:todoId")
    suspend fun getTodo(todoId : Int) :TodoModel

    @Delete
    suspend fun deleteTodo(todoModel: TodoModel)
}