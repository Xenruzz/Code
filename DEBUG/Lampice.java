package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        method(n, k, s);

    }

    public static void method(int n, int k, int[] s) {
        int max_size = n / k;

        for (int i = 1; i <= max_size; i++) {
            for (int p = 0; p < n - i; p++) {
                int[] record = new int[i];
                boolean to_break = false;
                for (int j = 0; j < k; j++) {
                    if (j == 0) {
                        System.arraycopy(s, p, record, 0, i);

                    } else {
                        for (int o = 0; o < i; o++) {
                            if (s[p + (j * i) + o] != record[o]) {
                                to_break = true;
                                break;
                            }
                        }
                    }
                }

                if (!to_break) {
                    System.out.println(i);
                    for (int o = 0; o < i; o++) {
                        System.out.print(record[o] + " ");
                    }

                    return;
                }
            }
        }

        System.out.println(-1);
    }
}
