# Login and Registration Page

## Introduction

This repository contains Java code for a simple user authentication system with a graphical user interface (GUI). The system consists of three main components: 

1. **LoginFormGui**: This class represents the GUI for user login. Users enter their username and password, and the system validates their credentials against a database.

2. **RegisterFormGUI**: This class provides the GUI for user registration. Users can create a new account by entering a unique username and password. The system checks for username availability and registers the user if valid.

3. **WelcomePage**: After successful login, users are redirected to a welcome page displaying a personalized greeting, date and time information, and a randomly generated programming-related quote. Users have the option to re-generate quotes or exit the application.

## Instructions

### LoginFormGui

To use the login functionality:

1. Enter a valid username and password.
2. Click the "Login" button.
3. If the credentials are valid, a success message will appear, and the user will be directed to the WelcomePage.
4. If the login fails, an error message will prompt the user to register or try again.

### RegisterFormGUI

To register a new account:

1. Enter a unique username.
2. Enter a password and re-enter it for confirmation.
3. Click the "Register" button.
4. If registration is successful, a message will be displayed, and the user will be directed to the login page.
5. If registration fails, an error message will be shown.

### WelcomePage

Upon successful login, the WelcomePage displays a personalized welcome message, current date and time, and a programming-related quote. Users can re-generate quotes or exit the application using the respective buttons.

## Dependencies

The code relies on the following dependencies:

- **Java Swing**: The GUI components are built using the Java Swing library.
- **JDBC**: Java Database Connectivity is used for database interactions.
- **Random Class**: Utilized for generating random quotes.

Ensure that these dependencies are available in your Java development environment.

## Database Configuration

The application assumes the existence of a database and utilizes the `MyJDBC` class for database operations. Update the database configurations in the `MyJDBC` class based on your environment.

## Usage

1. Clone or download the repository to your local machine.
2. Open the project in a Java development environment (IDE) such as Visual Studio Code or Eclipse or IntelliJ.
3. Configure the database settings in the `MyJDBC` class.
4. Run the application using `AppLauncher.java` class and use the provided GUI to login, register, and explore the welcome page.

## Note

- This is a simple authentication system and does not include advanced security features. It is recommended to implement secure password hashing and additional security measures for a production environment.

Feel free to explore and modify the code as needed for your specific requirements. If you encounter any issues or have suggestions for improvement, please feel free to contribute or reach out to the repository owner.