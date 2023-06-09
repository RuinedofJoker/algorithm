package leetcode;

/**
 * kmp算法
 */
public class KMP {

    private int[] next;
    String mode;

    public KMP(String mode) {
        this.mode = mode;
        next = getNext(mode);
    }

    public int search(String target) {
        int modeIndex = 0;

        for (int i = 0; i < target.length(); i++) {
            if (mode.charAt(modeIndex) == target.charAt(i)) {
                modeIndex++;
            }else {
                if (modeIndex == 0) {
                    continue;
                }
                modeIndex = next[modeIndex - 1];
                i--;
            }
            if (modeIndex == next.length) {
                return i - next.length + 1;
            }
        }
        return -1;
    }

    private int[] getNext(String mod) {
        int[] next = new int[mod.length()];
        for (int i = 0; i < mod.length(); i++) {
            String currentStr = mod.substring(0, i + 1);
            int left = 0;
            int right = currentStr.length() - 1;
            int currentSize = 0;

            while (left < right) {
                if (currentStr.charAt(left) != currentStr.charAt(right)) {
                    break;
                }
                left++;
                right--;
                currentSize++;
            }

            next[i] = currentSize;
        }
        return next;
    }
}
