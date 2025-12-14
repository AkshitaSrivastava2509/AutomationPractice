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

## 📁 4. Project Structure (POM) And Extent Report

The project follows a standard, modular structure for clarity and maintainability:

![ProjectStructure](https://github.com/AkshitaSrivastava2509/AutomationPractice/blob/6e51530c5ec3f0c3a11f3e0700c983f54a838e7b/projectStructure.png)

## Extent Report
![Report](https://github.com/AkshitaSrivastava2509/AutomationPractice/blob/9a975aa52f0afc4ed4be3011d59b14845cda89fb/test-report/ExtentReport.png)


## 🧪 5. ✅ Test Scenarios Covered
## 🔐 Authentication & User Management

1. User Signup with Existing Email Validation
2. User Login with Valid and Invalid Credentials
3. Delete Account & Validate Redirection

## 🛒 Cart & Product Management

1. Add Products to Cart and Verify Cart Persistence
2. Remove Product from Cart
3. Product Search, Add to Cart, and Verify Quantity

## 💳 Checkout & Order Placement

1. Place an Order — Register While Checkout (End-to-End Flow)
2. Place an Order — Login Before Checkout5. Test Scenarios Covered


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
