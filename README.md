# 🎓 Specialite Management System

A complete **Java EE CRUD web application** for managing academic specialties, built with a clean bean-based MVC architecture using core JEE technologies.

## 🏗️ Architecture

```
TP3JSP/
├── src/
│   └── main/
│       ├── java/
│       │   ├── beans/           # Model layer
│       │   │   └── Specialite.java
│       │   ├── dao/             # Data Access layer
│       │   │   └── SpecialiteDao.java
│       │   ├── service/         # Business Logic layer
│       │   │   └── SpecialiteService.java
│       │   └── controller/      # Controller layer
│       │       └── SpecialiteServlet.java
│       └── webapp/
│           ├── views/           # View layer
│           │   ├── index.jsp
│           │   ├── form.jsp
│           │   └── edit.jsp
│           └── WEB-INF/
│               └── web.xml
└── pom.xml
```

## 🛠️ Technologies Used

- **Backend:** Java Servlets, JDBC
- **Frontend:** JSP (No JSTL - Pure JSP)
- **Database:** MySQL
- **Build Tool:** Maven
- **Server:** Tomcat 10
- **Architecture:** MVC Pattern with Bean Models

## 📋 Features

- ✅ **List all specialties** - Dynamic display from database
- ✅ **Add new specialty** - Form-based creation
- ✅ **Edit specialty** - Pre-filled form for updates
- ✅ **Delete specialty** - With confirmation dialog
- ✅ **Clean MVC architecture** - Separation of concerns
- ✅ **Bean-based models** - Proper object modeling

## 🗃️ Database Setup

```sql
CREATE DATABASE tp_specialite;
USE tp_specialite;

CREATE TABLE specialite (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    description TEXT
);

INSERT INTO specialite (nom, description) VALUES 
('SDBDIA', 'Sciences des Données, Big Data et Intelligence Artificielle'),
('SITCN', 'Sécurité IT et Confiance Numérique');
```

## 🚀 Installation & Deployment

1. **Clone the repository**
   ```bash
   git clone https://github.com/abderrahmanBouanani/JEE-CRUD-Specialites---Web-App-with-JSP-Servlets-JDBC.git
   ```

2. **Configure database connection**
   - Update `url`, `user`, and `pass` in `SpecialiteDao.java`

3. **Build with Maven**
   ```bash
   mvn clean package
   ```

4. **Deploy to Tomcat**
   - Copy generated `.war` file to Tomcat's `webapps` directory

5. **Access the application**
   ```
   http://localhost:8080/TP3JSP/specialite
   ```

## 📝 Project Structure Details

- **beans.Specialite** - Model class with getters/setters
- **dao.SpecialiteDao** - JDBC operations and database access
- **service.SpecialiteService** - Business logic layer
- **controller.SpecialiteServlet** - HTTP request handling
- **views/** - JSP pages for user interface

## 🎯 Academic Purpose

This project was developed as part of a university course to demonstrate:
- Java EE web development fundamentals
- MVC architecture implementation
- CRUD operations with JDBC
- Servlet and JSP programming
- Proper separation of concerns

## 👨‍💻 Development Notes

- No external frameworks used (pure JEE)
- Simple HTML design without CSS frameworks
- No JavaScript required for basic functionality
- Bean-based model layer for clean architecture

## 📞 Support

For any issues or questions regarding this project, please open an issue in the GitHub repository.

---

**Developed as part of JEE Course - ENSA Agadir** 🎓
