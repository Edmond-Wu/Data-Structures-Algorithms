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
        List<List<String>> parsedList = new ArrayList<>();
        buildStringList(parsedList, input);
        List<String> expandedList = buildExpandString(parsedList);
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
     * Helper method to parse the original input string by its brackets
     * @param stringList
     * @param input
     */
    private static void buildStringList(List<List<String>> stringList, String input) {
        if (input.length() == 0) {
            return;
        }
        //if no brackets, add entire string
        int firstOpenBracket = input.indexOf('{');
        if (firstOpenBracket == -1) {
            List<String> noBracketList = new ArrayList<>();
            noBracketList.add(input);
            stringList.add(noBracketList);
            return;
        }
        //if first character is not a bracket, add substring until the first bracket
        if (firstOpenBracket != 0) {
            List<String> nonBracketedStringList = new ArrayList<>();
            nonBracketedStringList.add(input.substring(0, firstOpenBracket));
            stringList.add(nonBracketedStringList);
            buildStringList(stringList, input.substring(firstOpenBracket));
        }
        //parse the bracket
        else {
            int firstCloseBracket = input.indexOf('}');
            //if there's no matching closing bracket, exit out
            if (firstCloseBracket == -1) {
                return;
            }
            String[] split = input.substring(firstOpenBracket + 1, firstCloseBracket).split(",");
            List<String> bracketedStringList = new ArrayList<>();
            Collections.addAll(bracketedStringList, split);
            stringList.add(bracketedStringList);
            buildStringList(stringList, input.substring(firstCloseBracket + 1));
        }
    }

    /**
     * Helper method to take the list from buildStringList() and create a list of the expanded strings
     * @param stringList
     * @return
     */
    private static List<String> buildExpandString(List<List<String>> stringList) {
        List<String> expandedList = new ArrayList<>();
        for (List<String> bracket : stringList) {
            if (expandedList.isEmpty()) {
                expandedList.addAll(bracket);
            }
            else {
                //add on every string in the bracket to the previous values in the list
                List<String> newExpandedList = new ArrayList<>();
                for (String bracketString : bracket) {
                    for (String expandedString : expandedList) {
                        newExpandedList.add(expandedString + bracketString);
                    }
                }
                //update expandedList to the newExpandedList
                expandedList = newExpandedList;
            }
        }
        return expandedList;
    }
}
