package Parser;
import Commands.*;
import Exceptions.DukeEmptyExceptions;
import Exceptions.DukeEmptyExceptions;
import Exceptions.DukeException;
import Exceptions.DukeOutOfBoundsException;
import Exceptions.InvalidDateException;
import Storage.Storage;
import TaskList.TaskList;
import Tasks.Events;
import Ui.Ui;

import javax.sound.midi.SysexMessage;

public class Parser {

    private static boolean exit = true;

    private static Ui ui = new Ui();

    /**
     * Parses the user input to obtain commands based on User Input.
     * Each Command is then returned for Execution to take place based on the Commands returned.
     * @param userInput a String of User Input
     * @param tasklist a list of tasks
     * @return parse Parsed command for execution
     * @throws DukeEmptyExceptions
     * @throws DukeOutOfBoundsException
     * @throws InvalidDateException
     * @throws DukeException
     */
    public static Command parse(String userInput, TaskList tasklist) throws DukeEmptyExceptions,
            DukeOutOfBoundsException,
            InvalidDateException,NumberFormatException, DukeException{
                String parsed = parsed(userInput)[0].toLowerCase();

//                Storage storage = new Storage();


//        try {
            switch(parsed) {
                case addByeCommand.COMMAND:
                    exit = false;
                    return new addByeCommand(false);

                case addListCommand.COMMAND:
                    return list(userInput, tasklist);

                case addTodoCommand.COMMAND:
                    return todo(userInput);

                case addDoneCommand.COMMAND:
                    return done(userInput, tasklist);

                case addDeadlineCommand.COMMAND:
                    return deadline(userInput);

                case addEventCommand.COMMAND:
                    return event(userInput);
                case addDeleteCommand.COMMAND:
                    return delete(userInput, tasklist);

                case addFindCommand.COMMAND:
                    return find(userInput);

                default:
//                    throw new DukeException("     Please Key in a correct Command.");
//                    String invalid = "\t☹ OOPS!!! I'm Sorry, Please Key in a valid Command :-(";
                    return new invalidCommand(userInput);
            }
        }
//        catch (DukeEmptyExceptions e){
//            throw new DukeEmptyExceptions(e.getMessage());
//        }
//        catch (DukeOutOfBoundsException e){
//            throw new DukeOutOfBoundsException("     ☹ OOPS!!! The task number must be within range.");
//        }
//        catch (InvalidDateException e){
//            throw new InvalidDateException(e.getMessage());
//        }
//        catch (DukeException e){
//            throw new DukeException();
//        }


