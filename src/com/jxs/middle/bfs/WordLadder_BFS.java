package com.jxs.middle.bfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder_BFS {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }
        ArrayList<String> similars = getSimilars(beginWord, wordList);
        Queue<String> queue = new LinkedList<>();
        boolean[] mark = new boolean[wordList.size()];
        int level = 1;
        for (String word : similars) {
            queue.add(word);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                String curWord = queue.poll();
                similars = getSimilars(curWord, wordList);
                for (String word : similars) {
                    if (endWord.equals(curWord)) {
                        return level;
                    }
                    if (mark[wordList.indexOf(word)] == true) {
                        continue;
                    }
                    queue.add(word);
                    mark[wordList.indexOf(word)] = true;
                }
            }
        }
        return 0;
    }

    private ArrayList<String> getSimilars1(String word, List<String> wordList) {

        ArrayList<String> similars = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < word.length(); j++) {
                String findWord = wordList.get(i);
                if (word != findWord) {
                    StringBuilder sWordTarget = new StringBuilder(word);
                    StringBuilder sWord = new StringBuilder(findWord);
                    if (sWordTarget.deleteCharAt(j).toString().equals(sWord.deleteCharAt(j).toString())) {
                        similars.add(findWord);
                    }
                }
            }
        }
        return similars;
    }

    private ArrayList<String> getSimilars(String word, List<String> wordList) {

        ArrayList<String> similars = new ArrayList<>();
        int length = word.length();
        for (int i = 0; i < wordList.size(); i++) {
            String findWord = wordList.get(i);
            int cnt = 0;
            for (int j = 0; j < length; j++) {
                if (word.charAt(j) != findWord.charAt(j)) {
                    cnt++;
                }
            }
            if (cnt == 1) {
                similars.add(findWord);
            }
        }
        return similars;
    }

    @Test
    public void test() {

        List<String> wordList = new ArrayList<>();
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        for (String word : words) {
            wordList.add(word);
        }
        System.out.println(getSimilars1("dog",wordList));
        System.out.println(getSimilars("dog", wordList));
        System.out.println(ladderLength("hit","cog",wordList));
    }
}
