package com.jxs.middle.bfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquares_BFS {

    // 纯BFS，未使用动态规划
    // BFS参考：https://blog.csdn.net/w_bu_neng_ku/article/details/78754176
    public int numSquares(int n) {

        ArrayList<Integer> squares = findAllSquares(n);
        int level = 0;
        if (squares.get(squares.size() - 1) == n) {
            return 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next == 0) {
                        return level;
                    }
                    if (next < 0) {
                        break;
                    }
                    queue.add(next);
                }
            }
        }
        return -1;
    }

    private ArrayList<Integer> findAllSquares(int n) {

        ArrayList<Integer> squares = new ArrayList<>();
        int i = 1;
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff ;
            diff += 2;
        }
        return squares;
    }

    // BFS+动态规划
    public int numSquares1(int n) {
        List<Integer> squares = findAllSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        //marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next == 0) {
                        return level;
                    }
                    if (next < 0) {
                        break;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    @Test
    public void test() {

        int n = 7168;
        System.out.println(numSquares(n));
        System.out.println(numSquares1(n));
    }
}
