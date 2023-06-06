package leetcode;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 *
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class LetterCombinationsofaPhoneNumber {

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations("7"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<String, String[]> dictionary;
        dictionary = new HashMap<>();
        char map = 'a';
        for (int i = 2; i <= 9; i++) {
            int k;
            if (i == 7 || i == 9) {
                k = 4;
            }else {
                k = 3;
            }
            String[] strings = new String[k];
            for (int j = 0; j < k; j++) {
                strings[j] = Character.toString(map);
                map++;
            }
            dictionary.put(Integer.toString(i), strings);
        }

        String[] split = digits.split("");
        List<String> result = new ArrayList<>();
        dfs(dictionary, split, result, new ArrayList<>());
        return result;
    }
    void dfs(Map<String, String[]> dictionary, String[] split, List<String> result, List<String> currentChar) {
        if (currentChar.size() == split.length) {
            StringBuilder builder = new StringBuilder();
            currentChar.stream().forEach(item -> builder.append(item));
            result.add(builder.toString());
            return;
        }

        String s = split[currentChar.size()];
        int j;
        if (s.equals("7") || s.equals("9")) {
            j = 4;
        }else {
            j = 3;
        }
        for (int i = 0; i < j; i++) {
            currentChar.add(dictionary.get(s)[i]);
            dfs(dictionary, split, result, currentChar);
            currentChar.remove(currentChar.size() - 1);
        }
    }
}
