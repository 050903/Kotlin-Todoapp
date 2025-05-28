# Kotlin-Todoapp
Todo App project, its features, and how to run it.
# DEMO
![image](https://github.com/user-attachments/assets/d07bc245-0656-42af-af7e-c0b9033f8ac9)
![image](https://github.com/user-attachments/assets/60a9d335-33ee-4b82-9f56-de8cbdd1d4bb)
![image](https://github.com/user-attachments/assets/a48dfe1a-bba3-4c32-9313-5668028e5f11)
![image](https://github.com/user-attachments/assets/7abb3d30-e7a5-4a94-85ae-cb6f5619c1ff)
![image](https://github.com/user-attachments/assets/3b66e68a-dc3c-4941-b2aa-eb91ddc15c11)
![image](https://github.com/user-attachments/assets/d0a3e428-0069-44f5-8db4-0c4a2accfeeb)
![image](https://github.com/user-attachments/assets/e8f22575-ef81-4f1a-b243-fe6435d5e02b)
![image](https://github.com/user-attachments/assets/98a0f637-d624-4cc5-9d05-cf6ffa26dbd8)

# Todo App Project Description

## Overview
This is a modern Android Todo application built using:
- Kotlin as the primary programming language
- Jetpack Compose for the UI
- MVVM (Model-View-ViewModel) architecture
- Room Database for local storage
- Hilt for dependency injection
- Material3 design system

## Features
1. **Welcome Screen**
   - Initial screen for new users
   - Smooth transition to the main app

2. **Home Dashboard**
   - Overview of tasks and categories
   - Quick access to main features
   - Navigation to other screens

3. **Task Management**
   - Create, read, update, and delete tasks
   - Set task priorities (High, Medium, Low)
   - Mark tasks as complete/incomplete
   - Filter tasks by status and priority

4. **Category Management**
   - Create and manage task categories
   - Organize tasks by categories
   - Color-coded categories for better visualization

5. **Settings**
   - App preferences
   - Theme customization
   - User preferences

## Technical Architecture
1. **Data Layer**
   - `Task` and `Category` entities
   - Room Database for local storage
   - DAOs for database operations
   - Repository pattern implementation

2. **Domain Layer**
   - Repository interfaces
   - Use cases (if needed)
   - Business logic

3. **Presentation Layer**
   - ViewModels for state management
   - Composable UI components
   - Navigation using Jetpack Navigation Compose

## Project Structure
```
app/
├── data/
│   ├── local/          # Room database and DAOs
│   ├── model/          # Data entities
│   └── repository/     # Repository implementations
├── di/                 # Dependency injection modules
├── ui/
│   ├── navigation/     # Navigation components
│   ├── screens/        # Screen composables
│   ├── theme/          # App theme and styling
│   └── viewmodel/      # ViewModels
└── TodoApplication.kt  # Application class
```

## How to Run the Project

### Prerequisites
1. Android Studio (latest version)
2. JDK 17 or higher
3. Android SDK with API level 35 (Android 15)
4. Gradle 8.0 or higher

### Steps to Run
1. **Clone the Project**
   ```bash
   git clone [repository-url]
   cd todoapp
   ```

2. **Open in Android Studio**
   - Open Android Studio
   - Select "Open an existing project"
   - Navigate to the project directory and select it

3. **Sync Project**
   - Wait for the initial Gradle sync to complete
   - If prompted, update any dependencies

4. **Build the Project**
   - Click on "Build > Make Project" or press Ctrl+F9
   - Wait for the build to complete

5. **Run the App**
   - Connect an Android device or start an emulator
   - Click on "Run > Run 'app'" or press Shift+F10
   - Select your target device
   - Wait for the app to install and launch

### Development Setup
1. **Enable Developer Options**
   - On your Android device, go to Settings > About Phone
   - Tap "Build Number" 7 times to enable developer options
   - Go back to Settings > System > Developer Options
   - Enable "USB Debugging"

2. **Connect Device**
   - Connect your Android device via USB
   - Accept the debugging authorization prompt on your device

3. **Run in Debug Mode**
   - In Android Studio, click on "Run > Debug 'app'"
   - The app will install in debug mode
   - You can set breakpoints and debug the application

## Testing
1. **Unit Tests**
   - Run tests using Android Studio's test runner
   - Tests are located in the `test` directory

2. **UI Tests**
   - Run UI tests using Android Studio's test runner
   - Tests are located in the `androidTest` directory

## Common Issues and Solutions
1. **Build Errors**
   - Clean and rebuild the project
   - Invalidate caches and restart Android Studio
   - Update Gradle and dependencies

2. **Runtime Errors**
   - Check logcat for detailed error messages
   - Ensure all required permissions are granted
   - Verify database migrations if any

3. **UI Issues**
   - Check Material3 theme implementation
   - Verify composable function parameters
   - Ensure proper state management

## Contributing
1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License



