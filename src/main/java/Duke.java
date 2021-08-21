public class Duke {
    private Duke(){ }

    private void run(){
        UI ui = new UI();
        ui.welcome();
        boolean isExit = false;
        while(!isExit){
            String fullCommand = UI.readCommand();
            Command c = new Command(fullCommand);
            c.execute();
            isExit = c.isExit;
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}
