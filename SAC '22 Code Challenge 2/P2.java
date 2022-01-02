//Alex
//SAC '22 Code Challenge 2 P2 Cookie Sprinkler
//https://dmoj.ca/problem/sac22cc2p2
//100/100

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

        int[][] cookie_count = new int[n][n];
        int sprinkler_count = 0;

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;

                cookie_count[x][y]++;

            } else {
                int x1 = Integer.parseInt(st.nextToken()) - 1;
                int y1 = Integer.parseInt(st.nextToken()) -1;
                int x2 = Integer.parseInt(st.nextToken()) - 1;
                int y2 = Integer.parseInt(st.nextToken()) - 1;

                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        sprinkler_count += cookie_count[x][y];

                    }
                }
            }
        }

        System.out.println(sprinkler_count);
    }
}
