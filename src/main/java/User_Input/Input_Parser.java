package User_Input;

import java.lang.*;
import java.util.ArrayList;

public class Input_Parser {

    public static String toGetDescription (String[] Input_Words) {
        String Input_Description = "";
        ArrayList<String> buffer = new ArrayList<String>();

        int i = 1;

        if(Input_Words.length == 2){
            return Input_Words[1];
        }

        for(; i < Input_Words.length; i++) {

            if(Input_Words[i].equals("/by") || Input_Words[i].equals("/at")){

                Input_Description = convertStringArrayToString(buffer);

                break;
            }

            buffer.add(Input_Words[i]);
        }

        return Input_Description;
    }

    public static String toGetDate (String[] Input_Words) {
        String Input_Date = "";
        ArrayList<String> buffer = new ArrayList<String>();

        int i = 1;

        for(; i < Input_Words.length; i++) {

            if(Input_Words[i].equals("/by") || Input_Words[i].equals("/at")){

                for(i++; i < Input_Words.length; i++){
                    buffer.add(Input_Words[i]);
                }

                break;
            }
        }

        Input_Date = convertStringArrayToString(buffer);

        return Input_Date;
    }

    private static String convertStringArrayToString(ArrayList<String> strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr)
            sb.append(str).append(" ");
        return sb.substring(0, sb.length() - 1);
    }
}
