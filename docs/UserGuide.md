# User Guide
**Duke** is a Personal Assistant Chatbot, that will help to keep track of your tasks.

## Start
1. Ensure `Java 11` is installed.
1. Download the latest `jar` release from [here](https://github.com/TanChiaChun/ip/releases).
1. Run `Terminal` from directory where the `jar` file is downloaded to.
1. Execute command `java -jar Duke.jar`.
1. You should be greeted with below message.
```
Hello! I'm Duke
What can I do for you?
____________________________________________________________
```

## Features

### Add todo: `todo`
Add a todo to the tasks list.

Format: `todo TASK_NAME`

Example: `todo borrow book`

&nbsp;
### Add deadline: `deadline`
Add a deadline to the tasks list.

Format:
* `deadline TASK_NAME /by YYYY-MM-DD`
* `deadline TASK_NAME /by YYYY-MM-DDTHH:MM`

Example:
* `deadline return book /by 2021-09-25`
* `deadline return book /by 2021-09-25T19:00`

&nbsp;
### Add event: `event`
Add an event to the tasks list.

Format:
* `event TASK_NAME /at YYYY-MM-DD`
* `event TASK_NAME /at YYYY-MM-DDTHH:MM`

Example:
* `event project meeting /at 2021-09-25`
* `event project meeting /at 2021-09-25T19:00`

&nbsp;
### List all tasks: `list`
Show a list of tasks.

Format: `list [YYYY-MM-DD]`
* Optional date field to filter tasks by date.

Example:
* `list`
* `list 2021-09-25`

&nbsp;
### Find tasks with keyword: `find`
Find a list of tasks containing the given keyword.

Format: `find KEYWORD`

Example: `find book`

&nbsp;
### Set done: `done`
Set an existing task to done.

Format: `done INDEX`
* `INDEX` refer to the index number shown by the `list` command.

Example: `done 2`

&nbsp;
### Delete task: `delete`
Delete an existing task.

Format: `delete INDEX`
* `INDEX` refer to the index number shown by the `list` command.

Example: `delete 4`

&nbsp;
### Exit program: `bye`
Exit the program.

Format: `bye`