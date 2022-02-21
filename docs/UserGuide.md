# User Guide
Duke is a chat-bot application that helps you to manage your daily tasks through command line interface.
* [Quick Start](#quick-start)
* [Features](#features)
    * [Adds a todo task](#adds-a-todo-task)
    * [Adds an event task with date](#adds-an-event-task-with-date)
    * [Adds an event task without date](#adds-an-event-task-without-date)
    * [Adds a deadline task with date](#adds-a-deadline-task-with-date)
    * [Adds a deadline task without date](#adds-a-deadline-task-without-date)
    * [Marks task(s) as done](#marks-task(s)-as-done)
    * [Deletes task(s)](#deletes-task(s))
    * [Lists all task(s)](#lists-all-task(s))
    * [Finds task(s) with specific task type](#finds-task(s)-with-specific-task-type)
    * [Finds task(s) based on date](#finds-task(s)-based-on-date)
    * [Finds task(s) based on from date](#finds-task(s)-based-on-from-date)
    * [Finds task(s) based on date range](#finds-task(s)-based-on-date-range)
    * [Sort all task(s) by task types](#sort-all-task(s)-by-task-types)
    * [Saves all task(s)](#saves-all-task(s)])
    * [Exit programme ](#exit-programme])
* [FAQ](#faq)
* [Command Summary](#command-summary)

## Quick Start
1. Ensure you have java 11 or above installed in your computer
2. Download the latest Duke.jar file from [here](https://github.com/Elxyng/ip/releases)
3. Copy the file to the folder you want to use as a home folder for your Duke.
4. Duuble-click the file to start the app.
5. Type the command in the command input box and press `Enter` key or `Send` button to execute.
6. Refer to the **Features** below for details of each command.

## Features
### Adds a todo task - `todo <description>`

Adds a todo task to the current tasklist

Example of usage: 

`todo report`

Expected outcome:

```
Got it. I've added this task:
[T][ ] report
Now you have <numberOfTasks> tasks in the list.
```

### Adds an event task with date - `event <description> /at <date>`

Adds an event task with date to the current tasklist

Example of usage: 

`event wedding /at 2 aug 2021`

Expected outcome:

```
Got it. I've added this task:
[E][ ] wedding (at: 02 Aug 2021)
Now you have <numberOfTasks> tasks in the list.
```

### Adds an event task without date - `event <description>`

Adds an event task without date to the current tasklist

Example of usage: 

`event exhibition`

Expected outcome:

```
Got it. I've added this task:
[E][ ] exhibition (at: Date not specified)
Now you have <numberOfTasks> tasks in the list.
```

### Adds a deadline task with date - `deadline <description> /by <date>`

Adds a deadline task with date to the current tasklist

Example of usage: 

`deadline assignment /by 12 sep 2021`


Expected outcome:

```
Got it. I've added this task:
[D][ ] assignment (by: 12 Sep 2021)
Now you have <numberOfTasks> tasks in the list.
```

### Adds a deadline task without date - `deadline <description>`

Adds a deadline task without date to the current tasklist

Example of usage: 

`deadline bills`

Expected outcome:

```
Got it. I've added this task:
[D][ ] bills (by: Date not specified)
Now you have <numberOfTasks> tasks in the list.
```

### Marks task(s) as done - `done <index>`

Marks a todo/event/deadline task(s) as done to the current tasklist

Example of usage: 

`done 1,2`

Expected outcome:

```
Nice! I've marked this task(s) as done:
[T][X] report
[E][X] wedding (at: 02 Aug 2021)
```

### Deletes task(s) - `delete <index>`

Deletes todo/event/deadline task(s) in the current tasklist

Example of usage: 

`delete 1,2`

Expected outcome:

```
Noted. I've removed this task:
[T][X] report
[E][X] wedding (at: 02 Aug 2021)
Now you have <numberOfTasks> tasks in the list.
```

### Lists all task(s) - `list`

Lists all task(s) in the current tasklist

Example of usage: 

`list`

Expected outcome:

```
Here are the tasks in your list:
1. [D][ ] assignment (by: 12 Sep 2021)
2. [D][ ] presentation (by: 01 Dec 2021)
3. [T][ ] fetch mum
4. [E][ ] meeting (at: 08 Jun 2021)
5. [E][ ] workshop (at: 17 Jul 2021)
6. [D][ ] bills (by: Date not specified)
7. [E][ ] exhibition (at: Date not specified)
```
### Finds task(s) with specific task type - `find all <tasks>`

Finds todo/event/deadline task(s) in the current tasklist

Example of usage: 

`find all event`

Expected outcome:

```
Here are the tasks in your list:
1. [E][ ] meeting (at: 08 Jun 2021)
2. [E][ ] workshop (at: 17 Jul 2021)
3. [E][ ] exhibition (at: Date not specified)
```

### Finds task(s) based on date - `find <tasks> on <date>`

Finds todo/event/deadline task(s) based on date in the current tasklist

Example of usage: 

`find event on 8 jun 2021`

Expected outcome:

```
Here are the tasks in your list:
1. [E][ ] meeting (at: 08 Jun 2021)
```

### Finds task(s) based on from date - `find <tasks> from <date>`

Finds todo/event/deadline task(s) based on from date in the current tasklist

Example of usage: 

`find event from 1 jul 2021`

Expected outcome:

```
Here are the tasks in your list:
1. [E][ ] workshop (at: 17 Jul 2021)
```

### Finds task(s) based on date range - `find <tasks> between <date> to <date>`

Finds todo/event/deadline task(s) based on date range in the current tasklist

Example of usage: 

`find event between 1 apr 2021 to 20 jun 2021`

Expected outcome:

```
Here are the tasks in your list:
1. [E][ ] meeting (at: 08 Jun 2021)
```

### Sort all task(s) by task types - `sort`


Sort all task(s) by task types in the current tasklist

Example of usage: 

`sort`

Expected outcome:

```
Here are the tasks in your list:
[D][X] assignment (by: 12 Sep 2021)
[D][x] presentation (by: 01 Dec 2021)
[D][] bills (by: Date not specified)
[E][] meeting (at: 08 Jun 2021)
[E][] workshop (at:  17 Jul 2021)
[E][] exhibition (at:  Date not specified)
[T][] fetch mum
[T][] report
```

### Saves all task(s) - `save`

Saves all task(s) in the current tasklist

Example of usage: 

`save`

Expected outcome:

```
Tasks saved!
```

### Exit programme - `bye`

Exit Duke

Example of usage: 

`bye`

Expected outcome:

Exit Duke.

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Just follow the step below:
1. Just copy the txt file in the data folder from the current computer. 
2. Create a data folder in the same path as the executable file in the other computer.
3. Put the txt file there. 

## Command Summary

**Action** | **Format** | **Examples**
------------- | ----------------- | -------------------
**todo** | ```todo <description>``` | ```todo report```
**event** | ```event <description> /at <date>``` | ```event wedding /at 2 aug 2021```
**event** | ```event <description>``` | ```event exhibition```
**deadline** | ```deadline <description> /by <date>``` | ```deadline assignment /by 12 sep 2021```
**deadline** | ```deadline <description>``` | ```deadline bills```
**done** | ```done <index>``` | ```done 1,2```
**delete** | ```delete <index>``` | ```delete 1,2```
**list** | ```list``` | ```list```
**find** | ```find all <tasks>``` | ```find all event```
**find** | ```find <tasks> on <date>``` | ```find event on 8 jun 2021```
**find** | ```find <tasks> from <date>``` | ```find event from 1 jul 2021```
**find** | ```find <tasks> between <date> to <date>``` | ```find event between 1 apr 2021 to 20 jun 2021```
**sort** | ```sort``` | ```sort```
**save** | ```save``` | ```save```
**bye** | ```bye``` | ```bye```