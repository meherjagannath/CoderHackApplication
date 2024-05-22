# CoderHackApplication
UserServiceApp is a Spring Boot application designed to manage user data efficiently. The application provides a set of RESTful APIs for performing CRUD operations, including user registration, retrieval, updating scores, and deregistration. It includes features like sorting users by score and handling user badges with JSON

# UserServiceApp

This is a Spring Boot application that provides a user service with CRUD operations.

## Features

- Get all users
- Get a user by ID
- Register a new user
- Update user score
- Deregister a user

## Endpoints

### Get All Users
GET /users/allUsers
### Get User by ID
GET /users/ByUserId/{userId}
### Register a New User
###Deregister a User
POST /users/newUser
###Update user score
PUT /users/{userId}?score=75
###Deregister a User
DELETE /users/deleteByUserId/{userId}

