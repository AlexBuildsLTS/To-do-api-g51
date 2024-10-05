# G51 Todo API

This project is a simple task management system for managing users, tasks, and roles using Spring Boot and MariaDB.

## Features

- Create and manage users.
- Assign tasks to users.
- Mark tasks as done.
- Relationships between entities:
    - Users and Roles (many-to-many)
    - Persons and Tasks (one-to-many)

## Tech Stack

- **Backend**: Java, Spring Boot, JPA (Java Persistence API)
- **Database**: MariaDB
- **Build Tool**: Maven
- **Dependencies**:
    - Spring Boot Starter Web
    - Spring Boot Starter Data JPA
    - Lombok
    - MariaDB Connector
    - H2 (for testing)

## Project Structure

- `Entity` layer: Defines the domain models (`Task`, `Person`, `User`, `Role`).
- `Repository` layer: Interfaces for interacting with the database.
- `Service` layer: Business logic and interaction with repositories.
- `Controller` layer: API endpoints.

## 

