package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        Map<Character, Integer> sMap = new HashMap<>();
        char[] tChars = t.toCharArray();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < sChars.length; i++) {
            if (sMap.containsKey(sChars[i])) {
                sMap.put(sChars[i], sMap.get(sChars[i]) + 1);
            }else {
                sMap.put(sChars[i], 1);
            }
        }

        for (int i = 0; i < tChars.length; i++) {
            if (tMap.containsKey(tChars[i])) {
                tMap.put(tChars[i], tMap.get(tChars[i]) + 1);
            }else {
                tMap.put(tChars[i], 1);
            }
        }

        for (char sChar : sMap.keySet()) {
            if (!sMap.get(sChar).equals(tMap.get(sChar))) {
                return false;
            }
        }

        return true;
    }
}
