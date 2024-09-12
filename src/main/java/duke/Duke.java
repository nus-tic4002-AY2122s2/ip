package duke;

public class Duke {

    private Storage storage;
    private TaskList tasks;

    /**
     *  Constructs duke object.
     */
    public Duke() {
        //Reading data from file
        storage = new Storage();
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate a response to user input.
     * @param input user's input.
     */

    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            return c.execute(tasks, storage);
        } catch (DukeException e) {
            return e.getMessage();
        }
    }

    public String getWelcome() {
        return "Hello! I'm Duke, What can I do for you ? \n Send 'help' to get some tips to help you start.";
    }
}
