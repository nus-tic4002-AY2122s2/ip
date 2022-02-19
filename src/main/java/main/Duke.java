package main;

import main.parsers.ParserText;
import main.taskLists.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

//*
// Individual Project for TIC4002 2022 Jan-May
//
// *//
public class Duke extends Application {

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

    // Writing First Program JavaFX
    //
    //
    //

    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
    }
}