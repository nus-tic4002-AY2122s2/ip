import duke.dukeUI.*;
import duke.dukeTaskList.*;
import duke.dukeStorage.*;
import duke.dukeException.*;
import duke.dukeUI.*;
import duke.dukeTask.*;
import duke.dukeCommand.*;
import duke.dukeParser.*;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Duke{
    private DukeStorage storage;
    private DukeTaskList taskList;
    private DukeUI ui;

    public Duke() {
    }

    public void run(){
        ui = new DukeUI();
        storage = new DukeStorage();
        taskList = new DukeTaskList();
        ui.welcomeMessage();
        try{
            storage.readFile();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }

        while (true) {
            try {
                String fullCommand = ui.readUserInput();
                Command c = DukeParser.parseInput(fullCommand);
                c.execute(taskList, ui, storage);
            }catch (Exception e) {
                ui.showError(e.getMessage());
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new Duke().run();
    }
}