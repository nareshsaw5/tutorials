package com.dodo;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] ar = { 2, 1, 2, 3, 3, 5, 4, 1, 1, 3, 4 };
        Map map = getCounts(ar);
        List<Map.Entry<String, Integer>> capitalList = new ArrayList<>(map.entrySet());
        System.out.println(capitalList);
        Collections.sort(capitalList, (o1, o2) -> o1.getValue().compareTo(o2.getValue())  );
        System.out.println(capitalList);

    }

    static Map<String, Integer> getCounts(int[] ar) {

        Map<String, Integer> map = new HashMap();

        for (int i = 0; i < ar.length; i++) {
            String key = "" + ar[i];
            Integer count = map.getOrDefault(key, 0);
            map.put(key, 1 + count);
        }
        return map;
    }

}