//Alex
//DMOJ Knapsack 1
//https://dmoj.ca/problem/dpd
//2/70 (To be reviewed later)

package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        long[][] items = new long[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Long.parseLong(st.nextToken());
            items[i][1] = Long.parseLong(st.nextToken());
        }

        System.out.println(knap_sack(items, n, w));
    }

    public static long knap_sack(long[][] items, int n, int w) {
        long[][] values = new long[n + 1][w + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) values[i][j] = 0;
                else if (items[i - 1][0] <= j) {
                    values[i][j] = Math.max(items[i - 1][1], values[i - 1][w - (int)items[i - 1][0]] + items[i - 1][1]);

                } else values[i][j] = values[i - 1][j];
            }
        }

        return values[n][w];
    }
}
