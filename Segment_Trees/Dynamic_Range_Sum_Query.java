//Alex
//https://cses.fi/problemset/task/1648/
//https://cses.fi/problemset/hack/1648/entry/3629899/

package com.company;
 
import java.util.*;
import java.io.*;
 
import static java.lang.Math.*;
 
public class Main {
 
    static int n;
    //using long because ints will overflow (not enough storage to fit big numbers)
    static long[] tree;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int t = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
 
        StringBuilder stringbuilder = new StringBuilder();
 
        n = (int)pow(2, ceil(log(t)/log(2)));
 
        tree = new long[2*n];
 
        //fill in leaf nodes while reading input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
            tree[n + i] = Long.parseLong(st.nextToken());
 
        }
 
        //fill in parent nodes
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2*i] + tree[2*i + 1];
 
        }
 
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
 
            int type = Integer.parseInt(st.nextToken());
 
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
 
            if (type == 1) {
                query_update(x - 1, y);
 
            } else {
                stringbuilder.append(query_range(1, 0, n - 1, x - 1,y - 1)).append("\n");
 
            }
        }
 
        System.out.println(stringbuilder);
    }
 
    //range query
    //index = index of node in tree array
    //left = node's left range
    //right = node's right range
    //a = query's left range
    //b = query's right range
    public static long query_range(int index, int left, int right, int a, int b) {
        //completely disjoint (no overlap of ranges)
        if (left > b || right < a) return 0;
      
        //completely within (complete overlap, node's range is between a and b)
        if (left >= a && right <= b) return tree[index];
        
        //find mid point
        int mid = (left + right)/2;
        
        long left_child_query = query_range(2*index, left, mid, a, b);
        long right_child_query = query_range(2*index + 1, mid + 1, right, a, b);
      
        //return the sum of the queries of both child nodes
        return left_child_query + right_child_query;
 
    }
    
    //update the value at index 'k' to value 'u'
    public static void query_update(int k, long u) {
        //add n to reach the leaf node index
        k += n;
        
        //update leaf node
        tree[k] = u;
        
        //get parent node
        k /= 2;
        
        //while the node is greater than 0, (below root), go to it's parent node
        for (; k > 0; k /= 2) {
            //node is equal to sum of child nodes
            tree[k] = tree[2*k] + tree[2*k + 1];
 
        }
    }
}
