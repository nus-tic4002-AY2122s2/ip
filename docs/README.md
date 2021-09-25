# User Guide for Duke

## Introduction
 Duke is a Personal Assistant Chatbot that helps the user keep track of various tasks. These tasks include ToDos, Deadlines and events.
 The user would be able to input various commands in order execute the different features. If the commands are incorrect, an error message would be displayed.
 
## Features 
The main features would be commands related to the tasks. For the specialised tasks, ToDo has only a description.
Deadlines consist of a description a due date. Events consist of a time period. Some of the features such as save and load happen automatically upon opening or closing the application.

List of Features:
* Add tasks such as (ToDo, Deadlines, Events) to the list
* Reschedule tasks
* Display the current list of tasks
* Set the tasks to be done or undone
* Display errors when commands are incorrect
* Delete tasks from the task list
* Store the tasks in a text file
* Load tasks from a text file
* Find tasks that contain a keyword (fully or partially)



## Usage
The user will input commands for the chatbot to parse in order to execute different features. 
Different commands may require different inputs.


Inputs in commands:
The input description will be in the square brackets "[]".
eg. [Time] refers to an input that is related to time.
```
[description] is a string that describes the task.
[Date and Time] refers to the input date. It goes by the format "dd/MM/yyyy HH:mm:ss". Eg. 02/12/20 10:10:10
[Time] refers to the Time format of "HH:mm:ss" where they represent the hours, minutes and seconds
[option] refers to the option number. The option number for each task can be viewed when the tasks are printed
 as a list.(this can be seen by the command "list")
[keyword] refers to the phrase or word that you want to search for.
```
Commands:
The commands for the respective features are after the semi-colon":"
```
Adding a generic task: [description]
Adding a ToDo task: todo [description]
Adding a Deadline task: deadline [description] /by [Date and Time]
Adding an Event task: event [description] /at [Date and Time] to [Time]
Reschedule a Deadline: reschedule [option number] /new [Date and time]
Reschedule an Event: reschedule [option number] /new [Date and time] to [Time]
Changing a task to done: done [option number]
Changing a task to undone: undone [option number]
Deleting a task from the list: delete [option number]
Clearing the task list: /clear
To close this application: bye
To find tasks in the list containing a keyword: find [keyword]
To print the list of tasks: list
```


