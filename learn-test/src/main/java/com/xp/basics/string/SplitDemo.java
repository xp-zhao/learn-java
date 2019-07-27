package com.xp.basics.string;

import java.util.Arrays;

public class SplitDemo {
    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] arr = str.split(",");
        System.out.println(arr.length);

        String nodeId = "RJB_SX_KBZSD_0";
        System.out.println(nodeId.lastIndexOf("_"));
        System.out.println(nodeId.substring(0, 12));

//        Arrays.asList(null);

        int i = 0;
        String str1 = "0";
        System.out.println(str1.equals(i));
    }
}
