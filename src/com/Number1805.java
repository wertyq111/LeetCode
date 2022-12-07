package com;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouxufeng
 * @version 1.0
 * 字符串中不同整数的数目
 */
@SuppressWarnings({"all"})
public class Number1805 {
    public static void main(String[] args) {
        String word = "a123bc34d8ef34";

        Number1805 number1805 = new Number1805();
        int number = number1805.numDifferentIntegers(word);
        System.out.println(number);
    }

    public int numDifferentIntegers(String word) {
        int i = 0,j;
        Set<String> set = new HashSet<>();
        int len = word.length();
        for(i = 0;i < len;) {
            if(Character.isDigit(word.charAt(i))) {
                j = i;
                while(j < len && Character.isDigit(word.charAt(j))) {
                    j++;
                }

                while(j - i > 1 && word.charAt(i) == '0') { //去除前导 0
                    i++;
                }

                System.out.println(word.substring(i,j));
                set.add(word.substring(i,j));
                i = j;
            } else {
                i++;
            }
        }

        return set.size();
    }
}
