package user_input;


import java.util.ArrayList;

public class Input_Parser {

    /**
     * To extract task description information from user input
     *
     * @param inputWords all user input in String[] type
     * @return the description in String type
     */
    public static String toGetDescription (String[] inputWords) {
        String inputDescription = "";
        ArrayList<String> buffer = new ArrayList<String>();

        int i = 1;

        if(inputWords.length == 2){
            return inputWords[1];
        }

        for(; i < inputWords.length; i++) {

            if(inputWords[i].equals("/by") || inputWords[i].equals("/at")){

                inputDescription = convertStringArrayToString(buffer);

                break;
            }

            buffer.add(inputWords[i]);
        }

        return inputDescription;
    }

    /**
     * To extract time/date information from user input
     *
     * @param inputWords all user input in String[] type
     * @return the time/date information in String type
     */
    public static String toGetDate (String[] inputWords) {
        String inputDate = "";
        ArrayList<String> buffer = new ArrayList<String>();

        int i = 1;

        for(; i < inputWords.length; i++) {

            if(inputWords[i].equals("/by") || inputWords[i].equals("/at")){

                for(i++; i < inputWords.length; i++){
                    buffer.add(inputWords[i]);
                }

                break;
            }
        }

        inputDate = convertStringArrayToString(buffer);

        return inputDate;
    }

    /**
     * To convert String[] to String type
     *
     * @param strArr String[] information
     * @return String[] information in String type
     */
    private static String convertStringArrayToString(ArrayList<String> strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr)
            sb.append(str).append(" ");
        return sb.substring(0, sb.length() - 1);
    }
}
