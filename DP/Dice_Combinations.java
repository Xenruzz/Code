//Alex
package com.company;

import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int o = i - 1; o >= Math.max(0, i - 6); o--) {
                dp[i] = (dp[i] += dp[o]) % 1000000007;

            }
        }

        System.out.println(dp[n]);
    }
}
