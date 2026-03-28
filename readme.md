
# 🧠 Low Level Design (LLD) - System Design Practice

This repository contains implementations of popular Low-Level Design (LLD) problems inspired by real-world systems.

The goal of this repo is to build strong problem-solving skills in system design using clean architecture, Object-Oriented Programming (OOP), and design patterns.


***************************************
---

## 🚀 What You'll Find Here

- Real-world system design problems
- Clean and modular code (Java + C++)
- Use of industry-standard design patterns
- Scalable and extensible architecture
- UML diagrams for better understanding


***************************************
---

## 📂 Implemented Systems

|       System               |          Description             |
|       -------              |              ------------        |
|1- 📄 Google Docs Editor   |   Document editor with formatting, undo/redo,   autosave, PDF export |
|2- 📄  ...  | ...   |

*(More systems will be added soon)*

***************************************
---

## 🧠 Concepts Covered

- Abstraction
- Encapsulation
- Inheritance
- Polymorphism
- Composition

***************************************
---

## 🎯 Design Patterns Used

- Command Pattern → Undo/Redo functionality
- Strategy Pattern → Storage systems (File, PDF)
- Open/Closed Principle → Easy extensibility
- Single Responsibility Principle → Clean separation of logic


***************************************
---

## 🔄 General Design Approach

Most systems in this repository follow a structured design:
```
User → Controller → Command → Core Model → Render → Storage
```

This ensures:
- Loose coupling
- High cohesion
- Easy scalability


***************************************
---

## 🛠️ Tech Stack

- Java (Primary for system design)
- C++ (For DSA and alternative implementations)


***************************************
---

## 📌 Folder Structure

low-level-design/
├── google-doc-editor/
│ ├── README.md
│ ├── java/
│ ├── cpp/
│ ├── diagram.png
│
├── parking-lot/ (coming soon)
├── splitwise/ (coming soon)
├── book-my-show/ (coming soon)


***************************************
---



## 🔥 Learning Goals

- Master Low-Level Design for interviews
- Understand real-world system architecture
- Improve code quality and design thinking
- Prepare for product-based companies


***************************************
---

## 🚀 Future Additions

- Parking Lot System
- Splitwise System
- BookMyShow System
- Cache Design (LRU/LFU)
- Rate Limiter
- Elevator System



---
***************************************

## Miscellaneous : 

## 🧠 SOLID Principles (Core Design Guidelines)

SOLID principles help in writing clean, maintainable, and scalable object-oriented code.

### 1. Single Responsibility Principle (SRP)
A class should have only one responsibility.

**Why?**
- Easier to maintain and debug

**Tip:**
If a class has multiple reasons to change → split it.

---

### 2. Open/Closed Principle (OCP)
Software entities should be open for extension, but closed for modification.

**Why?**
- Avoid breaking existing code

**Tip:**
Use interfaces/abstract classes to extend behavior.

---

### 3. Liskov Substitution Principle (LSP)
Derived classes must be replaceable with base classes.

**Why?**
- Ensures correct inheritance

**Tip:**
Child class should not break expected behavior of parent.

---

### 4. Interface Segregation Principle (ISP)
Clients should not be forced to depend on methods they do not use.

**Why?**
- Avoid unnecessary implementation

**Tip:**
Create small, focused interfaces instead of large ones.

---

### 5. Dependency Inversion Principle (DIP)
Depend on abstractions, not concrete implementations.

**Why?**
- Improves flexibility and testability

**Tip:**
Use interfaces + dependency injection.


***************************************
---

## 🎯 Design Patterns (Theory + Usage)

Design patterns are reusable solutions to common software design problems.

---

### 1. Creational Patterns (Object Creation)

#### Factory Pattern
Creates objects without exposing creation logic.

**Use When:**
- Object creation is complex or varies

---

#### Singleton Pattern
Ensures only one instance exists.

**Use When:**
- Shared resources (Logger, Config)

---

### 2. Structural Patterns (Class Relationships)

#### Adapter Pattern
Converts one interface into another.

**Use When:**
- Integrating incompatible systems

---

#### Decorator Pattern
Adds behavior dynamically.

**Use When:**
- Extending functionality without modifying class

---

### 3. Behavioral Patterns (Object Interaction)

#### Command Pattern
Encapsulates a request as an object.

**Use When:**
- Undo/Redo, task queues

---

#### Strategy Pattern
Selects behavior at runtime.

**Use When:**
- Multiple interchangeable algorithms (payment, storage)

---

#### Observer Pattern
Notifies multiple objects about state changes.

**Use When:**
- Event-driven systems (UI updates, notifications)

---

## 🔥 General LLD Tips

- Prefer composition over inheritance
- Program to interfaces, not implementations
- Keep classes small and focused
- Avoid tight coupling between components
- Design for extension, not modification
- Think in terms of real-world objects and responsibilities

---
***************************************



 
## 🧠 SOLID Principles (with Practical Examples)

