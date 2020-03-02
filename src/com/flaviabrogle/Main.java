package com.flaviabrogle;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int max = 120;
        if (args.length > 0) {
            try {
                max = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Prime Numbers up to " + max + ":");
        for (int i : getPrimeNumbersUpTo(max)) {
            System.out.print(i);
            System.out.print(", ");
        }
    }

    public static List<Integer> getPrimeNumbersUpTo(int max) {
        boolean[] marked = new boolean[max - 1];
        int offset = 2;  // We start with 2 because it's the lowest prime number.
        List<Integer> primes = new ArrayList<>();

        for (int i = offset; i < max; i++) {
            if (!marked[i-offset]) {
                primes.add(i);
                int x = i * i;
                while (x < max) {
                    marked[x-offset] = true;
                    x += i;
                }
            }

        }

        return primes;
    }


}
