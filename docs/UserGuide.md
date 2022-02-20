# User Guide

## Introduction

Duke is a simple use and useful system to help you to keep track of all your key dates for all your important task(s). These tasks can be classified into 'Todo', 'Event', 'Deadline' tasks. There are also some other features that Duke can do for you to manipulate the task you saved and for your convenience.

This version is use via a GUI.

## Quick Start

1. Ensure you have java 11 or above installed in your computer
2. Download the latest Duke.jar file from [here](https://github.com/YangShuogeng/ip/releases/tag/GUI-Release)
3. Copy the file to the folder you want to use as a home folder for your Duke.
4. Duuble-click the file to start the app.
5. Type the command in the command input box and press `Enter` key or `Send` button to execute.
6. Refer to the **Features** below for details of each command.

## Features

**Words in UPPER_CASE are the parameters to be supplied by the user.**

### Add a Task: `todo` or `deadline` or `event`

Adds a new todo task to the list.

Format: `todo DESCRIPTION`
* `DESCRIPTION`: name of task

Example: `todo take taxi`

Adds a new deadline task to the list.

Format: `deadline DESCRIPTION /by DATETIME`
* `DESCRIPTION`: name of task
* `DATETIME`: the deadline datetime information

Example: `deadline return book /by 2022-01-22 17:59`

Adds a new event task to the list.

Format: `event DESCRIPTION /at STARTINGDATETIME -> ENDINGDATETIME`
* `DESCRIPTION`: Name of task
* `STARTINGDATETIME`: The event task's starting datetime
* `ENDINGDATETIME`: The event task's ending datetime

Example: `event Birthday party /at 2022-01-22 18:00 -> 2022-01-23 08:00`

### List all tasks: `list`

List all tasks.

Format: `list`

Example: `list`

### Delete a task: `delete`

Delete a participate task from the list.

Format: `delete INDEX`
* `INDEX`: The task index

Example: `delete 3`

### Find task(s): `find`

Find task(s) by using keyword.

Format: `find KEYWORD`
* `KEYWORD`: The keyword used to find matched task(s)

Example: `find ook`

### Save the data

Duke data saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Edit the data file

Duke data are saved as a txt file ```[project_root]/data/dukeTasks.txt```. Advanced users are welcome to update data directly by editing that data file.

## FAQ

**Q**: How do I transfer my data to another computer?

**A**: To run and show the data in another computer, you need to install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous expense folder or save to the directory(```[project_root]/data```) directly

## Command Summary

**Action** | **Format** | **Examples**
------------- | ----------------- | -------------------
**todo** | ```todo DESCRIPTION``` | ```todo take taxi```
**deadline** | ```deadline DESCRIPTION /by DATETIME``` | ```deadline return book /by 2022-01-22 17:59```
**event** | ```event DESCRIPTION /at STARTINGDATETIME -> ENDINGDATETIME``` | ```event Birthday party /at 2022-01-22 18:00 -> 2022-01-23 08:00```
**list** | ```list``` | ```list```
**delete** | ```delete INDEX``` | ```delete 3```
**find** | ```find KEYWORD``` | ```find book```


