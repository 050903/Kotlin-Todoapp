package com.example.todoapp.ui.screens.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todoapp.ui.viewmodel.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onNavigateBack: () -> Unit,
    viewModel: TodoViewModel = hiltViewModel()
) {
    var showResetConfirmationDialog by remember { mutableStateOf(false) }
    var showBackupDialog by remember { mutableStateOf(false) }
    var showRestoreDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Data Management Section
            Text(
                text = "Data Management",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            
            SettingsItem(
                icon = Icons.Default.Backup,
                title = "Backup Data",
                description = "Create a backup of your tasks and categories",
                onClick = { showBackupDialog = true }
            )
            
            SettingsItem(
                icon = Icons.Default.Restore,
                title = "Restore Data",
                description = "Restore from a previous backup",
                onClick = { showRestoreDialog = true }
            )
            
            Divider(modifier = Modifier.padding(vertical = 16.dp))
            
            // Danger Zone Section
            Text(
                text = "Danger Zone",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.error
            )
            
            SettingsItem(
                icon = Icons.Default.Delete,
                title = "Reset App Data",
                description = "Delete all tasks and categories",
                onClick = { showResetConfirmationDialog = true },
                iconTint = MaterialTheme.colorScheme.error
            )
        }

        if (showResetConfirmationDialog) {
            AlertDialog(
                onDismissRequest = { showResetConfirmationDialog = false },
                title = { Text("Reset App Data") },
                text = { Text("Are you sure you want to delete all tasks and categories? This action cannot be undone.") },
                confirmButton = {
                    TextButton(
                        onClick = {
                            // TODO: Implement reset functionality
                            showResetConfirmationDialog = false
                        }
                    ) {
                        Text("Reset", color = MaterialTheme.colorScheme.error)
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showResetConfirmationDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }

        if (showBackupDialog) {
            AlertDialog(
                onDismissRequest = { showBackupDialog = false },
                title = { Text("Backup Data") },
                text = { Text("Backup functionality will be implemented in a future update.") },
                confirmButton = {
                    TextButton(onClick = { showBackupDialog = false }) {
                        Text("OK")
                    }
                }
            )
        }

        if (showRestoreDialog) {
            AlertDialog(
                onDismissRequest = { showRestoreDialog = false },
                title = { Text("Restore Data") },
                text = { Text("Restore functionality will be implemented in a future update.") },
                confirmButton = {
                    TextButton(onClick = { showRestoreDialog = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}

@Composable
fun SettingsItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    description: String,
    onClick: () -> Unit,
    iconTint: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.primary
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier.size(24.dp)
            )
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
} 