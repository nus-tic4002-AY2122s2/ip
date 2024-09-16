# User Guide

**The IP is based on the generic project called _[Project Duke](https://nus-tic4001-ay2122s1.github.io/website/se-book-adapted/projectDuke/index.html)_.** which is a `CLI` text-based project and implemented with the `GUI` feature to display a graphic chatbot layout for the command and command result.

## :bell: Added feature in the latest version
### GUI
Convert the previous pure `CLI` version into a `GUI` project using `JavaFX`

### Update Command
Add a new command `UpdateCommand` as an extension, to easily edit details of a task, detail syntax and example can check `Usage` section


## :star: Features

### Feature-Add

Can add three types of Task:
- `todo` without any datetime, just a simple description
- `deadline` with a by/ datetime
- `event` with a at/ datetime

### Feature-Single word command(no arguments)

**1. Listing(Read)**
- `list` able to list all tasks inside the list
- `sort` able to sort the tasks by the finished datetime

**2. Clear**
- `clear` to remove all the tasks inside the list

**3. Others**
- `help` Shows all the instructions for the user that are not familier with the app
- `bye` Exit the program

### Feature-Command with Index

- `done` to mark one or multiple tasks as done status
- `delete` to delete one or multiple tasks at the same time
- `update` to update a specific detail of a task

### Feature-Command with other arguments

- `find` to find the tasks in the list based on keyword
- `viewdone` to view the finished tasks done during a specific period.


## :memo: Usage

### `todo` - Add a Todo Task into the task list

Syntax: `todo DESCRIPTION`

Example: `todo do house cleaning`

Expected outcome:

```
New T Added: [T][X] do house cleaning
Now you have 9 tasks in the list.
```

### `deadline` - Add a Deadline Task with a due date into the task list

Syntax: `todo DESCRIPTION by/DATETIME` (DATETIME Format: `YYYY-MM-dd HHmm`)

Example: `deadline quiz submission by/2021-10-01 2359`

Expected outcome:

```
New D Added: [D][X] quiz submission (by: Oct 1 2021 23:59)
Now you have 10 tasks in the list.
```

### `event` - Add a Event with a date into the task list

Syntax: `event DESCRIPTION at/DATETIME` (DATETIME Format: `YYYY-MM-dd HHmm`)

Example: `event company weekly organization meeting at/2021-09-30 1200`

Expected outcome:

```
New E Added: [E][X] company weekly organization meeting (at: Sep 30 2021 12:00)
Now you have 11 tasks in the list.
```

### `list` - List the all the tasks in the task list.

Syntax: `list`

Expected outcome:

```
1. [D][Done : Aug 1 2021 18:00] return book (by: Aug 5 2021 10:05)
2. [T][Done : Sep 5 2021 22:29] go exercising
3. [T][X] borrow book
4. [E][X] tba2105 project group discussion (at: Sep 14 2021 18:00)
5. [D][Done : Sep 25 2021 18:14] write proposal for project A (by: Sep 30 2021 18:00)
6. [E][X] tba4001 project group discussion (at: Sep 15 2021 18:00)
7. [E][X] project A group discussion (at: Sep 14 2021 18:00)
8. [E][Done : Mar 14 2021 21:00] project meeting (at: Mar 14 2021 17:21)
9. [T][X] do house cleaning
10. [D][X] quiz submission (by: Oct 1 2021 23:59)
11. [E][X] company weekly organization meeting (at: Sep 30 2021 12:00)
```


### `sort` - Sort the all the tasks in the task list by finish date in descending order.

- unfinished tasks will appear on the top

Syntax: `sort`

Expected outcome:

```
1. [T][X] borrow book
2. [E][X] tba2105 project group discussion (at: Sep 14 2021 18:00)
3. [E][X] tba4001 project group discussion (at: Sep 15 2021 18:00)
4. [E][X] project A group discussion (at: Sep 14 2021 18:00)
5. [T][X] do house cleaning
6. [D][X] quiz submission (by: Oct 1 2021 23:59)
7. [E][X] company weekly organization meeting (at: Sep 30 2021 12:00)
8. [D][Done : Sep 25 2021 18:14] write proposal for project A (by: Sep 30 2021 18:00)
9. [T][Done : Sep 5 2021 22:29] go exercising
10. [D][Done : Aug 1 2021 18:00] return book (by: Aug 5 2021 10:05)
11. [E][Done : Mar 14 2021 21:00] project meeting (at: Mar 14 2021 17:21)
```

### `done` - Mark task(s) as done status

**1. Syntax 1 (Without a finished time)**

- Duke will capture the current datetime

Syntax: `done INDEX INDEX ... INDEX`

Example: `done 2 4`

Expected outcome:

```
[E][Done : Sep 26 2021 14:22] tba2105 project group discussion (at: Sep 14 2021 18:00) is done on Sep 26 2021 14:22
[E][Done : Sep 26 2021 14:22] project A group discussion (at: Sep 14 2021 18:00) is done on Sep 26 2021 14:22
```

**2. Syntax 2 (With a finished time)**

Syntax: `done INDEX INDEX ... INDEX on/DATETIME` (DATETIME Format: `YYYY-MM-dd HHmm`)

Example: `done 1 3 on/2021-09-20 1200`

Expected outcome:

```
[T][Done : Sep 20 2021 12:00] borrow book is done on Sep 20 2021 12:00
[E][Done : Sep 20 2021 12:00] tba4001 project group discussion (at: Sep 15 2021 18:00) is done on Sep 20 2021 12:00
```
- It is okay for you to add more space between the INDEX accidently, e.g. Duke will read
```
2  3    4 5
```
as

```
2 3 4 5
```

### `delete` - Delete task(s) from the task list based on the index(s)

Syntax: `delete INDEX INDEX ... INDEX`

Example: `delete 9 1`

Expected outcome:

```
Remove successfully.
```

`list`
Expected outcome:

```
1. [E][Done : Sep 26 2021 14:22] tba2105 project group discussion (at: Sep 14 2021 18:00)
2. [E][Done : Sep 20 2021 12:00] tba4001 project group discussion (at: Sep 15 2021 18:00)
3. [E][Done : Sep 26 2021 14:22] project A group discussion (at: Sep 14 2021 18:00)
4. [T][X] do house cleaning
5. [D][X] quiz submission (by: Oct 1 2021 23:59)
6. [E][X] company weekly organization meeting (at: Sep 30 2021 12:00)
7. [D][Done : Sep 25 2021 18:14] write proposal for project A (by: Sep 30 2021 18:00)
8. [D][Done : Aug 1 2021 18:00] return book (by: Aug 5 2021 10:05)
9. [E][Done : Mar 14 2021 21:00] project meeting (at: Mar 14 2021 17:21)
```



### `update` - update a task from the task list based on the index and its target detail that need to be updated

Syntax: `update INDEX toUpdateField(description|desc|tasktime) newValue`

Example 1: `update 4 desc TIC4002 tP discussion`

- **desc** is the abbreviation of **description**, you can use both when you want to update the task description.

Expected outcome:

```
[E][X] tba2105 project group discussion (at: Sep 14 2021 18:00)
update to 
[E][X] TIC4002 tP discussion (at: Sep 14 2021 18:00)
```

Example 2: `update 4 tasktime 2022-02-23 2000`

- **tasktime** is the **/at** in Event or the **/by** in Deadline

Expected outcome:

```
[E][X] TIC4002 tP discussion (at: Sep 14 2021 18:00)
update to 
[E][X] TIC4002 tP discussion (at: Feb 23 2022 20:00)
```



### `find` - Finds the specific tasks based on the keywords

- There is a optional flag after find:
    -  `1` indicate 'isCombined' is `true` which means will only find the task(s) which match all the keywords combined
    -  `0` indicate 'isCombined' is `false` which means will find the task(s) which match all the keywords separately
    -  if omit this flag will default `1`

Syntax: `find (optional: 0|1) KEYWORDS`

Example 1: `find meeting project`

Expected outcome:

```
1. [E][Done : Mar 14 2021 21:00] project meeting (at: Mar 14 2021 17:21)
```

Example 2: `find 0 meeting project`

Expected outcome:

```
1. [E][Done : Sep 26 2021 14:22] tba2105 project group discussion (at: Sep 14 2021 18:00)
2. [E][Done : Sep 20 2021 12:00] tba4001 project group discussion (at: Sep 15 2021 18:00)
3. [E][Done : Sep 26 2021 14:22] project A group discussion (at: Sep 14 2021 18:00)
4. [D][Done : Sep 25 2021 18:14] write proposal for project A (by: Sep 30 2021 18:00)
5. [E][Done : Mar 14 2021 21:00] project meeting (at: Mar 14 2021 17:21)
```

### `viewdone` - View the finished tasks done during a specific period.

Syntax: `viewdone from/DATETIME to/DATETIME` (DATETIME Format: `YYYY-MM-dd HHmm`)

Example: `viewdone from/2021-09-01 0000 to/2021-09-30 0000`

Expected outcome:

```
1. [E][Done : Sep 26 2021 14:22] tba2105 project group discussion (at: Sep 14 2021 18:00)
2. [E][Done : Sep 20 2021 12:00] tba4001 project group discussion (at: Sep 15 2021 18:00)
3. [E][Done : Sep 26 2021 14:22] project A group discussion (at: Sep 14 2021 18:00)
4. [D][Done : Sep 25 2021 18:14] write proposal for project A (by: Sep 30 2021 18:00)
```

### `clear` - Clear all the tasks in the task list.

Syntax: `clear`

Expected outcome:

```
All the tasks are cleared
```
`list`
Expected outcome:

```
There isn't any tasks in the list.
```

### `help` - Shows Duke commands instructions.

Syntax: `help`

Expected outcome:

```
||todo: Adds a Todo Task to the task list. 
Syntax: todo DESCRIPTION
Example: todo borrow book
||deadline: Adds a Deadline task to the task list.
Syntax: deadline DESCRIPTION by/TIME(YYYY-MM-dd HHmm)
Example: deadline return book by/2019-12-01 1200
||event: Adds an Event task to the task list.
Syntax: event DESCRIPTION at/TIME(YYYY-MM-dd HHmm)
Example: event project meeting at/2019-12-01 1200
||clear: clear all the tasks in the task list.
||delete: delete a task from the task list based on the index.
Syntax: delete INDEX
Example: delete 2 (this will remove the No.2 task from the task list.)
||done: mark a task as done status, there are two syntax.
Syntax 1(without finish time): done INDEX
Example: done 2 (this command will mark the No.2 task as Done status and the default finish time is the current time)
Syntax 2(with finish time): done INDEX on/TIME(YYYY-MM-dd HHmm)
Example: done 2 on/2019-12-01 1200(this command will mark the No.2 task as Done status and finish time is 01 Dec 2019 12:00
||find: finds the specific tasks based on the keywords you entered.
there is a optional flag after find:
1 indicate 'isCombined' is true which means will only find the task(s) which match all the keywords combined
0 indicate 'isCombined' is false which means will find the task(s) which match all the keywords separately
if omit this flag will default 1
Syntax: find (optional: 0|1) KEYWORDS
Example: find book(will return the task that contains the keyword book.
||help: Shows program usage instructions.
||list: list the all the tasks in the task list.
||sort: sort the all the tasks in the task list by finish date in descending order.
||viewdone: view the finished tasks done during a specific period.
Syntax: viewdone from/TIME to/TIME (all the time format is YYYY-MM-dd HHmm)
Example: viewdone from/2019-08-08 0800 to/2019-12-12 1200
||bye: Exit the program and save the changes to the txt file.

```
- If enter anything that Duke is not able to read, it will auto show the help instructions

### `bye` - Exit the program and save the changes to the txt file as well.

Syntax: `bye`

Expected outcome:

```
See you next time.
```

