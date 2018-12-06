package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Divisor {

     final static void defDivisor(int number) {
        List<Integer> answer = new ArrayList<>();
        int i = 1;
        while (number >= i) {
            if (number % i == 0) {
                answer.add(i);
            }
            i++;
        }
        System.out.println(answer);
    }

    private static void divisorTheBest(int number) {
        List<Integer> answer = new ArrayList<>();
        int i = 1;
        int index = 0;

        while ((number / 2) >= i) {
            if (number % i == 0) {
                if (i > (number / i))
                    break;
                answer.add(index, i);
                answer.add(index + 1, number / i);
                index++;
            }
            i++;
        }
//        answer.sort((o1, o2) -> {
//            return o1 - o2;
//        });
        System.out.println(answer);
    }

    private static void searchForNumbers(int count) {

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i <= count / 2 + 1; i++) {
            if (count % (i + 1) == 0) {
                answer.add(i + 1);
            }
        }
        answer.add(count);
        System.out.println(answer);
    }

    public  static void main(String[] args){
        long start, end, result;


        start = getSystemTime();
        divisorTheBest(2000000000);
        end = getSystemTime();
        result = end - start;
        System.out.println("time divisorTheBest 1 = " + result);

        start = getSystemTime();
        searchForNumbers(2000000000);
        end = getSystemTime();
        result = end - start;
        System.out.println("time searchForNumbers 2 = " + result);

        start = getSystemTime();
        defDivisor(2000000000);
        end = getSystemTime();
        result = end - start;
        System.out.println("time defDivisor 3 = " + result);
    }

    private static long getSystemTime() {
        return System.currentTimeMillis();
    }
}
