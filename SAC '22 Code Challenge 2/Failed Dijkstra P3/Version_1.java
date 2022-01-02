//Alex
//SAC '22 Code Challenge 2 P4 Cookie Galore
//https://dmoj.ca/problem/sac22cc2p4
//0/100 (instant TLE)

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static char[][] board;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE - 1);

        }

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();

        }

        int cookies = 0;
        if (board[0][0] == 'C') cookies = 1;
        recurse_cookie_move(1, 1, cookies);

        System.out.println(dist[n - 1][m - 1]);
    }

    public static void recurse_cookie_move(int x, int y, int cookie_count) {
        if (x < n - 1) {
            int new_count = cookie_count;
            if (board[x + 1][y] == 'C') new_count++;

            if (dist[x + 1][y] > new_count) {
                dist[x + 1][y] = new_count;

                recurse_cookie_move(x + 1, y, new_count);

            }
        }

        if (y < m - 1) {
            int new_count = cookie_count;
            if (board[x][y + 1] == 'C') new_count++;

            if (dist[x][y + 1] > new_count) {
                dist[x][y + 1] = new_count;

                recurse_cookie_move(x, y + 1, new_count);

            }
        }

        if (x > 1) {
            int new_count = cookie_count;
            if (board[x - 1][y] == 'C') new_count++;

            if (dist[x - 1][y] > new_count) {
                dist[x - 1][y] = new_count;

                recurse_cookie_move(x - 1, y, new_count);

            }
        }

        if (y > 1) {
            int new_count = cookie_count;
            if (board[x][y - 1] == 'C') new_count++;

            if (dist[x][y - 1] > new_count) {
                dist[x][y - 1] = new_count;

                recurse_cookie_move(x, y - 1, new_count);

            }
        }
    }
}
