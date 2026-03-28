
# 📄 Google Docs - Low Level Design (Java + C++)

This project is a simplified implementation of a document editor similar to Google Docs.  
It demonstrates strong Object-Oriented Design and Low-Level Design principles.

---

## 🚀 Features

- Add Text, Image, NewLine, Tab
- Text Formatting:
  - Bold
  - Underline
- Undo / Redo functionality
- Autosave after every operation
- Save document as:
  - Text File
  - PDF (simulated)



---

## UML Diagram (Follow this exactly)

### Dig. in brief

```
[DocumentEditor]
   | uses
   v
[Document] --------> [DocumentElement (interface)]
                         ↑
      -----------------------------------------
      |        |        |        |            |
   [Text]  [Bold]  [Underline] [Image]   [NewLine]

[DocumentEditor] ---> [Command Interface]
                         |
                  [AddElementCommand]

[DocumentEditor] ---> [Persistence Interface]
                         |
                 -------------------
                 |                 |
           [FileStorage]     [PDFStorage]
```


### 📦 Step-by-step layout

👉 Draw boxes in this order (top → bottom)

🔷 1. Top Layer (Controller)
+----------------------+
|   DocumentEditor     |
+----------------------+
| - document           |
| - storage            |
| - undoStack          |
| - redoStack          |
+----------------------+
| + addText()          |
| + addBoldText()      |
| + addUnderlineText() |
| + addImage()         |
| + undo()             |
| + redo()             |
| + render()           |
| + save()             |
+----------------------+
🔷 2. Middle Layer (Core Model)
+----------------------+
|      Document        |
+----------------------+
| - elements : List    |
+----------------------+
| + add()              |
| + removeLast()       |
| + render()           |
+----------------------+
🔷 3. Element Abstraction
+----------------------+
|  <<interface>>       |
|  DocumentElement     |
+----------------------+
| + render()           |
+----------------------+
🔷 4. Element Implementations (Below it)
+------------+   +------------+   +------------------+
| TextElement|   | BoldText   |   | UnderlineText    |
+------------+   +------------+   +------------------+

+------------+   +------------+   +------------------+
| Image      |   | NewLine    |   | TabSpace         |
+------------+   +------------+   +------------------+
🔷 5. Command Pattern (Side Section)
+----------------------+
| <<interface>>        |
| Command              |
+----------------------+
| + execute()          |
| + undo()             |
+----------------------+

        ↓

+----------------------+
| AddElementCommand    |
+----------------------+
| - document           |
| - element            |
+----------------------+
| + execute()          |
| + undo()             |
+----------------------+
🔷 6. Storage (Strategy Pattern)
+----------------------+
| <<interface>>        |
| Persistence          |
+----------------------+
| + save()             |
+----------------------+

        ↓

+------------------+   +------------------+
| FileStorage      |   | PDFStorage       |
+------------------+   +------------------+
🔗 Connections (VERY IMPORTANT)

Draw arrows like this:

✅ Core flow
DocumentEditor → Document (uses)
Document → DocumentElement (has list)
✅ Inheritance
All elements → DocumentElement
BoldText → TextElement
Underline → TextElement
✅ Command
DocumentEditor → Command
AddElementCommand → Command
✅ Storage
DocumentEditor → Persistence
FileStorage → Persistence
PDFStorage → Persistence
🎨 Final Layout Tip (VERY IMPORTANT)

👉 Arrange like this on draw.io:

Top:        DocumentEditor

Middle:     Document

Below:      DocumentElement → child elements

Right side: Command Pattern

Left side:  Persistence

---

****************************************************
---

## 🧠 Design Concepts Used

### 1. Abstraction
- `DocumentElement` defines a common interface for all elements

### 2. Polymorphism
- Each element implements its own `render()` method

### 3. Inheritance
- `BoldTextElement`, `UnderlineTextElement` extend `TextElement`

### 4. Composition
- `Document` contains a list of elements

---

## 🎯 Design Patterns

### ✅ Command Pattern
Used for:
- Undo / Redo functionality

Each operation is stored as a command object.

---

### ✅ Strategy Pattern
Used for:
- Storage (File / PDF)

Allows switching storage without changing core logic.

---

### ✅ Open/Closed Principle
- Easily add new elements (e.g., Heading, Italic)
- No modification to existing code required

---

## 🔄 System Flow

User → DocumentEditor → Command → Document → Elements → Render → Storage

---

## 📂 Project Structure
google-doc-editor/
├── README.md
├── java/
│ └── DocumentEditor.java
├── cpp/
│ └── document_editor.cpp
├── diagram.png

---

## 🧪 Sample Output

Hello World
Bold Text
Underline Text
[Image: picture.jpg]

---

## 🔥 Future Improvements

- Cursor-based editing
- Delete / Replace operations
- Real PDF generation (using libraries)
- Collaborative editing (like Google Docs)
- Version control system

---

## 🎯 Why This Project?

This project demonstrates:
- Strong Low-Level Design skills
- Real-world system modeling
- Use of design patterns
- Clean, extensible architecture

****************************************
---

## 🧠 SOLID Principles used in this (with Examples)

### 1. Single Responsibility Principle (SRP)
A class should have only one reason to change.

**Example:**
- `Document` → only manages elements
- `FileStorage` → only handles saving

**Use When:**
- You want clean, maintainable code

---

### 2. Open/Closed Principle (OCP)
Open for extension, closed for modification.

**Example:**
- Added `BoldTextElement` without changing existing classes

**Use When:**
- Adding new features frequently

---

### 3. Liskov Substitution Principle (LSP)
Child classes should behave like parent class.

**Example:**
- `BoldTextElement` can replace `TextElement` anywhere

**Use When:**
- Using inheritance

---

### 4. Interface Segregation Principle (ISP)
Don't force classes to implement unused methods.

**Example:**
- `Persistence` only has `save()` (minimal interface)

**Use When:**
- Designing interfaces

---

### 5. Dependency Inversion Principle (DIP)
Depend on abstractions, not concrete classes.

**Example:**
- `DocumentEditor` depends on `Persistence`, not `FileStorage`

**Use When:**
- Writing flexible, testable code

---

## 🎯 Design Patterns (Definition + Example + Use Case)

### 1. Command Pattern
Encapsulates a request as an object.

**Example:**
- `AddElementCommand` → used for undo/redo

**Use When:**
- Need undo/redo or action history

---

### 2. Strategy Pattern
Allows selecting behavior at runtime.

**Example:**
- `FileStorage`, `PDFStorage` implement `Persistence`

**Use When:**
- Multiple interchangeable behaviors (e.g., payment, storage)

---

### 3. Factory Pattern
Creates objects without exposing creation logic.

**Example:**
- Could create elements like `TextElement`, `ImageElement`

**Use When:**
- Object creation logic is complex

---

### 4. Observer Pattern
Notifies multiple objects when state changes.

**Example:**
- Autosave or UI update on document change

**Use When:**
- Event-based systems (notifications, UI updates)

---

### 5. Singleton Pattern
Ensures only one instance exists.

**Example:**
- Logger, Configuration manager

**Use When:**
- Shared global resource needed

****************************************************
---



## 👨‍💻 Author

alpha1zln and learned from coderArmy, Utb and chatGpt.
Built as part of Low-Level Design practice.



*********************************