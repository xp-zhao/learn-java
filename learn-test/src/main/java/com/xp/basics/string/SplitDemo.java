package com.xp.basics.string;

public class SplitDemo {
    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] arr = str.split(",");
        System.out.println(arr.length);
    }
}
