//Alex
//An Animal Contest 4 P1 Dasher's Digits
//https://dmoj.ca/problem/aac4p1
//50/100

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String letters = br.readLine();

       int[] zero_values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

       int largest_value = 0;
       int zero_count = 0;
       int index = 0;

       for (int i = 0; i < n; i++) {
           char c = letters.charAt(i);

           if (c == '0') {
               if (zero_values[zero_count] >= largest_value) {
                   largest_value = zero_values[zero_count++];
                   index = i;

               }
           }
       }

       String output = letters;
       output = output.substring(index + 1, n) + output.substring(0, index);
       output = output.replace("0", "");

       System.out.println(output);
    }
}
