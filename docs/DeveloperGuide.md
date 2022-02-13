# Developer Guide

## Acknowledgements

- [Jenkov.com Tech and Media Labs JavaFx Tutorials](http://tutorials.jenkov.com/javafx/index.html) 
- [SE_EDU JavaFx tutorial](https://se-education.org/guides/tutorials/javaFx.html)
- Raoul-Gabriel Urma, Mario Fusco, Alan Mycroft, *Modern Java in Action: Lambdas, streams, functional and reactive programming 2nd Edition*, Manning, 2018. 
- Developer: **Gwee Yeu Chai**  


## Design

**LisGenie GUI App** leverages on the help of a total 13 Java classes, viz. **Duke, Parser, Task, Tasklist, Todo, Deadline, Event, Launcher, DukeException, Storage** for the 
main app logic support and **Main, MainWindow, DialogBox** for the JavaFx GUI support, together with 2 auxiliary fxml files **DialogBox.fxml and MainWindows.fxml**. Judicious use 
of Java API LinkedHashset<Task>'s non-duplicates properties, preserved input data order and fast location traits, for Tasks storage, allows a single user good at the keyboard 
to make, enquire, delete or register bookings or current status of appointments online fast.

- LisGenie Chatbot GUI App is an extension or GUI version of the CLI app **LisGenie ChatBot Task Manager 2.0**    
- It allows for command short forms which were not available last time round
- The visual interface is designed for easy reading and takes into considerations the computer-human interactions principles, for a simple esthetic appeal of each essential
visual component affording easy usage, so user will not find using the App intimidating or boring 


## Implementation

### Integration of Duke Class with JavaFx GUI Program

#### Highlights:
1) Duke Class is modified so that all processed outputs to console are configured and redirected to a class-level ByteArrayOutputStream _newConsole_. This affords easy 
  redirection of captured messages into LisGenie GUI chatbox via the _handleUserInput method_ found inside MainWindow controller Class (which handles-cum-chatbot messages display).    
2) An instance of Duke Class is created in Main Class to load and enable the main app logic flows subsequently
3) The MainWindow Class carries a setDuke method that will create a first Greeting Meesage from LisGenie chatbot, upon app opening. It also handles property binding for the 
  scrollPane _vvalueProperty_ to the dialogueContainer _heightproperty_
4) Subsequently, the user will type into the textfield and either press enter or sendButton to begin conversations with the chatbot
5) All necessary JavaFx event handlers are set via the MainWindow.fxml file.
  

#### Design considerations:
Considerations in the design of app logic have been specially given for the optimization of operations in terms of time and space complexity wherever possible. 
In terms of class design principles, Single Responsibility Principle is adhered to rather well. This allows strong cohesion with minimal coupling for those
classes, especially for the seperating out of the program logic parts from the GUI parts. From early on, the main code base follows the Open-Closed Principle closely as the 
author intends for easy refactoring and felicitous code extensions "lego-style" any time. This will save precious time and uncalled for headaches later on.
I have attempted to keep the code KISS as much as possible, whereby the program flow is simple and uncluttered. Furthermore, variable names and functions method names are also rather
intuitive, improving the readability for the code reader.

In a nutshell, the design patterns and principles were implemented OOP style throughout for easy scalability and modularity.
With this approach, the earlier set down framework / design policies allows for more features to be added on faster while still keeping in check the complexity (such as coupling) 
of the application body codes.

## Product scope
**Target user profile:**

- has a need to manage a number of fast bookings
- prefer desktop apps vs other types
- can type fast
- prefers using the keyboard over mouse interactions
- is reasonably comfortable using CLI apps

**Value proposition:** manage contacts faster than a typical mouse/GUI driven app


### Target user profile

Target User: John

Age: 18 (typical)

Occupation: Student

Education: Currently in Poly or JC

Commitments: CCAs, recreational activities, Studies

Traits: Is technologically literate, active in activities, comfortable typing commands

Our target user is a Student that is currently schooling. As an active student, the Target User has multiple activities that may be hard to keep track of. With the scheduler, John will be able to plan and organize multiple appointments at the same time.


### Value proposition


JustBook provides a user-friendly, consistent and error-free interface, as well as helpful message feedback or alerts to users, throughout the app use. The scheduler can be customized into working on the basis of various time durations (6 months, monthly, weekly etc.). Using the CLI-type interface, the user will be able to edit multiple appointments easily with minimal commands / single commands.

Users are able to make, check, delete, view, change, and source in real-time for available slots for appointments using this application. This application will display a range of time slots available for users to choose from, may also list available dates and unavailable dates when the User is trying to schedule an appointment. The User can also choose to work on a 6-calendar-months view / basis (coming feature), or per month, per week, down to a day’s view / basis.  

