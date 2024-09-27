# Duke project template

This is a project template for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project first)
1. Open the project into Intellij as follows:
   1. Click `Open`.
   1. Select the project directory, and click `OK`.
   1. If there are any further prompts, accept the defaults.
1. Configure the project to use **JDK 11** (not other versions) as explained in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
3. After that, locate the `src/main/java/Duke.java` file, right-click it, and choose `Run Duke.main()` (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:
   ```
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   ```

# User Guide

## Features

### Listing all task - Command : list

Shows a list of all tasks in the task list.

Format: [list]

#### example: 

`list`


### Add to-do task - Command : todo
Adds todo task to the list.

Format: [todo] [description]

#### example:
`todo read book`

### Add event task - Command : event
Adds event task to the list.

Format: [event] [description] [/at] [Location]

#### example:

`event Study Session /at NUS Computing.`

### Add task with deadline - Command : deadline 
Adds deadline task to the list.

Format: [deadline] [description] [/by] [yyyy-mm-dd HHMM]

#### example:

`deadline Duke Project ip /by 2021-01-01 1212`

### Mark tasks as done - Command : done

Updates a selected task's status as done in the list.

Format: [done] [Task’s index in list]

#### example:

`done 1`
### Deleting a task: delete

Deletes task from list. List will be updated

Format: [delete] [Task’s index in list]

#### example:

`delete1`

### Finding a task: find

Search for a task based on keyword

Format: [find] [keyword]

#### example:

`find book`

### Exiting duke: bye

This will exit the application.

Format: [bye]

#### example:

`bye`

`Bye`

# Sample Flow

Sequential order

`todo read book`

`list`

`done 1`

`list`

`deadline Duke Project ip /by 2021-01-01 1212`

`list`

`event Study Session /at NUS Computing.`

`list`

`find book`

`done 2`

`done 3`

`list`

`delete 1`

`list`

`bye`

# How to Run Jar File

`Step 1:`

`copy jar file to empy directory`

`type cmd in explorer header`

`type java -jar <jar file name>`

