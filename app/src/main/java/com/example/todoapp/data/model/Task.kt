package com.example.todoapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String,
    val dueDate: Date,
    val priority: Priority,
    val categoryId: Long,
    val isCompleted: Boolean = false,
    val createdAt: Date = Date()
)

enum class Priority {
    LOW, MEDIUM, HIGH
} 