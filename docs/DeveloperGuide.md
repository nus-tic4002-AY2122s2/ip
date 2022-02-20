# Developer Guide

## Design

### Architecture
![ArchitectureDiagram](images/ArchitectureDiagram.png)

The *Architecture Diagram* above explains the high-level design of the app.
* `Launcher`: App entry point.
* `JavaFX` `Main`: Hold instance of `Duke`.
* `JavaFX` `MainWindow`:
  * Parent GUI of app.
  * Accept user input and trigger `Duke` logic.
* `Duke`: Main control of back-end logic.
* `Parser`: Make sense of user input.
* `Command`: Execute instruction.
* `Task`: Hold app data in memory.
* `Storage`: Read data from and write data to hard disk.
