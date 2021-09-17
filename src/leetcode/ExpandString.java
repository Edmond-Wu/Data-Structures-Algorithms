package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpandString {

    /**
     * Given a string that consists of a combination of strings in brackets and strings outside, return the expanded string
     * @param input Ex: {a,b,c}d{e,f}
     * @return Ex: ade bde cde adf bdf cdf
     */
    public static String expandString(String input) {
        if (input.length() == 0) {
            return "";
        }
        List<String> expandedList = new ArrayList<>();
        buildStringList(input, expandedList);
        //use StringBuilder to turn list into String output
        StringBuilder listStringBuilder = new StringBuilder();
        for (int i = 0; i < expandedList.size() - 1; i++) {
            listStringBuilder.append(expandedList.get(i));
            listStringBuilder.append(" ");
        }
        listStringBuilder.append(expandedList.get(expandedList.size() - 1));
        return listStringBuilder.toString();
    }

    /**
     * Helper method to parse through input string and populate the list
     * @param input
     * @param stringList
     */
    private static void buildStringList(String input, List<String> stringList) {
        if (input.length() == 0) {
            return;
        }
        //if no brackets, add entire string
        int firstOpenBracket = input.indexOf('{');
        if (firstOpenBracket == -1) {
            stringList.add(input);
            return;
        }
        //if first character is not a bracket, add substring until the first bracket if the original list is empty
        //otherwise add it to every existing element in stringList
        if (firstOpenBracket != 0) {
            String substring = input.substring(0, firstOpenBracket);
            if (stringList.isEmpty()) {
                stringList.add(substring);
            }
            else {
                List<String> newStringList = new ArrayList<>();
                for (String oldListString : stringList) {
                    newStringList.add(oldListString + substring);
                }
                //update current list by emptying old contents then adding new list
                stringList.clear();
                stringList.addAll(newStringList);
            }
            buildStringList(input.substring(firstOpenBracket), stringList);
        }
        //parse the bracket
        else {
            int firstCloseBracket = input.indexOf('}');
            //if there's no matching closing bracket, exit out
            if (firstCloseBracket == -1) {
                return;
            }
            String[] split = input.substring(firstOpenBracket + 1, firstCloseBracket).split(",");
            if (stringList.isEmpty()) {
                Collections.addAll(stringList, split);
            }
            else {
                List<String> newStringList = new ArrayList<>();
                for (String splitString : split) {
                    for (String oldListString : stringList) {
                        newStringList.add(oldListString + splitString);
                    }
                }
                //update list contents by emptying old list and adding new list
                stringList.clear();
                stringList.addAll(newStringList);
            }
            buildStringList(input.substring(firstCloseBracket + 1), stringList);
        }
    }
}
