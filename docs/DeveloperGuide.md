# Developer Guide

## Acknowledgements

[https://se-education.org/](https://se-education.org/)

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

## Design & implementation

The Design consist of different classes and component like Ui, Storage, Parser, TaskList, MainWindow and Duke.

### Class UML Diagram
![image](https://user-images.githubusercontent.com/43517460/154843168-57f4e984-e936-43d5-b7a6-b03f7829b3af.png)

The two classes called Launcher and Main are responsible for,  
At app launch: Initializes the components in the correct sequence, and connects them up with each other.  
At shut down: Shuts down the components and invokes cleanup methods where necessary.

The rest of the App consists of four components.  

UI: The UI of the App. (MainWindow, Ui and DialogBox)  
Logic: The command executor. (Parser, Command)  
Model: Holds the data of the App in memory. (Tasks, TaskList)  
Storage: Reads data from, and writes data to, the hard disk. (Storage)  

The Ui component will work together with Duke which will work together with the Logic, Model and Storage component to execute the command enter by the user.

### Sequence Diagram
![image](https://user-images.githubusercontent.com/43517460/154844136-04d131f7-caf0-4390-a2b4-e34067241956.png)


### Object diagram
![image](https://user-images.githubusercontent.com/43517460/154842316-e60b952a-9929-403e-b4a7-187c8022935b.png)



## Target user profile

has a need to manage and track daily tasks
prefers desktop apps over other types
prefers typing to mouse interactions
is reasonably comfortable using CLI apps  

## Value proposition

keep record of tasks
track daily tasks easily
avoid missing some important tasks


## User Stories

|Version| As a ... | I want to ... | So that ...|
|--------|----------|---------------|------------------|
|v1.0|new user|know what kind of command there are|I can what are the feature and how I can use them|
|v1.0|new user|know how to add a task |I can record the task to track|
|v1.0|new user|view the list of task |I can see all my task that I need to do|
|v1.0|new user|delete a task |If I keyed in wrongly, I can remove it|
|v1.0|new user|mark a task as done |I can know which task are done instead of deleting it from record|
|v1.5|semi-new user|save my task for future use|Once I switch on the app, the task I recorded previously are still there|
|v2.0|user|find a task using keywords|I can easily check for the information I need|
|v2.0|user|group my task to ToDo, Event and Deadlines |I can have more types of task to keep track and include time for specific task|
|v2.0|user|clear my current list of task |I don't have to delete one by one|
|v3.0|user|have a GUI instead of CLI | it feels more like a chatbot and look nicer|
|v3.0|user|be informed if I have keyed in a task with a similar description | I know I had keyed in a duplicated task|
|v3.0|user|have a countdown for closing of the app | I know that the app is responding and is closing|

## Non-Functional Requirements

- Each request should be processed within 3 seconds.
- Program to function properly on different operating systems.
- Program should be easily add in new function or new modules.
- Command should be easy to use and understand.
- GUI should be as simple and neat as possible.


## Glossary

Mainstream OS: Windows, Linux, Unix, OS-X
CLI - Command Line Interface
GUI - Graphical User Interface