SOLID principles help in designing clean, scalable, and maintainable systems.

---

### 1. Single Responsibility Principle (SRP)
A class should have only one responsibility.

**Example:**
- `Invoice` → calculates bill  
- `InvoicePrinter` → prints invoice  
- `InvoiceRepository` → saves invoice  

**Use When:**
- A class is doing multiple unrelated tasks

---

### 2. Open/Closed Principle (OCP)
Open for extension, closed for modification.

**Example:**
- Payment system:
  - Add `UPIPayment`, `CardPayment` without modifying existing code

**Use When:**
- New features are frequently added

---

### 3. Liskov Substitution Principle (LSP)
Child class should replace parent without breaking behavior.

**Example:**
- `Bird` → fly() ❌
- `Ostrich` cannot fly → breaks LSP  
✔ Fix: separate `FlyingBird` and `NonFlyingBird`

**Use When:**
- Designing inheritance hierarchy

---

### 4. Interface Segregation Principle (ISP)
Clients should not depend on unused methods.

**Example:**
- Instead of:
  - `Worker` → work(), eat()
- Use:
  - `Workable`, `Eatable`

**Use When:**
- Large interfaces with unused methods

---

### 5. Dependency Inversion Principle (DIP)
Depend on abstractions, not concrete classes.

**Example:**
- `OrderService` depends on `PaymentInterface`
- Not directly on `Razorpay` or `Stripe`

**Use When:**
- Want flexibility and easy testing

---

## 🎯 Design Patterns (Definition + Example + Use Case)

---

### 1. Factory Pattern (Creational)
Creates objects without exposing creation logic.

**Example:**
- `ShapeFactory` → creates Circle, Rectangle

**Use When:**
- Object creation logic is complex or dynamic

---

### 2. Singleton Pattern (Creational)
Ensures only one instance exists.

**Example:**
- Logger
- Database connection

**Use When:**
- Shared global resource needed

---

### 3. Adapter Pattern (Structural)
Converts one interface into another.

**Example:**
- Charging adapter (Type-C → Micro USB)

**Use When:**
- Integrating incompatible systems

---

### 4. Decorator Pattern (Structural)
Adds behavior dynamically without modifying class.

**Example:**
- Coffee:
  - Basic Coffee → add Milk → add Sugar

**Use When:**
- Adding features at runtime

---

### 5. Command Pattern (Behavioral)
Encapsulates request as an object.

**Example:**
- Remote control (Undo/Redo operations)

**Use When:**
- Undo/Redo, queues, logging actions

---

### 6. Strategy Pattern (Behavioral)
Selects algorithm at runtime.

**Example:**
- Payment system:
  - UPI / Card / NetBanking

**Use When:**
- Multiple interchangeable behaviors

---

### 7. Observer Pattern (Behavioral)
Notifies multiple objects on state change.

**Example:**
- YouTube subscription notifications
- Stock price updates

**Use When:**
- Event-based systems

---

## 🔥 General LLD Tips

- Prefer composition over inheritance
- Program to interfaces, not implementations
- Keep classes small and focused
- Avoid tight coupling
- Design for extension (OCP)
- Think in real-world objects and responsibilities

---


***************************************
---
## 🎯 Why This Repository?

This repository demonstrates:
- Strong LLD fundamentals
- Real-world system modeling
- Ability to write scalable and maintainable code
- Interview-ready design thinking


***************************************
---

##  How to push code to Github from local pc 
🚀 1. FIRST TIME SETUP (one-time)
```
git config --global user.name "Your Name"
git config --global user.email "your@email.com"
```

🚀 2. PUSH WITHOUT BRANCH (simple way)
👉 Use this when working alone / simple repo

Steps:
##### go to your project folder
```
cd your-project-folder
```

##### initialize git
```
git init
```

##### add all files
```
git add .
```

##### commit
```
git commit -m "initial commit"
```

##### connect to GitHub repo
```
git remote add origin https://github.com/your-username/repo-name.git
```

### push to main branch
```
git branch -M main
git push -u origin main
```
🚀 3. PUSH USING BRANCH (recommended)
👉 Use this for safer workflow (better practice)

Step 1: Setup (same as above)
```
git init
git add .
git commit -m "initial commit"
git remote add origin https://github.com/your-username/repo-name.git
git branch -M main
git push -u origin main
```

Step 2: Create new branch
```
git checkout -b feature-google-doc
```

Step 3: Work + push branch
```
git add .
git commit -m "added google doc LLD"
git push origin feature-google-doc
```

Step 4: Merge to main (2 ways)

👉 Option A (GitHub UI - easiest)
Go to GitHub
Click Compare & Pull Request
Merge

👉 Option B (Local merge)
```
git checkout main
git pull origin main
git merge feature-google-doc
git push origin main
```

---
***************************************



## 👨‍💻 Author

alpha1zln and learned from coderArmy, Utb.
Built as part of structured system design preparation.

---
***************************************
***************************************


