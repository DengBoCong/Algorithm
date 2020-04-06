package com.dbc.leecode.Algorithm.Solution191_200;

public class Solution196 {
//    设计⼀个数据结构WordFilter，⽤来存储含有百万量级单词的词库，并尽可能⾼效 的判断给定⼀个字符串中是否含有词库中的某个单词
    public static class WordFilter{
        class Letters {
            boolean is = false;//字母是否存在
            Letters[] nextlet;
            boolean end = false;//是否为单词结尾
            Letters(boolean is) {
                this.is = is;
                nextlet = new Letters[26]; //下一个字母树
            }
        }
        private static Letters[] lets = new Letters[26];//只包含26个小写字母,可以再添加别的字符
        //请⾃⾏定义⽤于存储单词的数据结构 //...
        //添加⼀个词库中的单词word到你的⾃定义存储结构中
        public void addWord(String word){
            Letters[] nlets = lets;
            for (int i = 0; i < word.length(); i++) {
                if(nlets[word.charAt(i) - 97]==null) {
                    nlets[word.charAt(i) - 97] = new Letters(true);
                }

                if(i==word.length()-1) {
                    nlets[word.charAt(i) - 97].end=true;
                }
                nlets = nlets[word.charAt(i) - 97].nextlet;

            }
        }
        //判断给你的字符串input中是否含有词库中的某个单词，
        //只要含有任意⼀个就返回true，否则返回false
        public boolean isMatch(String input){
            Letters[] nlets = lets;
            for (int i = 0; i < input.length(); i++) {
                if (nlets[input.charAt(i) - 97] != null) {
                    if (nlets[input.charAt(i) - 97].is) {
                        if(nlets[input.charAt(i) - 97].end) {
                            return true;
                        }else nlets = nlets[input.charAt(i) - 97].nextlet;
                    } else {
                        return false;
                    }
                } else
                    return false;
            }
            return false;
        }
    }
}
