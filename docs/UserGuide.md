# User Guide
**Duke** is a personal assistant chatbot for managing tasks, optimised for use via Command Line Interface (CLI), with a Graphical User Interface (GUI) output.

## Start
1. Ensure `Java 11` is installed.
1. Download the latest `jar` release from [here](https://github.com/TanChiaChun/ip/releases).
1. Move the `jar` file to the folder you want to use as *home folder* for Duke.
1. Double-click the `jar` file to start the app.
1. You should be greeted with below GUI.

![Ui](Ui.png)

## Features

### Add todo: `todo`
Add a todo to the tasks list.

Format: `todo TASK_NAME`

Example: `todo borrow book`<br><br>

### Add deadline: `deadline`
Add a deadline to the tasks list.

Format:
* `deadline TASK_NAME /by YYYY-MM-DD`
* `deadline TASK_NAME /by YYYY-MM-DDTHH:MM`

Example:
* `deadline return book /by 2021-09-25`
* `deadline return book /by 2021-09-25T19:00`<br><br>

### Add event: `event`
Add an event to the tasks list.

Format:
* `event TASK_NAME /at YYYY-MM-DD`
* `event TASK_NAME /at YYYY-MM-DDTHH:MM`

Example:
* `event project meeting /at 2021-09-25`
* `event project meeting /at 2021-09-25T19:00`<br><br>

### List all tasks: `list`
Show a list of tasks.

Format: `list [YYYY-MM-DD]`
* Optional date field to filter tasks by date.

Example:
* `list`
* `list 2021-09-25`<br><br>

### Find tasks with keyword: `find`
Find a list of tasks containing the given keyword.

Format: `find KEYWORD`

Example: `find book`<br><br>

### Set done: `done`
Set an existing task to done.

Format: `done INDEX`
* `INDEX` refer to the index number shown by the `list` command.

Example: `done 2`<br><br>

### Delete task: `delete`
Delete an existing task.

Format: `delete INDEX`
* `INDEX` refer to the index number shown by the `list` command.

Example: `delete 4`<br><br>

### Undo command: `undo`
Restore Duke to the state before the previous *undoable* command was executed.
* *Undoable* commands: `todo`, `deadline`, `event`, `done`, `delete`.

Format: `undo`<br><br>

### Exit program: `bye`
Exit the program.

Format: `bye`