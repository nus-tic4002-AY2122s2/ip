package main;

import main.parsers.ParserText;
import main.taskLists.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//*
// Individual Project for TIC4002 2022 Jan-May
//
// *//
public class Duke {

    public static ArrayList<Task> Tasks = new ArrayList<>();

    public static void main(String[] args) throws DukeException, IOException {

        Storage storage = new Storage("C:\\Users\\yrall\\Documents\\duke\\src\\data\\current_tasks.txt");
        ParserText response = new ParserText();


        UI interaction = new UI();

        interaction.welcome(storage.start());


        while (response.isTrue) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            response.parsetext(input);
        }

        storage.save();

    }
}