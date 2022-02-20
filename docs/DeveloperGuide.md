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
* `TaskList`: Hold app data in memory.
* `Storage`: Read data from and write data to hard disk.
<br><br>

#### Interaction Between Architecture Components
The *Sequence Diagram* below shows how the components interact with each other for scenario when the user issues command `todo borrow book`.

![ArchitectureSequenceDiagram](images/ArchitectureSequenceDiagram.png)

**Note:** The lifeline for `c:Command` should end at destroy marker (X), but due to a limitation of PlantUML, the lifeline reaches the end of diagram.
