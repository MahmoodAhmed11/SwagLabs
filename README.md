SwagLabs Automation Testing Project

Automation Testing Framework using Java + Selenium + TestNG + POM

📌 Overview

This project is an automation testing framework for the SwagLabs web application.
It covers End-to-End, Integration, and Functional test scenarios using different types of users provided by the application.

The framework is designed using the Page Object Model (POM) to ensure clean code, scalability, and reusability.

🚀 Tools & Technologies

Java (JDK 17+)

Selenium WebDriver

TestNG

Maven

Page Object Model (POM)

Git/GitHub

📂 Project Structure
src/
 └── test/java/
      ├── pages/          # Page classes (POM)
      ├── tests/          # TestNG test classes
      ├── utils/          # Helper & reusable methods
      └── drivers/        # Driver setup (ChromeDriver)

🔥 Automation Scope
✔ Functional Tests

Login functionality

Add/Remove items from cart

Product details

Sorting (A→Z, Z→A, price low/high)

Cart badge and cart page validation

✔ End-to-End Scenarios

Login → Products → Cart → Checkout → Finish

✔ Integration Level Testing

Navigation between pages

Reset app state

Menu options

✔ Multi-User Testing

The project covers test execution for all users provided by SwagLabs:

User Type	Covered Scenarios
Standard User	Login, Cart, Checkout
Error User	Negative scenarios, broken elements
Problem User	UI validation
Visual User	Layout & visual checks
Performance User	Heavy load behavior
🏗 Framework Features

Page Object Model (POM)

Reusable helper actions

Independent test execution

TestNG (Priorities, Groups, Assertions)

Clean and maintainable code structure
