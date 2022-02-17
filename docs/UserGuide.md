# User Guide

## Introduction



## Quick Start

1. Ensure you have java 11 or above installed in your computer.
2. Download the latest EMS.jar from [here](https://github.com/AY2122S1-TIC4001-F18-2/tp/releases).
3. Copy the file to the folder you want to use as a home folder for your Expenses Management System.
4. Create an empty folder name ```file``` in the same folder.
5. Create an empty text file name ```expenses.txt``` inside the data folder.
6. Double-click the file to start the app.
7. Type the command in the command box and press Enter to execute. e.g typing “list” and pressing Enter will show the
   list of expenses. <br/>
   Some example commands you can try:
* Add an expense: `expense lunch /food /12 /12-10-2021`
* Add an income: `income Company A /salary /2000 /01-10-2021`
* List all items: `list`
* Delete an item: `delete 1`
* Search for item: `find salary`
* Edit an item: `edit 1 /income Company B /salary /3000 /01-10-2021`
* Sort all items: `sort`
* Summarize all items: `summary`
* Exit the program: `exit`
6. Refer to the **Features** below for details of each command.

## Features

**Words in UPPER_CASE are the parameters to be supplied by the user.**

### Add an expense: `expense`

Adds a new expense item to the list.

Format: `expense DESCRIPTION /CATEGORY /AMOUNT /DATE`
* `DESCRIPTION`: name of expense
* `CATEGORY`: category type of expense
* `AMOUNT`: amount of expense
* `DATE`: date of expense incurred

Example: `expense lunch /food /12 /12-10-2021`

### Add an expense: `income`

Adds a new income item to the list.

Format: `income DESCRIPTION /CATEGORY /AMOUNT /DATE`
* `DESCRIPTION`: name of income
* `CATEGORY`: category type of income
* `AMOUNT`: amount of income
* `DATE`: date of income received

Example: `income Company A /salary /2000 /01-10-2021`

### List all items: `list`

list all items.

Format: `list`

Example: `list`

### Delete a Expense: `delete`

Delete existing an item in the list.

Format: `delete INDEX`
* `INDEX`: index number of the item in the list

Example: `delete 1`

### Search items: `find`

Search the task with the keyword.

Format: `find KEYWORD`
* `KEYWORD`: the keyword to search

Example: `find salary`

### Edit item: `edit`

Edit the item in the list.

Format: `edit INDEX /TYPE DESCRIPTION /CATEGORY /AMOUNT /DATE`
* `INDEX`: index number of the item in the list
* `TYPE`: expense or income
* `DESCRIPTION`: name of new item
* `CATEGORY`: category type of new item
* `AMOUNT`: amount of new item
* `DATE`: date of new item

Example: `edit 1 /income Company B /salary /3000 /01-10-2021`

### Sort items: `sort`

Sort items in the list.

Format: `sort /ORDER /TYPE`
* `ORDER`: asc or desc
* `TYPE`: amount or date

Example: `sort /asc /date`

### Summarize all items: `summary`

Generate summary information of the list.

Format: `summary`

Example: `summary`

### Exit the program: `exit`

Exit the program.

Format: `exit`

Example: `exit`

### Save the data

EMS data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Edit the data file

EMS data are saved as a txt file ```[project_root]/file/expenses.txt```. Advanced users are welcome to update data directly by editing that data file.

## FAQ

**Q**: How do I transfer my data to another computer?

**A**: To run and show the data in another computer, you need to install the app in the other computer and overwrite the
empty data file it creates with the file that contains the data of your previous expense folder.

## Command Summary

**Action** | **Format, Examples**
------------ | -------------
**Expense** | ```expense DESCRIPTION /CATEGORY /AMOUNT /DATE``` e.g.,```expense lunch /food /12 /12-10-2021```
**Income** | ```income DESCRIPTION /CATEGORY /AMOUNT /DATE``` e.g.,```income Company A /salary /2000 /01-10-2021```
**List** | ```list``` e.g., ```list```
**Delete** | ```delete INDEX ``` e.g., ```delete 1```
**Find** | ```find KEYWORD``` e.g., ```find salary```
**Edit** | ```edit INDEX /TYPE DESCRIPTION /CATEGORY /AMOUNT /DATE``` e.g., ```edit 1 /income Company B /salary /3000 /01-10-2021```
**Sort** | ```sort /ORDER /TYPE``` e.g., ```sort /asc /date```
**Summary** | ```summary``` e.g., ```summary```
**Exit** | ```exit``` e.g., ```exit```
