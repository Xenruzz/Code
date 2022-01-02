//Alex
//SAC '22 Code Challenge 2 P1 Calendar Management
//https://dmoj.ca/problem/sac22cc2p1
//100/100

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    static class Project {
        int date;
        String subject;

        public Project(int date, String s) {
            this.date = date;
            subject = s;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());


        ArrayList<Project> list = new ArrayList<>();

        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());

            int day = Integer.parseInt(st.nextToken());
            String subject = st.nextToken();

            list.add(new Project(day, subject));
        }

        int l, r = 1;
        for (int i = 0; i < k; i++) {
            l = r;
            r = Integer.parseInt(br.readLine());


            ArrayList<Project> new_list = list;
            for (int j = 0; j < a; j++) {
                Project p = list.get(j);
                if (p == null) continue;
                int date = p.date;
                if (date >= l && date <= r) {
                    String s = p.subject;
                    list.set(j, null);
                    System.out.println(s);

                }
            }

            list = new_list;
        }
    }
}
