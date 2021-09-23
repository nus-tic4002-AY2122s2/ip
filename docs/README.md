# Duke User Guide

Table of contents



###1. General Information

####1.1 System Overview

Welcome to Duke! Duke is a simple use and useful system to help you to keep track of all your key dates for all your important task(s). These tasks can be classified into 'Todo', 'Event', 'Deadline' tasks. There are also some other features that Duke can do for you to manipulate the task you saved and for your convenience. Get start with Duke now!

####1.2 Organization of READ.me

The user's handbook contain 4 sections: 
1. General Information
2. Getting Started
3. Error Correction Instructions
4. Feedback and Contact Us

Section | Description
--- | ---
General Information |  An overview of what Duke system does and the purpose of the Duke 
Installation | To guide user to do installation of Duke
Features | Describe all features Duke contained
Usage | Describe all the keywords (actions) and its outcome
Error Correction Instructions | Show some possible errors user can make while using Duke
Feedback and Contact Us | Provide information to user to contact the creator of Duke

###2. Installation of Duke
You can go to my GitHub [Duke](https://github.com/YangShuogeng/ip) repository page and click the button clone or download and download the zip file. Once the zip file downloaded, extract the file and locate the Duke JAR file. You can assess the JAR file to startup Duke.

###3. Features
Here are the list of features of the Duke system:
1. Show all the task(s)
2. Add new task (three type task: Todo, Event, and Deadline)
    - Todo
    - Event
    - Deadline
3. Delete task
4. Find task
5. Mark task as done
6. bye

###4. Usage
####4.1 Commands

Here are the commands you can use to interact with Duke:

Commands | Description
--- | ---
list | Show the current entire list of task
todo [desc] | To add a Todo type task into the Duke system with description
deadline [desc] /by [deadline time] | To add a Deadline type task into the Duke system with description and deadline time
event [desc] /at [starting time] -> [ending time] | To add a Event type task into the Duke system with description, starting time, and ending time
find [keyword] | To find all task which the description contain the keyword
done [index] | To mark the specified task status as done in the task list
delete [index] | Tp delete the specified task from the task list
bye | Save the current task list to local and close Duke

Input time format: YYYY-MM-DD Hour(0-23):Minute(0-59)

####4.2 Examples:
Input: 
> todo read book

Expected outcome:

![Image of todoOutcome](https://github.com/YangShuogeng/ip/tree/master/images/outcome_todo.png)

 Input:
 > event project meeting /at 2021-09-25 11:00 -> 2021-09-25 12:30

Expected outcome:

![Image of eventOutcome](https://github.com/YangShuogeng/ip/tree/master/images/outcome_event.png)

Input:
> deadline return book /by 2021-12-12 18:00

Expected outcome:

![Image of deadlineOutcome](https://github.com/YangShuogeng/ip/tree/master/images/outcome_deadline.png)

Input:
> list

Expected outcome:

![Image of listOutcome](https://github.com/YangShuogeng/ip/tree/master/images/outcome_list.png)

Input:
> done 2

Expected outcome:

![Image of doneOutcome](https://github.com/YangShuogeng/ip/tree/master/images/outcome_done.png)

Input:
> delete 1

Expected outcome:

![Image of deleteOutcome](https://github.com/YangShuogeng/ip/tree/master/images/outcome_delete.png)

Input:
> list

Expected outcome:

![Image of lastListOutcome](https://github.com/YangShuogeng/ip/tree/master/images/outcome_lastList.png)


Input:
> bye

Expected outcome:

![Image of byeOutcome](https://github.com/YangShuogeng/ip/tree/master/images/outcome_bye.png)

###5. Error Correction Instructions

Here are some errors that user may encounter when using Duke:
- DukeTaskInputException: The input task format wrong, such as missing description
- DukeDateTimeError: The input task's date/time format wrong

###6. Feedback and Contact Us
Thanks for using Duke. Please feel free to drop the developer a feedback in order to improve Duke!
You can reach me by the following information:
1. +65 84300587
2. michealyang1994@gmail.com


