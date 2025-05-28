package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.model.Category
import com.example.todoapp.data.model.Priority
import com.example.todoapp.data.model.Task
import com.example.todoapp.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TodoUiState())
    val uiState: StateFlow<TodoUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            combine(
                repository.getAllTasks(),
                repository.getAllCategories()
            ) { tasks, categories ->
                _uiState.value = _uiState.value.copy(
                    tasks = tasks,
                    categories = categories
                )
            }.collect()
        }
    }

    fun addTask(
        title: String,
        description: String,
        dueDate: Date,
        priority: Priority,
        categoryId: Long
    ) {
        viewModelScope.launch {
            val task = Task(
                title = title,
                description = description,
                dueDate = dueDate,
                priority = priority,
                categoryId = categoryId
            )
            repository.insertTask(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.updateTask(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTask(task)
        }
    }

    fun toggleTaskCompletion(taskId: Long, isCompleted: Boolean) {
        viewModelScope.launch {
            repository.updateTaskCompletion(taskId, isCompleted)
        }
    }

    fun addCategory(name: String, color: Int) {
        viewModelScope.launch {
            val category = Category(name = name, color = color)
            repository.insertCategory(category)
        }
    }

    fun updateCategory(category: Category) {
        viewModelScope.launch {
            repository.updateCategory(category)
        }
    }

    fun deleteCategory(category: Category) {
        viewModelScope.launch {
            repository.deleteCategory(category)
        }
    }

    fun filterTasks(showCompleted: Boolean) {
        viewModelScope.launch {
            val tasks = if (showCompleted) {
                repository.getCompletedTasks().first()
            } else {
                repository.getActiveTasks().first()
            }
            _uiState.value = _uiState.value.copy(
                tasks = tasks,
                showCompletedTasks = showCompleted
            )
        }
    }
}

data class TodoUiState(
    val tasks: List<Task> = emptyList(),
    val categories: List<Category> = emptyList(),
    val showCompletedTasks: Boolean = false,
    val selectedCategory: Category? = null
) 