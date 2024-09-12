## User Guide

### 1. Introduction

Duke is a Personal Assistant Chatbot that helps user keep track of his/her tasks.
Duke is optimized for users who are IT-Savvy or familiar with a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). Continue reading to find out more about its features and usage!

#### 1.1 Getting Started

1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest [jar](https://github.com/yinyin377/ip/releases) file here.
3. Copy the file to the folder you want to use as the home folder. Your tasks will be saved to and loaded from data/tasks.txt located in the same folder.
4. Double-click the file to start the app. The GUI should appear in a few seconds.
5. Type the command in the text box and press Send to execute it.


### 2. Features

Program designed for Single-User use.

#### 2.1 Load application: `java -jar duke.jar`
Load application and all records from previous session (if any) inside the Duke application.

_Format:_ `java -jar duke.jar`

<ins>_Example of usage_<ins>

`java -jar duke.jar`

By calling this command, the Duke application will load.

#### 2.2 Adding a to-do task: `todo DESC`
Adds a new to-do task to the list of tasks.

_Format:_ `todo DESC`

* The `DESC` can be a description or title of task.

<ins>_Example of usage_<ins>

`todo laundry`

`todo science homework`

#### 2.3 Adding an event Task: `event DESC /at DATE`
Blocks users from creating appointments during a specific date range.

_Format:_ `event DESC /at DATETIME`

* The `DESC` can be a description or title of task.
* `DATETIME` uses format *YYYY-MM-DD HH:MM*

<ins>_Example of usage_<ins>

`event dinner /at 2022-02-22 14:22`

#### 2.4 Adding an deadline task: `deadline DESC /by DATE`
Blocks users from creating appointments during a specific date range.

_Format:_ `deadline DESC /by DATETIME`

* The `DESC` can be a description or title of task.
* `DATETIME` uses format *YYYY-MM-DD HH:MM*

<ins>_Example of usage_<ins>

`deadline project /by 2022-02-22 14:00`


#### 2.5 Deleting a task: `del INDEX`
Erase a specified record in the list of tasks.

_Format:_ `del INDEX`

* `INDEX` is an integer of task to be deleted.

<ins>_Example of usage_<ins>

`delete 1`

#### 2.6 Save all tasks up to this point: `save`
Save all records up to this point.

_Format:_ `save`

<ins>_Example of usage_<ins>

`save`


#### 2.7 Update task's date: `update INDEX /to DATETIME`
Edits the date of event / deadline task.

_Format:_ `update INDEX /to DATETIME `

* `INDEX` is an integer of task to be deleted.
* `DATETIME` uses format *YYYY-MM-DD HH:MM*.

<ins>_Example of usage_<ins>

`update project /to 2022-03-03 13:00`


#### 2.8 Exiting Program: `bye`
Exits the Duke Program.

_Format:_ `bye`

<ins>_Example of usage_<ins>

`bye`


#### 2.9 Show all tasks: `list`
Displays all tasks stored.

_Format:_ `list`

<ins>_Example of usage_<ins>

`list`


#### 2.10 Show task for specific date: `view DATE`
Display all records within specified date range.

_Format:_ `view DATE`

* `DATE` uses integer format.

<ins>_Example of usage_<ins>

`view 2021`

`view 02`

#### 2.11 Show task with specific keyword: `find DESC`
Displays all records with a specific keyword.

_Format:_ `find DESC`

* The `DESC` can be a part of description or title of task.

<ins>_Example of usage_<ins>

`find science`


#### 2.12 Mark a task as done: `done INDEX`
Mark a task as done.

_Format:_ `done INDEX`

* `INDEX` is an integer of task to be marked as done or complete.

<ins>_Example of usage_<ins>

`done 1`


#### 2.13 To get help or tips: `help`
By calling this command, a sample of cheatsheet commands will appear.

<ins>_Example of usage_<ins>

`help`


## 3. FAQ

**Q**: How do I show all tasks with specfic keyword?

**A**: you can refer to the _Show task with specific keyword_ in the Command Summary.

**Q**: How do I delete a task done?

**A**: you can refer to the _Deleting a task_ in the Command Summary.

**Q**: How do I save all the bookings on the go?

**A**: you can simply key in `save`.


## 4. Command Summary
[ 'Cheat Sheet' of **CLI COMMANDS** - _case-sensitive_ ]

* Adding a to-do task: `todo DESC`
* Adding an event Task: `event DESC /at DATE`
* Adding an deadline task: `deadline DESC /by DATE`
* Deleting a task: `del INDEX`
* Save all tasks up to this point: `save`
* Update task's date: `update INDEX /to DATETIME`
* Exiting Program: `bye`
* Show all tasks: `list`
* Show task for specific date: `view DATE`
* Show task with specific keyword: `find DESC`
* Mark a task as done: `done INDEX`
* Requiring help with commands: `help`