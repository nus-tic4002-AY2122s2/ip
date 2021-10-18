package Exceptions;

public class DukeEmptyExceptions extends Exception{
    public DukeEmptyExceptions(String input){
        super("     ☹ OOPS!!! The description of a " + input + " cannot be empty.");
    }
}
