package com.dbc.leecode.Algorithm.Solution201_210;

public class Solution202 {
    class TrieNode {
        private boolean isEnd;
        private boolean isEmpty;
        private final int R = 26;
        private TrieNode[] trieNodes = new TrieNode[R];
        TrieNode(){
            this.isEnd = false;
            this.isEmpty = true;
        }

        public boolean isContain(char ch) {
            return trieNodes[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return trieNodes[ch - 'a'];
        }

        public void set(char ch) {
            this.isEmpty = false;
            trieNodes[ch - 'a'] = new TrieNode();
        }

        public void setEnd(){
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

    class WordDictionary {
        private final TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            this.root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.isContain(currentChar)){
                    node.set(currentChar);
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return searchHelp(word, root);
        }

        private boolean searchHelp(String word, TrieNode root) {
            char[] array = word.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < array.length; i++) {
                if(array[i] == '.'){
                    for(int j = 0;j < 26; j++){
                        if(cur.trieNodes[j] != null){
                            if(searchHelp(word.substring(i + 1),cur.trieNodes[j])){
                                return true;
                            }
                        }
                    }
                    return false;
                }
                // 不含有当前节点
                if (cur.trieNodes[array[i] - 'a'] == null) {
                    return false;
                }
                cur = cur.trieNodes[array[i] - 'a'];
            }
            // 当前节点是否为是某个单词的结束
            return cur.isEnd();
        }
    }
}

//class WordDictionary {
//    StringBuilder sb;
//    public WordDictionary() {
//        sb = new StringBuilder();
//        sb.append('#');
//    }
//    public void addWord(String word) {
//        sb.append(word);
//        sb.append('#');
//    }
//
//    public boolean search(String word) {
//        Pattern p = Pattern.compile('#' + word + '#');
//        Matcher m = p.matcher(sb.toString());
//        return m.find();
//    }
//}