# Developer Guide

## Acknowledgements

[https://se-education.org/](https://se-education.org/)

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}


Overview
![image](https://user-images.githubusercontent.com/43517460/141647688-eaeb4429-adce-4b07-8880-19a1ec8c8265.png)


Command component
![image](https://user-images.githubusercontent.com/43517460/141647430-0364958b-006a-407a-aa2e-873ea0b65c1b.png)

Module component
![image](https://user-images.githubusercontent.com/43517460/141647609-91b453de-9d9f-44f6-b72a-332efaa60474.png)


## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that ...|
|--------|----------|---------------|------------------|
|v1.0|new user|know what kind of command there are|I can what are the feature and how I can use them|
|v1.0|new user|know how to add a task |I can record the task to track|
|v1.0|new user|view the list of task |I can see all my task that I need to do|
|v1.0|new user|delete a task |If I keyed in wrongly, I can remove it|
|v1.0|new user|mark a task as done |I can know which task are done instead of deleting it from record|
|v1.5|semi-new user|save my task for future use|Once I switch on the app, the task I recorded previously are still there|
|v2.0|user|find a task using keywords|I can easily check for the information I need|
|v2.0|user|group my task to ToDo, Event and Deadlines |I can have more types of task to keep track and include time for specific task|
|v2.0|user|clear my current list of task |I don't have to delete one by one|
|v3.0|user|have a GUI instead of CLI | it feels more like a chatbot and look nicer|
|v3.0|user|be informed if I have keyed in a task with a similar description | I know I had keyed in a duplicated task|
|v3.0|user|have a countdown for closing of the app | I know that the app is responding and is closing|

## Non-Functional Requirements

- Each request should be processed within 3 seconds.
- Program to function properly on different operating systems.
- Program should have a 95 percent chance that the component can be fixed in 24 hours.
- Program should be available all time during a month.
- Program should not experience critical failure.



Non-Functional Requirements
Should work on any mainstream OS as long as it has Java 11 or above installed.
Should be able to hold up to 1000 tasks without a noticeable sluggishness in performance.
The system reacts to the given input is within a few seconds.
The system allows developers to add in more functions or extent the function through modification of exiting functionality.
The command should be simple enough so that users are able to accomplish most of the tasks faster using typing than using the mouse.
Should be easy for new users to get used to usage fast.

Glossary
Mainstream OS: Windows, Linux, Unix, OS-X