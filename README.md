# Set up
Current folder set up as below, shows java files and class files location:
```
├── out
│   └── production
│       └── ip
│           ├── duke.Duke.class
│           └── duke
│               ├── storage
│               │   └── tempTaskList.class
│               └── ui
│                   └── Message.class
├── src
│   └── main
│       └── java
│           ├── duke.Duke.java
│           └── duke
│               ├── storage
│               │   └── tempTaskList.java
│               └── ui
│                   └── Message.java
```

`tree` command can be used to reveal above folder structure. 

To compile the java files, run below command (change once new packages created): 
```
% javac -d out/production/ip src/main/java/duke/Duke.java src/main/java/duke/ui/* src/main/java/duke/storage/* 
```

To run the program in terminal. `cd` to project root dir, then run below: 
```
% java -cp out/production/ip/duke.Duke
```


----
# duke.Duke project template

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
3. After that, locate the `src/main/java/duke.Duke.java` file, right-click it, and choose `Run duke.Duke.main()` (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:
   ```
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   ```
