package com.gezhiwei.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图
 *
 * @author gezhiwei
 */
public class Graph {
    /**
     * 顶点的个数
     */
    private int v;
    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adj;


    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图一条边存两次
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }


    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }

        // 用来记录被访问过的顶点，避免重复访问
        boolean[] visited = new boolean[v];
        visited[s] = true;

        // 用来存储 已经被访问，但相邻订单还没有被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        // s 已经被访问，但其相邻订单还没有被访问
        queue.add(s);

        // 用来记录搜索路径
        int[] prev = new int[v];
        // 初始化prev
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            // poll出一个顶点
            int w = queue.poll();
            // 从邻接表中取出链表，表示这个顶点所链接的其他顶点
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    // 这个记录没有懂
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }


    /**
     * 全局变量或者类成员变量
     */
    boolean found = false;

    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }

        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }
}