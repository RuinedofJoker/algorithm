package 剑指;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        //int[] exchange = new 调整数组顺序使奇数位于偶数前面().exchange(new int[]{1, 11, 14});
        int[] exchange = new 调整数组顺序使奇数位于偶数前面().exchange(new int[]{1,2,3,4});
        System.out.println(exchange);
    }
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left < nums.length && nums[left] % 2 == 1) {
                left++;
            }
            while (right >= 0 && nums[right] % 2 == 0) {
                right--;
            }

            if (left > right || left >= nums.length || right < 0) {
                break;
            }
            if (nums[left] % 2 == 0 && nums[right] % 2 == 1) {
                if (left < right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }else {
                    break;
                }
            }else {
                break;
            }
        }

        return nums;
    }
}
