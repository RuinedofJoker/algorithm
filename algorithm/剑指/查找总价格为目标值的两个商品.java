package 剑指;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LCR 179. 查找总价格为目标值的两个商品
 */
public class 查找总价格为目标值的两个商品 {
    public int[] twoSum(int[] price, int target) {
        Set<Integer> map = new HashSet<>();

        for (int i = 0; i < price.length; i++) {
            int pairNum = target - price[i];
            if (map.contains(pairNum)) {
                return new int[]{price[i], pairNum};
            }else {
                map.add(price[i]);
            }
        }

        return null;
    }
}
