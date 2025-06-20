package com.java.collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<Character> chars = new ArrayList<>(3);
        chars.add('a');
        chars.add('b');


        Character[] str = new Character[5];
        Integer nums[] = new Integer[5];
        nums[2] = 4432;
        Long[] ndd = new Long[4];
        System.out.println();
        Character c = str[2];

        String[][] name = {{"Hello", "cfsfj"}, {"dsj"}, {"fsf"}};
//        String[] strd= new String("Heelo", "dfj");
        String str1 = "Hello world!";
//
//        String s = str1 + "erww";
//        String dfsf = s.concat("dfsf");
//        System.out.println("s: " +s);
//        System.out.println("str1: " + str1);
//        System.out.println("dfds: " + dfsf);

        StringBuilder sb = new StringBuilder("Hello");
        StringBuffer sbdd = new StringBuffer("dcf");
//        thrread


        sb.append(" worlds!");
        System.out.println(sb);

//
//        String sss = "                    dfjs";
//        String ss = " ";
////        str1.
//        System.out.println(ss.isBlank());
//        System.out.println(ss.isEmpty());
//        System.out.println(sss.trim());
//        System.out.println(sss);
//

        System.out.println(chars.get(1));



        int cnt = 0;
        Thread t1 = new Thread(()-> {

        });
    }
}
