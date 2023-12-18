package Database;

import java.util.regex.*;
public class Regex {
    public static boolean stringSearch(String regex, String element){

        regex = regex.toLowerCase();
        element = element.toLowerCase();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(element);

        return matcher.find();

    }



}
