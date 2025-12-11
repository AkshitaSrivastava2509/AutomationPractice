# 🚀 E-commerce Test Automation Framework: AutomationPractice 🛒

A professional, enterprise-level Test Automation Framework for E-commerce testing, built using **Selenium WebDriver**, **Java**, **Cucumber BDD**, **TestNG**, **Page Object Model**, and **Extent Reports**.

---

## 🎯 1. Overview & Key Features

This is a **production-ready** test automation framework designed for E-commerce applications. Built with industry best practices, it provides:

* ✅ **Maintainable Architecture**: Implemented using the **Page Object Model (POM)** for high reusability.
* ✅ **Readable Scenarios**: Uses **Cucumber BDD** (Gherkin) for easily understandable, business-readable test specifications.
* ✅ **Scalable & Robust Design**: Suitable for enterprise-level test suites.
* ✅ **Comprehensive Reporting**: Generates rich **Extent Reports** with automatic **screenshots on failure**.
* ✅ **Flexible Configuration**: Easily configured for cross-browser (Chrome, Firefox, Edge) and multiple environments.
* ✅ **CI/CD Ready**: Seamless integration with continuous integration pipelines.

---

## 🌐 2. Application Under Test

* **Website URL**: [https://automationexercise.com/](https://automationexercise.com/)
* **Description**: A **full-featured E-commerce application** that includes user management, a product catalog, shopping cart, and checkout functionality.
* **Purpose**: Chosen because it is **publicly accessible** without authentication, contains **all standard E-commerce features**, and is **stable** for automation practice.

---

## 🛠 3. Technologies & Development Stack

| Technology | Version | Purpose |
| :--- | :--- | :--- |
| **Java** | 11+ | Primary **Programming Language** |
| **Selenium WebDriver** | 4.x | Core **Browser Automation** Library |
| **Cucumber** | 7.x | **BDD Framework** (Gherkin) |
| **TestNG** | 7.x | **Test Management** & Execution Engine |
| **Maven** | 3.6+ | **Build & Dependency Management** |
| **Extent Reports** | 5.x | **Rich HTML Test Reports** Generation |
| **WebDriverManager** | 5.x | **Automatic Driver Management** (No manual driver setup) |

---

## 📁 4. Project Structure (POM)

The project follows a standard, modular structure for clarity and maintainability:

![ProjectStructure](https://github.com/AkshitaSrivastava2509/AutomationPractice/blob/6e51530c5ec3f0c3a11f3e0700c983f54a838e7b/projectStructure.png)


## 🧪 5. Test Scenarios Covered

The framework covers a comprehensive set of E-commerce functionalities, segregated by feature:

### 5.1. User Management 👤

| Feature | Scenario Description | Status | Tags |
| :--- | :--- | :--- | :--- |
| **Signup** | New user registration with valid data | ✅ Implemented | `@signup, @smoke` |
| **Signup** | Validation for duplicate email submission | ✅ Implemented | `@signup, @negative` |
| **Login** | Successful login with valid credentials | ✅ Implemented | `@login, @smoke` |
| **Login** | Attempted login with invalid credentials | ✅ Implemented | `@login, @negative` |
| **Login** | Attempted login with blank credentials | ✅ Implemented | `@login, @negative` |

### 5.2. Shopping Cart Functionality 🛒

| Feature | Scenario Description | Status | Tags |
| :--- | :--- | :--- | :--- |
| **Cart** | Add a single product to the cart | ✅ Implemented | `@cart, @smoke` |
| **Cart** | Add multiple different products to cart | ✅ Implemented | `@cart, @regression` |
| **Cart** | Remove a product from the cart | 🔄 In Progress | `@cart, @regression` |
| **Cart** | Update an existing product's quantity | 🔄 In Progress | `@cart, @regression` |

### 5.3. Product Management & Search 🔍

| Feature | Scenario Description | Status | Tags |
| :--- | :--- | :--- | :--- |
| **Search** | Search for a specific product by name | 🔄 In Progress | `@search, @smoke` |
| **Search** | Searching with a query that yields no results | 🔄 In Progress | `@search, @negative` |
| **Filter** | Filter products based on category | 🔄 In Progress | `@filter, @regression` |
| **Filter** | Filter products within a specific price range | 🔄 In Progress | `@filter, @regression` |

**Legend:**
* **✅ Implemented**: Test scenario is fully implemented and running.
* **🔄 In Progress**: Scenario is planned or currently under development.

---

## ✨ 6. Framework Features Deep Dive

### 6.1. Current Features
* ✅ **Page Object Model (POM)**: Core principle for highly maintainable and reusable page classes.
* ✅ **BDD with Cucumber**: Enables collaborative and clear test design using the Gherkin syntax.
* ✅ **TestNG Integration**: Used for parallel execution, grouping, and powerful test management.
* ✅ **Extent Reports**: Generates professional, interactive HTML reports with execution metrics and pass/fail analysis.
* ✅ **Screenshot on Failure**: Automatically captures evidence for debugging when a test fails.
* ✅ **WebDriverManager**: Eliminates the need for manual browser driver installation or path setting.
* ✅ **Cross-Browser Support**: Easily switch between **Chrome**, **Firefox**, and **Edge** via configuration.
* ✅ **Configurable Framework**: All environment and application variables are externalized in a properties file.

---

## 📝 7. Best Practices Implemented

### 7.1. Code Quality Principles
* ✅ **Single Responsibility Principle (SRP)**: Each class and method has one, well-defined purpose.
* ✅ **DRY (Don't Repeat Yourself)**: Reusable methods and utilities are centralized.
* ✅ **Meaningful Naming**: Clear, descriptive naming conventions for variables, methods, and classes.
* ✅ **Code Documentation**: Adequate use of comments and Javadoc for clarity.

### 7.2. Test Design Excellence
* ✅ **Independent Scenarios**: Tests are atomic and can be run in any order without dependencies.
* ✅ **Reusable Steps**: Common actions are centralized in shared step definitions.
* ✅ **Page-Level Abstractions**: Logic is hidden within Page Objects for clean step definition files.
* ✅ **Data Separation**: Test data is not hardcoded and is externalized for flexibility.
* ✅ **Proper Assertions**: Uses strong, clear assertions to validate outcomes.

### 7.3. Framework Architecture
* ✅ **Modular Design**: The project is logically divided into independent packages (pages, factory, utils).
* ✅ **Configuration Management**: Uses a dedicated class to read and manage application settings.
* ✅ **Thread-Safe Implementation**: Uses **ThreadLocal** in `DriverFactory` for parallel test execution stability.
* ✅ **Resource Management**: Efficient handling of browser instances and test resources.
```

![ExtentReport](https://github.com/AkshitaSrivastava2509/AutomationPractice/blob/098c3636dc52405674c87fd3cfa635bd05736909/ExtentReport.png)


