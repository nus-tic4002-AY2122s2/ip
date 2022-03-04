# User Guide

## Introduction
 Duke is a Personal Assistant Chatbot that helps the user keep track of various tasks. These tasks include ToDos, Deadlines and events.
 The user would be able to input various commands in order execute the different features. If the commands are incorrect, an error message would be displayed.

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `Duke`.

### Load application: `java -jar duke.jar`
Load application and all records from previous session (if any) inside the JustBook application.
**Format**: `java -jar duke.jar`

## Set Up
In the terminal, through gradle:
To compile the java files:

`gradlew shadowjar` 

The jar file will be at build/libs, named as "launcher-all.jar". Rename the jar file to duke.jar

Alternatively, to run the file:

`gradlew run`

or

`java -jar duke.jar`


## Features 

Program designed for someone who are avid keyboarders,  for Single User use. 


### Adding a generic task: `[description]`
Adds a generic task
**Format**: `[description]`
<ins>**_Example of usage_**<ins>
`running`

### Adding a ToDo task: `todo [description]`
Adds a Todo task
**Format**: `todo [description]`
<ins>**_Example of usage_**<ins>
`todo running`

### Adding a Deadline task: `deadline [description] /by [Date and Time]`
Adds a Deadline task with a by Date
**Format**: `deadline [description] /by [Date and Time]`
<ins>**_Example of usage_**<ins>
`deadline school homework /by 20/12/2020 10:10:10`

### Adding an Event task: `event [description] /at [Date and Time] to [Time]`
Adds an Event task with a starting and ending date.
**Format**: `event [description] /at [Date and Time] to [Time]`
<ins>**_Example of usage_**<ins>
`event birthday dinner /at 10/12/2020 11:11:11 to 20:20:20`

### Reschedule a Deadline: `reschedule [option number] /new [Date and time]`
Rescheduling a deadline
**Format**: `reschedule [option number] /new [Date and time]`
<ins>**_Example of usage_**<ins>
`reschedule 2 /new 18/12/2020 23:59:59`

### Reschedule an Event: `reschedule [option number] /new [Date and time] to [Time]`
Rescheduling an Event with start and end time
**Format**: `reschedule [option number] /new [Date and time] to [Time]`
<ins>**_Example of usage_**<ins>
`reschedule 3 /new 11/12/2020 18:30:00 to 22:13:14`


###  Changing a task to done: `done [option number]`
Changing a task to done
**Format**: `done [option number]`
<ins>**_Example of usage_**<ins>
`done 1`

### Changing a task to undone: `undone [option number]`
Changing a task to undone
**Format**: `undone [option number]`
<ins>**_Example of usage_**<ins>
`undone 1`

### Deleting a task from the list:  `delete [option number]`
Deleting a task from the list
**Format**: `delete [option number]`
<ins>**_Example of usage_**<ins>
`delete 1`

### Clearing the task list: `/clear`
Clearing the task list
**Format**: `/clear`


### To close this application: `bye`
To save and close the application
**Format**: `bye`

### To find tasks in the list containing a keyword: `find [keyword]`
To search for a specific keyword
**Format**: `find [keyword]`
<ins>**_Example of usage_**<ins>
`find home`

### To print the list of tasks:  `list`
To have Duke print the list of tasks
**Format**: `list`

### To print the list of commands available:`/help`
To print the list of commands available
**Format**: `/help`



## Command Summary
###Inputs in commands:
The input description will be in the square brackets "[ ]".
eg. [Time] refers to an input that is related to time.

1. `[description]` is a string that describes the task.
2. `[Date and Time]` refers to the input date and time. It goes by the format "dd/MM/yyyy HH:mm:ss". Eg. 02/12/20 10:10:10
3. `[Time]` refers to the Time format of "HH:mm:ss" where they represent the hours, minutes and seconds.
4. `[option]` refers to the option number. The option number for each task can be viewed when the tasks are printed
 as a list.(this can be seen by the command `list`)
5. `[keyword]` refers to the phrase or word that you want to search for.


###Commands:
The commands for the respective features are after the semi-colon":"

1. Adding a generic task: `[description]`
2. Adding a ToDo task: `todo [description]`
3. Adding a Deadline task: `deadline [description] /by [Date and Time]`
4. Adding an Event task: `event [description] /at [Date and Time] to [Time]`
5. Reschedule a Deadline: `reschedule [option number] /new [Date and time]`
6. Reschedule an Event: `reschedule [option number] /new [Date and time] to [Time]`
7. Changing a task to done: `done [option number]`
8. Changing a task to undone: `undone [option number]`
9. Deleting a task from the list: `delete [option number]`
10. Clearing the task list: `/clear`
11. To close this application: `bye`
12. To find tasks in the list containing a keyword: `find [keyword]`
13. To print the list of tasks: `list`
14. To print the list of commands available: `/help`