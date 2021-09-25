## User Guide

Air Rec is a desktop app for managing flight records, optimized for use via a Command Line Interface (CLI). User will not have to remember flight details and it can be found easily with commands.

1. Quick start
1. Features
	1. Adding a flight: add
	1. Showing all flights: show all
	1. Showing upcoming flight: show upcoming
	1. Deleting a flight: delete
	1. Exiting the program : exit

1. FAQ
1. Command summary





## Quick Start

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Ensure you have Java 11 or above installed in your computer.
2. Download the latest airrec.jar from here.
3. Copy the file to the folder you want to use as the home folder for your Air Record.
4. Double-click the file to start the app. The GUI will greet you with:

```
    
Hi I’m AIR REC, I can help you save all the flight details!
How can I assist you today?”
	
   ```
 5. Type the command in the command box and press Enter to execute it. e.g. typing list and pressing Enter will display all task that you have saved so far in the window.
Some example commands you can try:

	1. add /departing Australia /destination Singapore /date 10 Jan 2021 12:00 /price 500: Add a trip departing from Australia to Singapore on 10 Jan 2021 12pm with a price of $500

	1. show all: List out all flight details

	1. show upcoming: List out the flight that is the first index of the list

	1. delete3 : Deletes the 3rd flight shown in the current list.

	1. exit : Exits the application.

6. Duke has auto-save and auto-load function. The list is being save as a text file named "Duke.txt" which is auto created and overwritten in the root folder.

7. Refer to the Features below for details of each command.

## Features

<b>Notes about the command format:</b>

	1. Date and time format are as shown: yyyy-mm-dd HHMM

### Adding a flight: add

Adds a new flight trip to the list.

Format: [add] [/departing] [depart details] [/destination] [destination] [/date] [date & time of departure] [/price] [price of trip]

Example: 

add /departing Australia /destination Singapore /date 10 Jan 2021 12:00 /price 500


### Showing all flights: show all

List out all flight trip

Format: [show] [all]

Example:

show all


### Showing upcoming flight: show upcoming

List out the first index of the flight in the list

Format: [show] [upcoming]

Example: 

show upcoming


### Deleting a flight: delete

Deletes a trip from the list

Format: [delete] [index]

Example:

delete 3

### Exiting the program : exit

Exits the application.

Format: [exit]

Example:

exit


## FAQ

<b>Q</b>: How do I save multiple trip?
<b>A</b>: You only can save one trip at a time.

## Command summary

Action | Format, Examples
------------ | -------------
<b>add</b> | Format: [add] [/departing] [depart details] [/destination] [destination] [/date] [date & time of departure] [/price] [price of trip] Example: add /departing Australia /destination Singapore /date 10 Jan 2021 12:00 /price 500
<b>show all</b> | Format: [show] [all] Example: show all
<b>show upcoming</b> | Format: [show] [upcoming] Example: show upcoming
<b>delete</b> | Format: [delete] [index] Example: delete 3
<b>exit</b> | Format: [exit] Example: exit