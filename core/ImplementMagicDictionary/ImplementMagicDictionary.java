package com.dbc;

import java.util.*;

public class ImplementMagicDictionary {
    private final Map<Integer, List<String>> map;
    private final Map<String, Integer> count;
    private final Set<String> set;

    public ImplementMagicDictionary() {
        this.map = new HashMap<>();
        this.count = new HashMap<>();
        this.set = new HashSet<>();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            if (!this.map.containsKey(word.length())) {
                this.map.put(word.length(), new ArrayList<>());
            }
            this.map.get(word.length()).add(word);
        }
    }

    public boolean search(String searchWord) {
        if (!this.map.containsKey(searchWord.length())) {
            return false;
        }

        for (String word : this.map.get(searchWord.length())) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != searchWord.charAt(i)) count++;
            }
            if (count == 1) return true;
        }
        return false;
    }

    private List<String> gen_neighbor(String word) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] charWord = word.toCharArray();
            charWord[i] = '*';
            res.add(Arrays.toString(charWord));
        }
        return res;
    }

    public void buildDict1(String[] dictionary) {
        for (String word : dictionary) {
            this.set.add(word);
            for (String gen_word : gen_neighbor(word)) {
                this.count.put(gen_word, this.count.getOrDefault(gen_word, 0) + 1);
            }
        }
    }

    public boolean search1(String searchWord) {
        for (String gen_word : gen_neighbor(searchWord)) {
            if (this.count.getOrDefault(gen_word, 0) > 1 ||
                    this.count.getOrDefault(gen_word, 0) == 1 && !this.set.contains(searchWord))
                return true;
        }
        return false;
    }
}
