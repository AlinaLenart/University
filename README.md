# University Management System
**Language:** Java
**Purpose:** Final project for object-oriented programming course

### Project Overview
The **University Management System** is a Java-based application designed to manage a university's core entities such as students, employees, and courses. It demonstrates advanced Java programming techniques, including:
- Object-oriented design with inheritance and abstract classes
- Polymorphism and interfaces
- Design patterns: Strategy and Observer
- Use of data structures like ArrayList, HashSet, and comparators
- Serialization and file operations
- A graphical user interface (GUI) separating the presentation layer from data processing
  
This project fulfills requirements across multiple stages, incorporating structural programming, menu-driven console interaction, and a GUI.

### Features
#### Core Functionality
- **Data Management:** Add, edit, remove, and search for:
  - Employees (Academic and Administrative)
  - Students
  - Courses
- **Search Options:**
  - Employees: By name, job title, work experience, salary, or overtime hours
  - Students: By name, index number, study year, or courses enrolled
  - Courses: By course name, instructor, or ECTS points
- **Display Options:**
  - View all employees, students, or courses
  - Filtered lists based on search criteria

#### Extended Functionality
- **Serialization:** Save and load the database to/from a file using object serialization
- **Sorting:** 
  - ```Employees and Students```: Sort by name, name and age, or name and surname
  - ```Courses```: Sort by ECTS points and instructor name
- **Duplicate Removal:** Automatically remove duplicate entries using HashSet
- **GUI:** A user-friendly interface for all operations, separating presentation and data layers
  
### Technical Details
#### Class Hierarchy
1. Abstract Classes:
  - ```Person```: Base class with common attributes like name, PESEL, age, and gender
  - ```UniversityEmployee```: Extends Person, adds job-specific attributes
2. Derived Classes:
  - AcademicEmployee: Includes position (e.g., Lecturer, Professor) and publications count
  - AdministrativeEmployee: Includes overtime hours and job specialization
3. ```Student```:
  - Attributes: Index number, study year, courses list, and program type (e.g., Erasmus, full-time)
4. ```Course```:
  - Attributes: Course name, instructor, and ECTS points
    
### Design Patterns
**Strategy:** Implements customizable sorting strategies for lists
**Observer:** Updates the GUI or logs events dynamically as changes occur

### Data Structures
- ```ArrayList``` for storing ```Person``` and ```Course``` objects
- ```HashSet``` for managing duplicates


### Screenshots
<img width="834" alt="Screenshot 2024-12-12 at 20 20 00" src="https://github.com/user-attachments/assets/c7cabf9c-7f0c-46ed-9152-45b0d3610f87" />

<img width="476" alt="Screenshot 2024-12-12 at 20 21 09" src="https://github.com/user-attachments/assets/c0cf2440-c47d-4997-8af5-a4b6aa71e614" />

<img width="1004" alt="Screenshot 2024-12-12 at 20 22 15" src="https://github.com/user-attachments/assets/66be0b62-c795-4e73-b401-bebdc19a93cd" />

<img width="991" alt="Screenshot 2024-12-12 at 20 23 35" src="https://github.com/user-attachments/assets/2d26f663-2dbe-4eae-9007-4db37c56c2ec" />

<img width="1195" alt="Screenshot 2024-12-12 at 20 23 54" src="https://github.com/user-attachments/assets/b9bc636a-5132-41a5-933d-ff54426fe9cd" />

