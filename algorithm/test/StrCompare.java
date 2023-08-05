package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrCompare {
    public static void main(String[] args) {
        new StrCompare().strCompare("abcdefg", "25abdfxx");
    }
    void strCompare(String str1, String str2) {
        Map<Character, List<Integer>> strMap1 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            if (strMap1.containsKey(str1.charAt(i))) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                strMap1.put(str1.charAt(i), list);
            }else {
                strMap1.get(str1.charAt(i)).add(i);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            if (strMap1.containsKey(str2.charAt(i))) {

            }
        }
    }
}
