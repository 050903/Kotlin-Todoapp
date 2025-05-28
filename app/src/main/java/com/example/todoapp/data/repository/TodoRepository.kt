package com.example.todoapp.data.repository

import com.example.todoapp.data.local.CategoryDao
import com.example.todoapp.data.local.TaskDao
import com.example.todoapp.data.model.Category
import com.example.todoapp.data.model.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoRepository @Inject constructor(
    private val taskDao: TaskDao,
    private val categoryDao: CategoryDao
) {
    // Task operations
    fun getAllTasks(): Flow<List<Task>> = taskDao.getAllTasks()
    fun getActiveTasks(): Flow<List<Task>> = taskDao.getActiveTasks()
    fun getCompletedTasks(): Flow<List<Task>> = taskDao.getCompletedTasks()
    fun getTasksByCategory(categoryId: Long): Flow<List<Task>> = taskDao.getTasksByCategory(categoryId)
    
    suspend fun insertTask(task: Task): Long = taskDao.insertTask(task)
    suspend fun updateTask(task: Task) = taskDao.updateTask(task)
    suspend fun deleteTask(task: Task) = taskDao.deleteTask(task)
    suspend fun updateTaskCompletion(taskId: Long, isCompleted: Boolean) = 
        taskDao.updateTaskCompletion(taskId, isCompleted)

    // Category operations
    fun getAllCategories(): Flow<List<Category>> = categoryDao.getAllCategories()
    suspend fun insertCategory(category: Category): Long = categoryDao.insertCategory(category)
    suspend fun updateCategory(category: Category) = categoryDao.updateCategory(category)
    suspend fun deleteCategory(category: Category) = categoryDao.deleteCategory(category)
    suspend fun getCategoryById(categoryId: Long): Category? = categoryDao.getCategoryById(categoryId)
} 