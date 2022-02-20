# Developer Guide

## Acknowledgements

Project Duke's GitHub repository is available [here](https://github.com/Ruiting1/ip).

## Design & implementation

The basic data structure is an abstract class `Task`, and it has three main types (child class) :
- `T`-`Todo` - a simple todo task without any datetime needed
- `D`-`Deadline` - a deadline task with a /by datetime needed
- `E`-`Event` - a event task with a /at datetime needed

e.g.
```
[D][X] quiz submission (by: Oct 1 2021 23:59)
```
[x] is the status of the task.


`TaskList` is the main list that contains all the `Task`, it contains some basic method to operate on a task, e.g.

+ `removeTasks(List<Task> toRemove)` which is used to pass in a list of tasks that need to be deleted and then delete from the list.

As this a `CLI` based project, another main section is the `Command`, all the sub commands will be
- `AddCommand`
- `ClearCommand`
- `DeleteCommand`
- `DoneCommand`
- `ExitCommand`
- `FndCommand`
- `HelpCommand`
- `IncorrectCommand`
- `ListCommand`
- `SortCommand`
- `UpdateCommand`
- `ViewDoneCommand`

The above commands will extend to `Command` class.

`Parser` Class is used to handle the input that user entered to make sure can generate the correct command based on the input.

`Storage` Class have two main function `load()` and `save()`, which is used to load and save the task into a .txt file

### UML diagram
##whole class diagram
<img src="pic/ClassDiagram.png">



## User Stories

|Version| As a ... | I want to ... | So that I ...|
|--------|----------|---------------|------------------|
|v1.0|Todo app user|add a task to the list with different task types|can have a list to help me memory the things need to do|
|v1.0|Todo app user|be able to delete tasks|will not see too many tasks in the list|
|v1.0|Todo app user|mark a task as done status|can know that if I still have any outstanding tasks in the list|
|v1.0|new user|have a command that can show all the syntax instructions|can know what I need to type to achieve what I want|
|v1.0|new user|receive the notification when I type a wrong command|can know where I do wrong|
|v1.0|Todo app user|list down all my tasks|can have a basic view of the tasks|
|v1.0|forgetful user|find the tasks based on the keywords|will not lost when have too many tasks in the list|
|v1.0|Todo app user|clear all the tasks in the list|can start from the beginning instead of delete one by one when I don't need to go through the existing tasks anymore|
|v1.0|Todo app user|view the tasks that have been done already based on specific period|can have a basic statistic or dashboard view|
|v2.0|Todo app user|sort the tasks by the finish date descending order in the list|can see the outstanding tasks before the finished tasks|
|v3.0|Todo app user|update the tasks when necessary|don't need to delete the whole task when I try to modify anything|

## Non-Functional Requirements
+ The jar file should work on any mainstream OS as long as it has Java 11 or above installed.
+ program should be able to automatically generate the txt file based on the storage path instead of crash when no existing txt file
+ The application should be faster for those users who can type fast, compared with using mouse.


