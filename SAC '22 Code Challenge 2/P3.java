//Alex
//SAC '22 Code Challenge P3 Rating Choices
//https://dmoj.ca/problem/sac22cc2p3
//100/100

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int num_lines = (int)Math.pow(2, n) - 1;

        int[][] paths = new int[(int)Math.pow(2, n + 1)][2];
        int[] rating_changes = new int[(int)Math.pow(2, n + 1)];
        for (int i = 0; i < num_lines; i++) {
            st = new StringTokenizer(br.readLine());

            int current = Integer.parseInt(st.nextToken());
            int next_take = Integer.parseInt(st.nextToken());
            int next_not_take = Integer.parseInt(st.nextToken());
            int rating = Integer.parseInt(st.nextToken());

            paths[current][0] = next_take;
            paths[current][1] = next_not_take;
            rating_changes[current] = rating;

        }

        System.out.println(recurse_best_rating(1, r, paths, rating_changes));
    }

    public static int recurse_best_rating(int current, int rating, int[][] paths, int[] rating_changes) {
        int[] next = paths[current];
        if (next[0] == 0 && next[1] == 0) return rating;

        int take = next[0];
        int take_rating = rating_changes[current];
        int not_take = next[1];

        int take_new_rating = recurse_best_rating(take, rating + take_rating, paths, rating_changes);
        int not_take_new_rating = recurse_best_rating(not_take, rating, paths, rating_changes);

        return Math.max(take_new_rating, not_take_new_rating);
    }
}
