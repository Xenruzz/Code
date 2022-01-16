//failed implementation of segment trees
package com.company;

import java.util.*;
import java.io.*;

public class Main {

    static int n, q;
    static int[] arr;
    static int[] tree_even;
    static int[] tree_odd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new int[n];

        int size_even = (int) Math.pow(2, Math.ceil(Math.log(n - n / 2) / Math.log(2)));
        int size_odd = (int) Math.pow(2, Math.ceil(Math.log(n / 2) / Math.log(2)));

        tree_even = new int[2 * size_even];
        tree_odd = new int[2 * size_odd];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            //construction of the bottom of the seg trees
            if (i % 2 == 0) {
                tree_even[size_even + i / 2] = arr[i];

            } else {
                tree_odd[size_odd + i / 2] = arr[i];

            }
        }

        //consrtuct seg trees
        for (int i = size_even - 1; i > 0; i--) {
            tree_even[i] = tree_even[2 * i] + tree_even[2 * i + 1];

        }

        for (int i = size_odd - 1; i > 0; i--) {
            tree_odd[i] = tree_odd[2 * i] + tree_odd[2 * i + 1];

        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int index = Integer.parseInt(st.nextToken()) - 1;
                int value = Integer.parseInt(st.nextToken());

                int[] tree = tree_even;
                if (index % 2 != 0) tree = tree_odd;

                query_update(index/2 + tree.length/2, value, tree);

            } else {
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;

                int[] tree = tree_even;
                if (start % 2 != 0) tree = tree_odd;

                System.out.println(query_range(1, 0, tree.length / 2 - 1, start / 2, end / 2, tree));

            }
        }
    }

    public static int query_range(int node_index, int node_left, int node_right, int left, int right, int[] tree) {
        if (node_left > right || node_right < left) return 0;

        if (node_left >= left && node_right <= right) return tree[node_index];

        int half = (node_left + node_right) / 2;
        return query_range(node_index * 2, node_left, half, left, right, tree)
                + query_range(node_index * 2 + 1, half + 1, node_right, left, right, tree);

    }

    public static void query_update(int node_index, int value, int[] tree) {
        tree[node_index] = value;

        for (int i = node_index/2; i > 0; i /= 2) {
            tree[i] = tree[2*i] + tree[2*i + 1];

        }
    }
}
