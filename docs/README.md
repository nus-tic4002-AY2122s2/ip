# User Guide for Duke

## Introduction
 Duke is a Personal Assistant Chatbot that helps the user keep track of various tasks. These tasks include ToDos, Deadlines and events.
 The user would be able to change and edit various tasks as per the user wants.
## Features 
* Add tasks such as (ToDo, Deadlines, Events) to the list
* Reschedule tasks
* Display the current list of tasks
* Set the tasks to be done or undone
* Display errors when commands are incorrect
* Delete tasks from the task list
* Store the tasks in a text file
* Load tasks from a text file
* Find tasks that contain a keyword (fully or partially)

Description of the feature.

## Usage
For help, type "/help". 

Inputs in commands:
```
[description] is a string that describes the task.
[Date and Time] refers to the input date. It goes by the format "dd/MM/yyyy HH:mm:ss". Eg. 02/12/20 10:10:10
[Time] refers to the Time format of "HH:mm" where they represent the hours and minutes
[option] refers to the option number. The option number for each task can be viewed when the tasks are printed
 as a list.(this can be seen by the command "list")
[keyword] refers to the phrase or word that you want to search for.
```
Commands:
```
Adding a generic task: [description]
Adding a ToDo task: todo [description]
Adding a Deadline task: deadline [description] /by [Date and Time]
Adding a Event task: event [description] /at [Date and Time] to [Time]
Reschedule a Deadline: reschedule [option number] /new [Date and time]
Reschedule a Event: reschedule [option number] /new [Date and time] to [Time]
Changing a task to done: done [option number]
Changing a task to undone: undone [option number]
Deleting a task from the list: delete [option number]
Clearing the task list: /clear
To close this application: bye
To find tasks in the list containing a keyword: find [keyword]
To print the list of tasks: list
```


### `Keyword` - Describe action

Describe the action and its outcome.

Example of usage: 

`keyword (optional arguments)`

Expected outcome:

Description of the outcome.

```
expected output
```
