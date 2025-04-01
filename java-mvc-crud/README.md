# Java MVC CRUD Project

This project implements a simple Java MVC (Model-View-Controller) application that provides CRUD (Create, Read, Update, Delete) functionality for managing blocks in a MySQL database.

## Project Structure

```
java-mvc-crud
├── src
│   ├── controllers
│   │   └── BlockController.java
│   ├── models
│   │   └── Block.java
│   ├── views
│   │   ├── CreateBlockView.java
│   │   ├── ReadBlockView.java
│   │   ├── UpdateBlockView.java
│   │   └── DeleteBlockView.java
│   ├── utils
│   │   └── DatabaseConnection.java
│   └── Main.java
├── lib
│   └── mysql-connector-java.jar
├── .gitignore
└── README.md
```

## Requirements
- MySQL Database
## Setup Instructions

2. **Set up MySQL Database**:
   - Create a database and a table named `blocks` with the following structure:
     ```sql
     CREATE TABLE blocks (
         id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(255) NULL,
         createdAt DATETIME NULL,
         statusId INT DEFAULT 1
     );
     ```

3. **Add MySQL Connector**:
   - Place the `mysql-connector-java.jar` file in the `lib` directory.


## Usage

- The application provides a menu for users to create, read, update, and delete blocks.
- Follow the prompts in the console to interact with the application.