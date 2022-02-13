# Developer Guide

## Setting up, getting started
**Refer to the guide** <a href="https://github.com/nus-tic4002-AY2122S2/ip">
Setting up and getting started.</a>

## Design 

* *Architecture*
* *UI component* (CLI, Input/ Output)  
* *Logic component* (Execution, Command, Parser)
* *Model component* (Item, Expense, Income)
* *Storage component* (Storage)
* *Common classes* (ItemList)




## Implementation (Sequence Diagram)


* Find Command
<br> The user execute `find KEYWORD` command to search tasks contain `KEYWORD` in the 
task list.
<br> The working flow of the findCommand is shown in the sequence diagram below.

![Image of find command](./GUI_Find Task Sequencial Diagram.png)

* List Command <br>
The user execute `list` command to show all the tasks in the list.<br/>
UI scanned `list` command from user, `Execution` create a new `ListCommand` 
and `run()` to get the tasks from Arraylist, taskList return the tasks to GUI 
and show to user. <br/>

![Image of list command](./GUI_List Command Sequencial Diagram.png)

* Delete Command
<br> The user execute `delete 5` command to delete the 5th task in the task list.
<br> The `Execution` type variable will be generated after user input scanned 
and in execution variable, the `Delete` command will be created 
and `run()` method in `Delete` class will be executed to remove the 5th item. 
After the task be removed, the delete information will be printed to show user 
which the deleted task's details and remaining task quantity in the task list.

![Image of todo command](./GUI_Delete Task Sequencial Diagram.png)

* Todo Command
<br> The user execute `todo take taxi` command to add the todo task which the
description is `take taxi` and which the task type is `todo` to the task list. 
<br> The `todo` type variable will be generated after user input scanned and
 in execution variable, the `addCommand` will be generated and `execute()` method 
 in `addCommand` will add the todo task to task list
 
![Image of todo command](./GUI_todo Task Sequencial Diagram.png)

* Deadline Command
<br> The user execute `deadline sleep /by 2022-02-11 22:59` command to add the
deadline task which the description is `sleep` and the deadline is `2022-02-11 22:59`
The task type is `d` which standard for deadline. The `todo` type variable will 
be generated after user input scanned and in execution variable, the `addCommand` 
will be generated and `execute()` method in `addCommand` will add the deadline task 
to task list

![Image of deadline command](./GUI_deadline Task Sequencial Diagram.png)

* Event Command
<br> The user execute `event party /at 2022-02-11 22:59 -> 2022-02-12 16:00` command to add the
deadline task which the description is `sleep` and the deadline is `2022-02-11 22:59`
The task type is `d` which standard for deadline. The `todo` type variable will 
be generated after user input scanned and in execution variable, the `addCommand` 
will be generated and `execute()` method in `addCommand` will add the deadline task 
to task list

![Image of event command](./GUI_event_Task_Sequencial_Diagram.jpg)


## Appendix: Requirements

### Product scope

**Target user profile**



### User Stories





### Use Cases






### Glossary

**Mainstream OS**:  Windows, Linux, Unix, OS-X

## Appendix:  Instructions for manual testing

### Instructions for manual testing

{Give instructions on how to do a manual product testing 
e.g., how to load sample data to be used for testing}








