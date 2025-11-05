package org.WordAnalyzer;

import java.util.HashMap;
import java.util.Map;

public class WordAnalyzer {
    private String[] words, analysis;
    private String shortest, longest;
    private HashMap<String, Integer> wordsOccurrences = new HashMap<String, Integer>();
    private Integer totalWords =0, shortestLength=0, longestLength=0;
    private Map.Entry<String, Integer> mostCommon = null;

    public WordAnalyzer(String input) {
        words = input.split(" ");
        for(String word : words) {
            totalWords++;
            if(wordsOccurrences.containsKey(word)){
                wordsOccurrences.put(word, wordsOccurrences.get(word)+1);
            }
            else {
                wordsOccurrences.put(word, 1);
            }
            if(shortestLength == 0 || word.length() < shortestLength) {
                shortestLength = word.length();
                shortest = word;
            }
            if(longestLength == 0 || word.length() > longestLength) {
                longestLength = word.length();
                longest = word;
            }
        }
        for(Map.Entry<String, Integer> wordOccurrence : wordsOccurrences.entrySet()){
            if(mostCommon == null || wordOccurrence.getValue().compareTo(mostCommon.getValue()) > 0 ){
                mostCommon = wordOccurrence;
            }
        }
    }
    public String getAnalysis(){
        return "Total words: " + totalWords + "\n" +
                "Shortest word: " + shortest + "\n" +
                "Longest word: " + longest + "\n" +
                "Most common word is " + mostCommon.getKey() + " with " + mostCommon.getValue() + " occurrences\n" +
                "Text has " + wordsOccurrences.size() + " unique words!";
    }
}
