package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 *
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 *
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 * 提示：
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */
public class RansomNote {
    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("aab", "baa"));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>(32);
        for (int i = 0; i < magazine.length(); i++) {
            if (!magazineMap.containsKey(magazine.charAt(i))) {
                magazineMap.put(magazine.charAt(i), 1);
            }else {
                magazineMap.put(magazine.charAt(i), magazineMap.get(magazine.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!magazineMap.containsKey(ransomNote.charAt(i))) {
                return false;
            }
            if (magazineMap.get(ransomNote.charAt(i)) == 0) {
                return false;
            }
            magazineMap.put(ransomNote.charAt(i), magazineMap.get(ransomNote.charAt(i)) - 1);
        }

        return true;
    }
}
