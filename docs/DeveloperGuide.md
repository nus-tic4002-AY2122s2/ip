# Developer Guide


## Design & implementation

  ![developer_guide drawio](https://user-images.githubusercontent.com/54314980/154280747-a0f4e6c7-96d7-4bf5-b627-c4ec5f907e4e.png)

Diagram 1.0 Overall flow of the system






![developer_guide_user drawio](https://user-images.githubusercontent.com/54314980/154280786-f840b5c5-3d2f-46fe-bbfa-6e2c94d94906.png)

Diagram 1.1 User interaction with the system

`DialogBox.getUserDialog(input),
DialogBox.getDukeDialog(input)`

Manage user input and the message return to the user.


## Product scope
### Target user profile

Students and working adults to manage their busy work/study lift easily with the help of the app.

Persona:
Mary is a part-time university student studying in bachelor of computer engineering in NUS. She has to work 5 days a week and she also took 3 modules in a semester.
She has to spend time arranging work deadlines and also manage how study at the same time.


### Value proposition

1. Time wastage.

Currently, with the tradition of handwritten in a calendar book, it takes time for user to find their task among those expired tasks. 
With this chatbot, users are able to search task using keyword.


2. Non-economic friendly.

Books are made up of papers and papers are from trees. The more book we use, more trees are cut down.


3. Static Non-Interactive.

All these specifications will be done interactively. User will input their task and the system will reply them with the result.

These make the task management more interactive and enjoyable as well as increasing the user experience while managing our heavy workload.


## User Stories

| As a ... | I want to ... | So that I can ...|

|--------|----------|---------------|------------------|

|new user|Be greeted by application “Hi I’m Duke. How can I assist you today?” |Be aware that the application is running.|

|user|Add a task |Not forget about the details.|

|user|Delete a task  |Free up the list.|

|user|View all tasks  | Refer to my past tasks that I've done before.|



## Non-Functional Requirements

NFR-1: Able to work any mainstream OS as long as it has Java 11 or above installed.


## Glossary

* *Mainstream OS* - Windows, Linux, Unix, Mac-OS.
