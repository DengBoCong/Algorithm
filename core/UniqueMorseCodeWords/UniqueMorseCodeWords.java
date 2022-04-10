package com.dbc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<Integer, String> wordToMorse = new HashMap<>();
        for (int i = 0; i < morse.length; i++) {
            wordToMorse.put(i, morse[i]);
        }
        Set<String> res = new HashSet<>();
        for (String word : words) {
            StringBuffer wordMorse = new StringBuffer();
            for (int i = 0; i < word.length(); i++) {
                wordMorse.append(wordToMorse.get(word.charAt(i) - 'a'));
            }
            res.add(wordMorse.toString());
        }
        return res.size();
    }
}