        //return new addByeCommand(true);

//    }
    /**
     * Return exit Status to end program
     * @return exit which is the boolean to end the program
     */
    public boolean getExitStatus(){
        return exit;
    }
    /**
     * Returns a new find command for Execution
     * @param inputs a String of User Input
     * @return command Find
     * @throws DukeException
     */
    private static Command find(String inputs) throws DukeException {
        try{
            String[] tmp = inputs.split(" ");
            System.out.println(tmp[0]);

            return new addFindCommand(tmp[1]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(ui.getLine());
            System.out.println("   Search command cannot be empty, Please enter something after the space after, find ");
            System.out.println(ui.getLine());
            throw new DukeException("     Search command cannot be empty");
        }
    }
    /**
     * Returns a new list command for Execution
     * @param inputs a String of User Input
     * @param tasklist a list of Tasks
     * @return command list
     * @throws DukeException
     */
    private static Command list(String inputs, TaskList tasklist) throws DukeException{
        try {
            if(tasklist.getSize() == 0){
                ui.Line();
                System.out.println("     ☹ OOPS!!! The list is empty.");
                ui.Line();
                throw new DukeException("     ☹ OOPS!!! The list is empty.");
            }

            return new addListCommand(inputs);
        }
        catch (DukeException e){
            ui.Line();
            System.out.println("     ☹ OOPS!!! The list is empty.");
            ui.Line();
            throw new DukeException("     ☹ OOPS!!! The list is empty.");
        }
    }

    /**
     * Returns a new delete command for Execution
     * @param inputs a String of User Input
     * @param tasklist a list of tasks
     * @return command delete
     * @throws DukeEmptyExceptions
     * @throws NumberFormatException
     * @throws DukeOutOfBoundsException
     */

    private static Command delete(String inputs, TaskList tasklist) throws DukeEmptyExceptions, NumberFormatException, DukeOutOfBoundsException{
        String tmp = "";
        int storeTaskNo = 0;
        if(inputs.length() == 6){
            tmp = "";
            storeTaskNo = 0;
        }
        else {
            tmp = inputs.substring(inputs.indexOf("delete") + 5, inputs.length()).trim();
            if (!tmp.equals("")) {
                storeTaskNo = Integer.parseInt(parsed(inputs)[1]);
            }
        }
        try {
            if(inputs.substring(inputs.indexOf("delete")).length() == 6){
//                System.out.println("delete");
                throw new DukeEmptyExceptions("delete");
            }
            if((inputs.substring(inputs.indexOf("delete")+7, inputs.length())).trim().equals("")){

                throw new DukeEmptyExceptions("delete");
            }
            int t = Integer.parseInt((inputs.substring(inputs.indexOf("delete")+7).trim()));

            if(storeTaskNo > tasklist.getSize() || storeTaskNo > t || storeTaskNo == 0) {
                throw new DukeOutOfBoundsException("done");
            }
            if(parsed(inputs)[1].toString()==null){
                throw new NumberFormatException("     ☹ OOPS!!! The task number must be a numerical value.");
            }
            String taskB4Del = tasklist.getTask(Integer.parseInt(parsed(inputs)[1])-1).toString();

            return new addDeleteCommand(storeTaskNo-1, taskB4Del);
        } catch (DukeEmptyExceptions e){
            throw new DukeEmptyExceptions("delete");
        } catch (NumberFormatException e){
            ui.Line();
            System.out.println("     ☹ OOPS!!! The task number must be a numerical value.");
            ui.Line();
            throw new NumberFormatException("     ☹ OOPS!!! The task number must be a numerical value.");

        } catch (DukeOutOfBoundsException e){
            ui.Line();
            System.out.println("     ☹ OOPS!!! The task number must be within range.");
            ui.Line();
            throw new DukeOutOfBoundsException("     ☹ OOPS!!! The task number must be within range.");
        }
    }

    /**
     * return a new todo Command for execution
     * @param inputs
     * @return
     * @throws DukeEmptyExceptions
     * @throws NumberFormatException
     * @throws DukeException
     */
    private static Command todo(String inputs) throws DukeEmptyExceptions,NumberFormatException, DukeException {

//            String description = inputs[1];
//            for(int i = 2; i < inputs.length - 1; i++){
//                System.out.println(inputs[i]);
//                description += " " + inputs[i];
//            }

        try {
            if(inputs.substring(inputs.indexOf("todo")).length() == 4){
                throw new DukeEmptyExceptions("todo");
            }
            if((inputs.substring(inputs.indexOf("todo")+5, inputs.length())).trim().equals("")){
                throw new DukeEmptyExceptions("todo");
            }
//            return new addTodoCommand(new myMethods().parsed(inputs)[1]);
            return new addTodoCommand(parsed(inputs)[1]);
        } catch (DukeEmptyExceptions e){
//            System.out.println(e.getMessage());
//            throw new DukeEmptyExceptions(e.getMessage());
            throw new DukeEmptyExceptions("todo");
        } catch (NumberFormatException e){
            ui.Line();
            System.out.println("     ☹ OOPS!!! The task number must be a numerical value.");
            ui.Line();
//            System.out.println("     ☹ OOPS!!! The task number must be a numerical value.");
//            throw new NumberFormatException("     ☹ OOPS!!! The task number must be a numerical value.");
            throw new NumberFormatException("     ☹ OOPS!!! The task number must be a numerical value.");

        } catch (Exception e){
//            System.out.println("did i reach here all the time");

//            throw new DukeException("     Caught an Exception ");
            ui.Line();
            System.out.println("     Caught an Exception ");
            ui.Line();
            return new invalidCommand("     Caught an Exception ");

        }
        //return new addTodoCommand(new myMethods().parsed(inputs)[1]);
    }


    /**
     * return a new Done Command for Execution
     * @param inputs
     * @param tasklist
     * @return
     * @throws DukeEmptyExceptions
     * @throws NumberFormatException
     * @throws DukeOutOfBoundsException
     */
    private static Command done(String inputs, TaskList tasklist) throws DukeEmptyExceptions, NumberFormatException, DukeOutOfBoundsException{
        String tmp = "";
        int storeTaskNo = 0;
        if(inputs.length() == 4){
            tmp = "";
            storeTaskNo = 0;
        }
        else {
            tmp = inputs.substring(inputs.indexOf("done") + 5, inputs.length()).trim();
            if (!tmp.equals("")) {
                storeTaskNo = Integer.parseInt(parsed(inputs)[1]);
            }
        }
        try {
            if(inputs.substring(inputs.indexOf("done")).length() == 4
                    || inputs.substring(inputs.indexOf("done")+5, inputs.length()).trim().equals("")){
                System.out.println("done");
                throw new DukeEmptyExceptions("done");
            }
            if(tmp.equals("")){
                throw new DukeEmptyExceptions("done");
            }
            int t = Integer.parseInt((inputs.substring(inputs.indexOf("done")+5).trim()));
//            if(storeTaskNo > tasklist.getSize() || storeTaskNo > t || storeTaskNo == 0) {
//                throw new DukeOutOfBoundsException("done");
//            }
            if(storeTaskNo > tasklist.getSize() || storeTaskNo > t || storeTaskNo == 0 || t > tasklist.getSize()) {
                ui.Line();
                System.out.println("     ☹ OOPS!!!  The task number must be within range.");
                throw new DukeOutOfBoundsException("     ☹ OOPS!!!  The task number must be within range.");
            }
            if(parsed(inputs)[1].toString()==null){
//                throw new NumberFormatException();
                ui.Line();
                System.out.println("     ☹ OOPS!!! The task number must be a numerical value.");
                ui.Line();
                throw new NumberFormatException("     ☹ OOPS!!! The task number must be a numerical value.");
            }
            return new addDoneCommand(storeTaskNo-1);
        }
        catch (NumberFormatException e){
            ui.Line();
            System.out.println("     ☹ OOPS!!! The task number must be a numerical value.");
            ui.Line();
            throw new NumberFormatException("     ☹ OOPS!!! The task number must be a numerical value.");
//            ui.Line();
        }
        catch (DukeOutOfBoundsException e){
            ui.Line();
            System.out.println("     ☹ OOPS!!! The task number must be within range.");
            ui.Line();
            throw new DukeOutOfBoundsException("     ☹ OOPS!!! The task number must be within range.");

        }catch (DukeEmptyExceptions e){
//            throw new DukeEmptyExceptions(e.getMessage());
            //ui.Line();
            throw new DukeEmptyExceptions("done");
        }

    }


    /**
     * return a new Deadline command for Execution
     * @param inputs
     * @return
     * @throws DukeEmptyExceptions
     * @throws InvalidDateException
     */
    private static Command deadline(String inputs) throws DukeEmptyExceptions, DukeOutOfBoundsException, InvalidDateException {
        try {
            if(inputs.substring(inputs.indexOf("deadline")).length() == 8
                    || inputs.substring(inputs.indexOf("deadline")+9, inputs.length()).trim().equals("")){
                throw new DukeEmptyExceptions("deadline");
            }
            String des = inputs.substring(inputs.indexOf("deadline")+9, inputs.indexOf("by")-1);
            return new addDeadlineCommand(des, new myMethods().dteToString(inputs));
        }
        catch (StringIndexOutOfBoundsException e){
            ui.Line();
            System.out.println("     Please key in Correct Syntax: [deadline] [description] [/by] [dd-mmm-yyyy HHmm]");
            ui.Line();
            throw new DukeOutOfBoundsException("     Please key in Correct Syntax: [deadline] [description] [/by] [dd-mmm-yyyy HHmm]");
        }
        catch (InvalidDateException e){
//            throw new InvalidDateException(e.getMessage());
            ui.Line();
            System.out.println("     ☹ OOPS!!! Date, Syntax Wrong, Please use : DD-MMMM-YYYY(13-Oct-2019) HHmm (1000)");
            ui.Line();
            throw new InvalidDateException("     ☹ OOPS!!! Date, Syntax Wrong, Please use : DD-MMMM-YYYY(13-Oct-2019) HHmm (1000)");
        }
    }

    /**
     * return a new Command event for Execution
     * @param inputs a String of User Input
     * @return command event
     * @throws DukeEmptyExceptions
     * @throws InvalidDateException
     */
    private static Command event(String inputs) throws DukeEmptyExceptions, InvalidDateException{
        try {
            if(inputs.substring(inputs.indexOf("event")).length() == 5
                    || (inputs.substring(inputs.indexOf("event")+5, inputs.length())).trim().equals("")){
                throw new DukeEmptyExceptions("event");
            }

            String des = inputs.substring(inputs.indexOf("event")+6, inputs.indexOf("at")-1);
            String at = inputs.substring(inputs.indexOf("at")+3, inputs.length());

//            return new addEventCommand(des, new myMethods().dteToString(inputs));
            return new addEventCommand(des, at);
        }
        catch (DukeEmptyExceptions e){
//            ui.Line();
//            throw new DukeEmptyExceptions(e.getMessage() + ui.getLine());
            throw new DukeEmptyExceptions("event");
        }
        catch (NumberFormatException e){
//            throw new NumberFormatException("     ☹ OOPS!!! The task number must be a numerical value." + ui.getLine());
            ui.Line();
            System.out.println("     ☹ OOPS!!! The task number must be a numerical value.");
            ui.Line();
            throw new NumberFormatException("     ☹ OOPS!!! The task number must be a numerical value.");
        }
    }

    public static String[] parsed(String input){
        String[] act = input.split(" ",2);
        return act;
    }

    public String[] parsedInput(String input){
        String[] act = input.split(" ",2);
        return act;
    }
}