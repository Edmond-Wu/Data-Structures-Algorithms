package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStringChain {
    /**
     * Find the longest chain of predecessors in an array words
     * A word is a predecessor of another if you can add a single letter at any index to the word to make the other word
     * while preserving order
     * Solved with recursive DFS and a map for look-ups to prevent excessive processing
     * Go in reverse order; check longest word, delete character from it, check if that is in words, so and so forth
     * @param words an array of words
     * @return the length of the longest predecessor chain you can form
     */
    public static int longestStringChain(String[] words) {
        if (words == null || words.length < 1) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>();
        Collections.addAll(wordSet, words);
        Map<String, Integer> chainMap = new HashMap<>();
        int maxLength = 1;
        for (String word : words) {
            maxLength = Math.max(maxLength, recursiveDfs(wordSet, chainMap, word));
        }
        return maxLength;
    }

    /**
     * Helper method that performs recursive DFS to find the longest possible chain for a given word
     * @param wordSet set containing all the words in the original input array
     * @param chainMap map containing each word as a key and how long its chain length is that ends with that key
     * @param currentWord current word in the chain
     * @return length of the longest chain for that particular word
     */
    private static int recursiveDfs(Set<String> wordSet, Map<String, Integer> chainMap, String currentWord) {
        //if the map already contains the currentWord, return it
        if (chainMap.containsKey(currentWord)) {
            return chainMap.get(currentWord);
        }
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(currentWord);
        //for each character in currentWord, delete it to form a predecessor, and check for that predecessor in the word set
        for (int i = 0; i < currentWord.length(); i++) {
            char c = currentWord.charAt(i);
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            //if the new word exists in the word set, recurse
            if (wordSet.contains(newWord)) {
                int chainLength = 1 + recursiveDfs(wordSet, chainMap, newWord);
                //update the max length
                maxLength = Math.max(maxLength, chainLength);
            }
            //re-insert the character back into the word before moving on to next character
            sb.insert(i, c);
        }
        //insert the word/max-length pairing into the map
        chainMap.put(currentWord, maxLength);
        return maxLength;
    }
}