Possible enhancements include appointment data printout, a file backup in the background to act as a redundancy measure for unforeseen disruption, alerts for the User if so scheduled, etc. 

Our Value Proposition is that our scheduler provides, throughout the app use, a consistent, user-friendly and error-free interface, assisting message feedback or alerts and a capability to suggest time slots to the user, in addition to the time slots available (coming feature). The scheduler can be customized to work on the basis of various time durations (monthly, weekly, daily etc.). Using the CLI-type interface, the user will be able to edit multiple appointments easily with minimal commands / single commands.


## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see help usage instructions|refer to them when I forget how to use the application|
|v1.0|regular user|I can add in a booking entry in one line|make an entry and have it stored online fast|
|v1.0|a quick user|I can edit a booking entry description|modify an entry description easily at will|
|v1.0|date planner|I find a booking item by date|locate a to-do without having to go through the entire list|
|v1.0|efficient student|I can order all my tasks and appointment by their due date|order all my tasks and appointment by their due date|
|v1.0|systematic student|I can see my list upfront |know what tasks I have clear for the day|
|v1.0|active student|I can view the block of outstanding schedules for the month displayed (coming feature)|check if I can add further bookings for that month|
|v1.0|fast-moving student|I can view the the day's block of remaining schedules|remind myself of the schedules done and which ones left to attend to that day|
|v1.0|studious student|I can input a blocking period into the database|so that I'm unable to book within that critical period|
|v2.0|student|I can save or load at start up my appointments and schedule|not need to re-create them everytime I log in|
|v2.0|structured student|I can see my appointments arranged together and tasks arranged together|have a clear distinct view of appointments and tasks|
|v2.0|student who always does late minute work|I want to see tasks or appointments going to be due being highlighted to me in ordered deadline date and time|can meet the deadline (coming feature)|
|v2.0|social student|I can view the block of weekend outstanding schedules for the entire current month displayed|check if I can add further bookings for the weekends|
|v2.0|busy student|I can quit the application immediately with an automatic save|move on to my other activities quickly|


## Non-Functional Requirements
1. Users are able to run the application as long as Java11 is installed
2. The application has been designed to handle up to 100’s of user appointments optimally without affecting its performance.
3. The application should preferably be executable on Windows OS or compatible software-emulated terminal.
4. User-friendly features incorporated in helpful messages feedback and diagnostic prompts (more to come) 


## JustBook's Process Workflow

![workflow](JustBook_process_diag.png)

Fig 4. - JustBook App Activity Diagram<br/><br/>
The diagram illustrates the possible branches leading to various outcomes based on the user's decisions.

The model illustrates a possible regular process flow of a user starting up the JustBook application with an upcoming feature.
The user launches the application and is prompted to log in: if the user does not have an account within the application,
the user will be prompted to create an account and redirected to log in again _(coming feature)_. Following that, the 
user is presented with options on utilising the application as illustrated in the diagram. Current version has the user
enter a chosen username instead.


## Glossary

* **Mainstream OS** - Windows, Linux, Unix, OS-X
* **JustBook App**  - A single-user command line app for making and storing student bookings online 
* **CLI**           - Command Line Interface
* **booking**       - A typed entry consisting of booking text description, a start DateTime and end DateTime 
* **ISO (time standard)** - For Java time Standards, it follows this format: "yyyy-MM-dd HH:mm"
* **DateTime**     - Java LocalDateTime implemented with format as "yyy-M-d HH:mm", using a 24 hr format

## Instructions for manual testing

- Ensure Java jdk 11 is installed
- Download the justbook.jar file from Release v2.0
- Obtain a sample test file, e.g. justbook.txt with saved entries (correctly formatted)
- Copy the sample test file to a local folder named data
- start up the app, eg.` java -jar justbook.jar` via a windows cmd or compatible terminal
- Type in a username of your choice
- Type `show --all` or `show all` to check the display list tallies with those saved in the justbook.txt file
- Sample instruction:

<img width="552" alt="Screenshot 2021-10-22 at 12 40 41 PM" src="https://user-images.githubusercontent.com/88772711/138399952-42c4ebfa-ac1a-4a35-922b-c9979d7b1402.png">

## Instructions for IO/Regression testing
1. Navigate to text-ui-test folder
2. Depending on your (User's) OS, if Windows, run runtestmain.bat, if Linux or macOS, navigate to the test folders and run runtest.sh
3. The CMD window or shell output will display if the comparison between the expected output and actual output are the same
4. If there are any differences, they will be displayed at the CMD or shell window as well.
5. The regression test would have passed if no differences are found.
