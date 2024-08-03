package com.loopsoft.todoapp.model

import android.webkit.WebSettings.RenderPriority
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.chrono.IsoEra

@Entity(tableName = "base_table")
data class TodoModel (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val title : String?,
    val description : String?,
    val priority : Priority?,
    val isChecked : Boolean?
)