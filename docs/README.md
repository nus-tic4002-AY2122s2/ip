# User Guide
Duke is a desktop app for managing your daily tasksi via _command line interface_ (CLI). 

## Features 

### Task Types
There are 3 types of task that Duke recognizes – Todo, Event and Deadline:  
+ Todo is a simple task with title only; 
+ Event is a task with a date and a time range (e.g. `/at 2022-01-04 1700-1925`);
+ Deadline is a task with due date and time (e.g. `/by 2022-01-20 945`).

### Operations
Besides creation of the above mentioned tasks, Duke provides basic functionalities to manipulate the tasks, such as: 
+ [list all the tasks](#cmd---List-all-commend-keywords)
+ [list all the command keywords](#list---List-all-tasks)
+ [mark one or multiple tasks done at once](#done---Mark-selected-tasks-done)
+ [delete one or multiple tasks done at once](#delete---Delete-seleted-tasks)
+ [find tasks that contains certain keywords](#find---Find-tasks-containing-keywords)

### Storage
The program will create a `./data` folder (under same directory where user stores the `jar` file), under which a text file called `duke.txt` will store the tasks in plain text. So when the program starts next time, all the record can be read and retrived. 

## Usage

### `cmd` - List all command keywords

Format: `cmd`

Expected outcome:

```
 bye
 list
 todo
 find
 cmd
 event
 deadline
 done
 delete
```
### `list` - List all tasks

Format: `list`

Example outcome:
```
 1. [T][✓] world peace
 2. [T][ ] seek love
 3. [T][✓] end pandemic
 4. [T][✓] try stream map filter
 5. [E][ ] meeting with board (at: 01.Jan.22 09:00 - 15:30)
 6. [D][✓] submit homework (by: 27.Sep.21 23:59)
```
### `done` - Mark selected tasks done

Format: `done INDEX1 INDEX2 ... INDEXN`
- `INDEX` are the number in front of tasks shown by `list` command

Example: `done 1 2`

Expected outcome:
```
 Marked below as DONE:
 [T][✓] world peace
 Task completion status: 4 / 7
 Marked below as DONE:
 [T][✓] seek love
 Task completion status: 5 / 7
```

### `delete` - Delete selected tasks 

Format: `delete INDEX1 INDEX2 ... INDEXN`
- `INDEX` are the number in front of tasks shown by `list` command

Example: `delete 8 9`

Expected outcome:
```
 Roger. Below get removed: 
 [T][ ] 1
 [T][ ] 2
 Task completion status: 5 / 7
```

### `todo` - Add Todo

Format: `todo TITLE`

Example: `todo buy milk`

Expected outcome:
```
 added: [T][ ] buy milk
 Task completion status: 5 / 8
```

### `event` - Add Event at date time range 

Format: `event TITLE /at DATE TIME-TIME`
- recommended date time range format: `yyyy-MM-dd HHmm-HHmm`

Example: `event meeting with board /at 2022-01-01 0900-1530`

Expected outcome:
```
 added: [E][ ] meeting with board (at: 01.Jan.22 09:00 - 15:30)
 Task completion status: 5 / 8
```

### `deadline` - Add Deadline by date time

Format: `deadline TITLE /by DATE TIME`
- recommended date time range format: `yyyy-MM-dd HHmm`

Example: `deadline submit homework /by 2021-09-27 2359`

Expected outcome:
```
 added: [E][ ] submit homework (by: 27.Sep.21 23:59)
 Task completion status: 5 / 8
```

### `find` - Find tasks containing keywords

Format: `find KEYWORDS`

Example: `find map`

Expected outcome:
```
	1. [T][✓] try stream map filter
```

