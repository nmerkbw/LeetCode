package com.jxs.middle;

/**
 * 并查集
 * */
public class UnionFind {

    public int[] findRedundantConnection(int[][] edges) {

        int N = edges.length;
        UF uf = new UF(N);
        for (int[] a : edges) {
            int u = a[0];
            int v = a[1];
            if (uf.connect(u, v)) {
                return a;
            }
            uf.union(u, v);
        }
        return null;
    }

    private class UF {

        private int[] id;

        UF (int N) {
            id = new int[N + 1];
            for (int i = 0; i < id.length; i++) {
                id[i] = i;
            }
        }

        void union(int u, int v) {

            int uid = findId(u);
            int vid = findId(v);
            if (uid == vid) {
                return;
            }
            for (int i = 0; i < id.length; i++) {
                if (id[i] == uid) {
                    id[i] = vid;
                }
            }
        }

        int findId(int p) {

            return id[p];
        }

        boolean connect(int u, int v) {
            return findId(u) == findId(v);
        }
    }

    public static void main(String[] args) {

        int[][] edges = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        UnionFind unionFind = new UnionFind();
        unionFind.findRedundantConnection(edges);
    }
}
