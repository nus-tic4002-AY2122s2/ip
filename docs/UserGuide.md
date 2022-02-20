# User Guide

## Introduction

**Duke**

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `Duke`.

## Features 

Program designed for someone who are avid keyboarders,  for Single User use. 

### Load application: `java -jar duke.jar`
Load application and all records from previous session (if any) inside the JustBook application.
**Format**: `java -jar duke.jar`

<ins>**_Example of usage_**<ins>

`java -jar duke.jar`

### Adding a generic task: `[description]`
Adds a generic task
**Format**: `[description]`

### Adding a ToDo task: `todo [description]`
Adds a Todo task
**Format**: `todo [description]`

### Adding a Deadline task: `deadline [description] /by [Date and Time]`
Adds a Deadline task with a by Date
**Format**: `deadline [description] /by [Date and Time]`

### Adding an Event task: `event [description] /at [Date and Time] to [Time]`
Adds an Event task with a starting and ending date.

**Format**: `event [description] /at [Date and Time] to [Time]`

### Reschedule a Deadline: `reschedule [option number] /new [Date and time]`
Rescheduling a deadline
**Format**: `reschedule [option number] /new [Date and time]`

### Reschedule an Event: `reschedule [option number] /new [Date and time] to [Time]`
Rescheduling an Event with start and end time
**Format**: `reschedule [option number] /new [Date and time] to [Time]`


###  Changing a task to done: `done [option number]`
Changing a task to done
**Format**: `done [option number]`

### Changing a task to undone: `undone [option number]`
Changing a task to undone
**Format**: `undone [option number]`

### Deleting a task from the list:  `delete [option number]`
Deleting a task from the list
**Format**: `delete [option number]`

### Clearing the task list: `/clear`
Clearing the task list
**Format**: `/clear`

### To close this application: `bye`
To save and close the application
**Format**: `bye`

### To find tasks in the list containing a keyword: `find [keyword]`
To search for a specific keyword
**Format**: `find [keyword]`

### To print the list of tasks:  `list`
To have Duke print the list of tasks
**Format**: `list`

### To print the list of commands available:`/help`
To print the list of commands available
**Format**: `/help`





## Command Summary
[ 'Cheat Sheet' of **CLI COMMANDS** - _case-sensitive_ ]
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