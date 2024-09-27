import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Commands.Command;
import Parser.Parser;
import Tasks.*;
import Storage.*;
import Exceptions.*;
import TaskList.*;
import Ui.Ui;
import javafx.stage.Stage;


public class Duke {

    private Storage storage;
    private TaskList tasklist;
    private Ui ui;
    private Parser parser;

    public Duke(String filename){

        ui = new Ui();
        storage = new Storage("/" + filename);
        try {
            tasklist = new TaskList(storage.load());

        } catch (ParseException | IOException e){
//            ui.showLoadingError();
            tasklist = new TaskList();
        }

    }




//    public void runDuke(){
//        ui.Greet();
//        parser = new Parser();
//        boolean exit = true;
//        int i = 0;
//        while(exit){
//            try {
//                String cmd =  ui.readCommand();
//
//                Command c = Parser.parse(cmd,tasklist);
//                c.execute(tasklist, ui, storage);
//                storage.saveFile(tasklist.getAllTasks());
//                if(!parser.getExitStatus()){
//                    exit = c.isExit();
//                }
//
//            }
//            catch (DukeEmptyExceptions e){
//                ui.Line();
//                System.out.println(e.getMessage());
//                ui.Line();
//            }
//            catch (DukeOutOfBoundsException e){
//                ui.Line();
//                System.out.println(e.getMessage());
//                ui.Line();
//            }
//            catch (NumberFormatException e){
//                ui.Line();
//                System.out.println(e.getMessage());
//                ui.Line();
//            }
//            catch (InvalidDateException e){
//                ui.Line();
//                System.out.println(e.getMessage());
//                ui.Line();
//            }
////            catch (IOException e){
////                ui.showIOException();
////            }
//            catch (DukeException e){
//                ui.Line();
//                System.out.println(e.getMessage());
//                ui.Line();
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                //ui.printLine();
//                //exit = false;
//            }
//        }
//    }

//    public static void main(String[] args) {
//        new Duke("data/dukeTaskOuput.txt").runDuke();
//    }

    public String getResponse(String input, Stage stage) {
        boolean isExit = true;
        String response = "";
        Parser pas = new Parser();

        ByteArrayOutputStream strBuffer = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(strBuffer);
        PrintStream old = System.out;
        System.setOut(ps);
        try {
            Command c = Parser.parse(input, tasklist);
            response = c.execute(tasklist, ui, storage);
            pas.parsedInput(input);
            isExit = c.isExit();
            if (isExit) {
                stage.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.flush();
        System.setOut(old);
        response = strBuffer.toString();
        return response;
    }
}