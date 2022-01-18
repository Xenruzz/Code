package com.company;

import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {

    static int n_odd, n_even;
    static int[] tree_odd, tree_even;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        n_even = (int)pow(2, ceil(log(t - t/2)/log(2)));
        n_odd = (int)pow(2, ceil(log(t/2)/log(2)));

        tree_even = new int[2 * n_even];
        tree_odd = new int[2 * n_odd];

        st = new StringTokenizer(br.readLine());
        //fill in the bottom of the tree
        for (int i = 0; i < t; i++) {
            if (i % 2 == 0) tree_even[n_even + i/2] = Integer.parseInt(st.nextToken());
            else tree_odd[n_odd + i/2] = Integer.parseInt(st.nextToken());

        }

        //complete the rest of the trees
        for (int i = n_even - 1; i > 0; i--) {
            tree_even[i] = tree_even[2*i] + tree_even[2*i + 1];

        }

        for (int i = n_odd - 1; i > 0; i--) {
            tree_odd[i] = tree_odd[2*i] + tree_odd[2*i + 1];

        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (type == 1) {
                if (a % 2 == 0) {
                    query_update(true, a/2, b + 1);

                } else {
                    query_update(false, a/2, b + 1);

                }
            } else {
                if (a % 2 == 0) {
                    System.out.println(query_sum(true, 1, 0, n_even - 1, a/2, b/2));

                } else {
                    System.out.println(query_sum(false, 1, 0, n_odd - 1, a/2, b/2));

                }
            }
        }
    }

    public static int query_sum(boolean even_tree, int i, int l, int r, int q_l, int q_r) {
        if (l > q_r || r < q_l) return 0;

        if (l >= q_l && r <= q_r) {
            if (even_tree) return tree_even[i];
            else return tree_odd[i];

        }

        int mid = (l + r)/2;

        return query_sum(even_tree, 2*i, l, mid, q_l, q_r) + query_sum(even_tree, 2*i + 1, mid + 1, r, q_l, q_r);

    }

    public static void query_update(boolean even_tree, int j, int k) {
        int[] tree = tree_even;
        if (!even_tree) tree = tree_odd;

        int n = tree.length/2;

        tree[n + j] = k;

        for (int i = (n + j)/2; i > 0; i /= 2) {
            tree[i] = tree[2*i] + tree[2*i + 1];

        }
    }
}
