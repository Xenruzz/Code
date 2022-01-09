//Alex
//Cookie Galore
//https://dmoj.ca/problem/sac22cc2p4
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static char[][] g;
    static int[][] dist;

    static class Point implements Comparable<Point> {
        int r, c, dist;

        public Point(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;

        }

        @Override
        public int compareTo(Point o) {
            return this.dist - o.dist;

        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (o.getClass() != this.getClass()) return false;

            Point temp = (Point)o;

            return r == temp.r && c == temp.c;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        g = new char[n + 1][m + 1];
        dist = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();

            for (int o = 0; o < m; o++) {
                g[i + 1][o + 1] = input[o];
                dist[i + 1][o + 1] = Integer.MAX_VALUE;

            }
        }

        if (g[1][1] == 'C') dist[1][1] = 1;
        else dist[1][1] = 0;

        dijkstra();
    }

    public static void dijkstra() {
        PriorityQueue<Point> queue = new PriorityQueue<>();

        queue.add(new Point(1, 1, dist[1][1]));

        boolean[][] visited = new boolean[n + 1][m + 1];

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int r = p.r;
            int c = p.c;

            if (visited[r][c]) continue;
            visited[r][c] = true;

            queue.addAll(get_next(p));

        }

        System.out.println(dist[n][m]);
    }

    public static ArrayList<Point> get_next(Point p) {
        int r = p.r;
        int c = p.c;
        int d = p.dist;

        ArrayList<Point> return_list = new ArrayList<>();
        if (r > 1) {
            char ch = g[r - 1][c];

            int d_2 = d;
            if (ch == 'C') d_2++;

            if (dist[r - 1][c] > d_2) {
                dist[r - 1][c] = d_2;
                return_list.add(new Point(r - 1, c, d_2));

            }
        }

        if (r < n) {
            char ch = g[r + 1][c];

            int d_2 = d;
            if (ch == 'C') d_2++;

            if (dist[r + 1][c] > d_2) {
                dist[r + 1][c] = d_2;
                return_list.add(new Point(r + 1, c, d_2));

            }
        }

        if (c > 1) {
            char ch = g[r][c - 1];

            int d_2 = d;
            if (ch == 'C') d_2++;

            if (dist[r][c - 1] > d_2) {
                dist[r][c - 1] = d_2;
                return_list.add(new Point(r, c - 1, d_2));

            }
        }

        if (c < m) {
            char ch = g[r][c + 1];

            int d_2 = d;
            if (ch == 'C') d_2++;

            if (dist[r][c + 1] > d_2) {
                dist[r][c + 1] = d_2;
                return_list.add(new Point(r, c + 1, d_2));

            }
        }

        return return_list;
    }
}
