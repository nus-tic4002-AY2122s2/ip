
## AIR REC - TEAM 5

Air Rec is a desktop app for managing flight records, optimized for use via a Command Line Interface (CLI). User will not have to remember flight details and it can be found easily with commands.

1. Quick start
2. Features
    1. Adding a flight: `add`
    2. Showing all flights: `show all`
    3. Showing upcoming flight: `show upcoming` [to be implemented in v3.0]
    4. Deleting a flight: `delete`
    5. Help: `help`
    6. Search a flight: `search`
    7. Exiting the program : `bye`

3. FAQ
4. Command summary





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

    1. add /from Australia /to Singapore /date 2021-10-31 1400 /price 500: Add a trip departing from Australia to Singapore on 31 Oct 2021 2pm with a price of $500

    2. show all: List out all flight details

    3. show upcoming: List out the flight that is the first index of the list

    4. delete 3 : Deletes the 3rd flight shown in the current list.

    5. exit : Exit the application.

6. Duke has auto-save and auto-load function. The list is being save as a text file named "Duke.txt" which is auto created and overwritten in the root folder.

7. Refer to the Features below for details of each command.

## Features

<b>Notes about the command format:</b>

	1. Date and time format are as shown: yyyy-mm-dd HHMM

### Adding a flight: add

Adds a new flight trip to the list.
NOTE: For version 1.1 Air Rec will be reading the descriptions after add as a full string. We will work on to process these strings into data on version 1.2 onwards.

Format: [add] [/from] [depart details] [/to] [destination] [/date] [date & time of departure] [/price] [price of trip]

Example: 

add /from Australia /to Singapore /date 2021-10-31 1400 /price 500


### Showing all flights: `show all`

List out all flight trip

Format: [show] [all]

Example:

show all


### Showing upcoming flight: `show upcoming`

List out the first index of the flight in the list

Format: [show] [upcoming]

Example: 

show upcoming


### Deleting a flight: `delete`

Deletes a trip from the list

Format: [delete] [index]

Example:

delete 3


### Help: `help`

Get Support

Format: [help]


### Search a flight: `search`

Search a trip from the list

Format: [search] [keyword]

Example:

search Australia


### Exiting the program : `exit`

Exits the application.

Format: [bye]

Example:

bye


## FAQ

<b>Q</b>: How do I save multiple trip?

<b>A</b>: You only can save one trip at a time.

## Command summary

Action | Format, Examples
------------ | -------------
<b>add</b> | Format: [add] [/departing] [depart details] [/destination] [destination] [/date] [date & time of departure] [/price] [price of trip] Example: add /departing Australia /destination Singapore /date 10 Jan 2021 12:00 /price 500
<b>show all</b> | Format: [show] [all] Example: show all
<b>show upcoming</b> | Format: [show] [upcoming] Example: show upcoming [to be implemented in v3.0]
<b>search</b> | Format: [search] [keyword] Example: search Australia
<b>help</b> | Format: [help] 
<b>delete</b> | Format: [delete] [index] Example: delete 3
<b>bye</b> | Format: [bye] Example: bye

