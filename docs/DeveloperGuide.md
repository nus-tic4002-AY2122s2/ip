# Developer Guide

- By: Sze Chun  


## Design

**Duke** leverages on the help of a total five Java classes, viz. **JustBook, Bookings, AddCommand, DeleteCommand and HelpCommand** created by the Team. It makes optimal use of Java Stream and the latest java time APIs, e.g. LocalDateTime and LocalDate, among others, together with a judicious choice of data structures. It allows a single user to key in tasks fast. 

- Each Task is stored in the `Arraylist<Task>` data structure.
  
- Each of the Task types have their own characteristics
  


## Implementation


#### Highlights:


#### Design considerations:

We tried to adhere to a Command design pattern as much as possible. In terms of design principles, for the refactored Command classes, they have adhered to Single Responsibility Principle rather well. This allows strong cohesion with minimal coupling for those
classes. However, certain principles such as Open-Closed Principle was adhered as much as possible. I have to tried to follow the Open to addition, close to modification principle as much as possible.
The new GUI change was more similar to an addition, with minimal modification to previous existing code. The Ui class/object serves to act as a stack of messages of sorts, allowing Duke to output a following sequence of messages. The Launcher class will thus be launching the application.

## Product scope
**Target user profile:**

- has to keep track of various tasks
- prefer desktop apps vs other types
- can type fast
- prefers using the keyboard over mouse interactions
- is reasonably comfortable using CLI apps

**Value proposition:** manage Tasks in a GUI window


### Value proposition


Duke provides a user-friendly, consistent and error-free interface,  that allows the user to key in various tasks
Some of these tasks include events, deadlines, todo as such. The user could reschedule and search for certain tasks.

## Non-Functional Requirements
1. Users are able to run the application as long as Java11 is installed
2. The application has been designed to handle up to 100’s of Tasks optimally without affecting its performance.
3. The application should preferably be executable on Windows OS or compatible software-emulated terminal.
4. User-friendly features incorporated in helpful messages feedback and diagnostic prompts (more to come) 


## Instructions for manual testing

- Ensure Java jdk 11 is installed
- Download the duke.jar file from the latest release
- start up the app, eg.` java -jar duke.jar` via a windows cmd or compatible terminal
- Type `/help` for instructions

## Diagrams
![Class Diagram.](ClassDiagram1.png)

![Sequence Diagram.](SequenceDiagram.png)

## BCD Extension
- Find tasks that contain a keyword (fully or partially)