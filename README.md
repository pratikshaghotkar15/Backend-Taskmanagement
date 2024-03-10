# Task Management System in JAVA
This is a simple Task Management System project implemented using Java and MySQL. It allows users to perform CRUD (Create, Read, Update, Delete) operations on task data such as task title, description , status, duedate, craetedby. it also save user data for registration and login process.



# Features
* save user 
* validate user by email and pwd and login user in task manangement dashboard.
* Add a new Task
* View all Tasks
* Update Task
* search task based on description, status, duedate, title.
* delete task.
* change status of task 



# Requirements
* Java 17.
* MySQL Server.

# Installation
1. Clone the repository
```bash
[git clone https://github.com/pratikshaghotkar15/Backend-Taskmanagement.git
]
```
2. then add project folder in STS IDE .
3. Change application.properties file , and provide username, password, url, driver class name
4. run project as springboot app
5. I have added swagger documentattion dependency so we can test our api's on http://localhost:9091/swagger-ui/index.html
6. or simple test apis working or not on http://localhost:9091
    

# Usage
* Launch the application
* Register to the system and then Login
* Select the desired operation from the side bar like create task, update task, delete task,change status of task,search task.

# Database Columns
The database table used in this project has thw two tables 
1. users: it saves user data ,like name,email,pwd,dob,gender(one user can have many tasks)
2. tasks: it save tasks data like title,description,status,etc,also id of user (task created by user)







