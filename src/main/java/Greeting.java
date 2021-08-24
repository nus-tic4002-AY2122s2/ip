


public class Greeting {

    /**
     * The greeting with some instruction
     */
    public static void Greeting_Output() {
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
        //System.out.println("     **Date and time input format: /by(at): **");
        //System.out.println("     **1. Deadline: YYYY-MM-DD Hour(0-23):Minute(0-59)**");
        //System.out.println("     **2. YYYY-MM-DD Hour(0-23):Minute(0-59) -> Hour(0-23):Minutes(0-59)**");
        //System.out.println("     **3. YYYY-MM-DD Hour(0-23):Minute(0-59) -> YYYY-MM-DD Hour(0-23):Minute(0-59)**");
    }

    /**
     * Sperated_Line
     */
    public static void Separated_Line(){
        System.out.print("");
        for(int i=0; i<100; i++){
            System.out.print("_");
        }
        System.out.println("");
    }

    public static void GoodBye(){
        System.out.println(" Bye. Hope to see you again soon!");
    }
}
