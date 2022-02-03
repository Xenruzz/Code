//Alex
//QOTW W10 Senior

package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();

        HashMap<Character, Integer> frequency_of_window = new HashMap<>();
        HashMap<Character, Integer> frequency_of_edward = new HashMap<>();

        frequency_of_edward.put('e', 1);
        frequency_of_edward.put('d', 2);
        frequency_of_edward.put('w', 1);
        frequency_of_edward.put('a', 1);
        frequency_of_edward.put('r', 1);

        for (int i = 0; i <= 6; i++) {
            char ch = input.charAt(i);
            frequency_of_window.put(ch, frequency_of_window.getOrDefault(ch, 0) + 1);

        }

        if (frequency_of_window.equals(frequency_of_edward)) {
            System.out.println("garbage");
            return;

        }

        for (int i = 6; i < n; i++) {
            char new_char = input.charAt(i);
            char old_char = input.charAt(i - 6);

            frequency_of_window.put(new_char, frequency_of_window.getOrDefault(new_char, 0) + 1);

            frequency_of_window.put(old_char, frequency_of_window.get(old_char) - 1);

            if (frequency_of_window.get(old_char) == 0) {
                frequency_of_window.remove(old_char);

            }

            if (frequency_of_window.equals(frequency_of_edward)) {
                System.out.println("garbage");
                return;

            }
        }

        System.out.println("keep");
    }
}
