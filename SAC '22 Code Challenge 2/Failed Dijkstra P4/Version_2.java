//Alex
//SAC '22 Code Challenge 2 P4 Cookie Galore
//https://dmoj.ca/problem/sac22cc2p4
//0/100 (instant TLE)

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static boolean[][] visited;
    static int[][] dist;
    static char[][] board;

    public static int[] get_min() {
        int[] r_c = new int[2];
        r_c[0] = -1; r_c[1] = -1;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] < min && !visited[i][j]) {
                    min = dist[i][j];
                    r_c[0] = i;
                    r_c[1] = j;
                }
            }
        }

        return r_c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        dist = new int[n][m];
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            board[i] = br.readLine().toCharArray();

        }

        dist[0][0] = 0;
        if (board[0][0] == 'C') dist[0][0] = 1;
        dijkstra_sssp();
        System.out.println(dist[n - 1][m - 1]);
    }

    public static void dijkstra_sssp() {
        int[] one_one = {0, 0};
        query(one_one);

        for (int i = 0; i < n * m - 1; i++) {
            int[] r_c = get_min();
            query(r_c);

        }
    }

    public static void query(int[] r_c) {
        int r = r_c[0];
        int c = r_c[1];

        visited[r][c] = true;

        int current_dist = dist[r][c];

        if (r > 0) {
            char next = board[r - 1][c];
            int new_dist = current_dist;
            if (next == 'C') new_dist++;

            if (dist[r - 1][c] > new_dist) dist[r - 1][c] = new_dist;

        }

        if (r < n - 1) {
            char next = board[r + 1][c];
            int new_dist = current_dist;
            if (next == 'C') new_dist++;

            if (dist[r + 1][c] > new_dist) dist[r + 1][c] = new_dist;

        }

        if (c > 0) {
            char next = board[r][c - 1];
            int new_dist = current_dist;
            if (next == 'C') new_dist++;

            if (dist[r][c - 1] > new_dist) dist[r][c - 1] = new_dist;

        }

        if (c < m - 1) {
            char next = board[r][c + 1];
            int new_dist = current_dist;
            if (next == 'C') new_dist++;

            if (dist[r][c + 1] > new_dist) dist[r][c + 1] = new_dist;

        }
    }
}
