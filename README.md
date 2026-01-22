# CMPUT 301 : Lab 3 Participation Exercise

## Student Information

- **Name:** Ibrahim  
- **CCID:** ibrahi10  
- **Student ID:** 1868521  

---

## Lab Description

This lab focuses on customizing a `ListView` using a custom layout and adapter, and using a `DialogFragment` to allow users to add and edit cities dynamically. Each city entry displays both the city name and its province. The application also supports deleting selected cities and provides a clean, user-friendly interface.

---

## Repository Structure and File Overview

### 📁 Java Source Files  
`app/src/main/java/com/example/listycity/`

| File | Description |
|------|-------------|
| **MainActivity.java** | The main activity of the application. Initializes the `ListView` and adapter, manages the list of `City` objects, and handles adding, editing, and deleting cities as well as the empty-state UI. |
| **City.java** | Model class representing a city. Stores the city name and province, and tracks selection state for deletion. |
| **CityArrayAdapter.java** | Custom `ArrayAdapter<City>` used to display city data in the `ListView`. Inflates the custom row layout (`content.xml`) and binds city and province data to each list item. |
| **AddCityFragment.java** | A `DialogFragment` used for both adding and editing cities. Displays input fields for city name and province and communicates user input back to `MainActivity`. |
| **WelcomeActivity.java** | A simple welcome screen displayed when the application launches, providing an entry point into the main application. |

---

### 📁 Layout Files  
`app/src/main/res/layout/`

| File | Description |
|------|-------------|
| **activity_main.xml** | Defines the main user interface layout, including the toolbar, `ListView`, delete button, and floating action button. |
| **content.xml** | Custom layout for each row in the `ListView`. Displays the city name and province side by side and includes a checkbox for selecting cities to delete. |
| **fragment_add_city.xml** | Layout for the add/edit city dialog, containing input fields for city name and province. |
| **activity_welcome.xml** | Layout for the welcome screen shown on application startup. |

---

### 📁 Configuration and Support Files

| File | Description |
|------|-------------|
| **AndroidManifest.xml** | Declares application components, activities, and application configuration. |
| **gradle/libs.versions.toml** | Manages dependency versions used throughout the project. |

---

### 🧠 Component Interaction Overview

- `MainActivity` manages application logic and state  
- `CityArrayAdapter` controls how city data is displayed  
- `AddCityFragment` collects user input for adding/editing cities  
- `City` represents the data model  

---

## References and Resources

- CMPUT 301 Lab 3 instructions (eClass)  
- Android Developer Documentation  
  - ListView  
  - ArrayAdapter  
  - DialogFragment  
  - Material Components  

---

## Verbal Collaboration

| Student Name | CCID     |
|--------------|----------|
| Ibrahim      | ibrahi10 |

---

## Notes

All work in this repository was completed independently as part of the CMPUT 301 Lab 3 requirements. The implementation follows the lab instructions while maintaining clean code structure and a professional user interface.
