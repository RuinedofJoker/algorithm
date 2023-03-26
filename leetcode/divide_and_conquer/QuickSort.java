package divide_and_conquer;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] randomNum = generateRandomNum(5);
        randomNum = new QuickSort().sort(randomNum);
        System.out.println();
    }

    private static int[] generateRandomNum(int n){
        Random random = new Random();
        int[] randomNums = new int[n];
        for (int i = 0; i < n; i++){
            randomNums[i] = random.nextInt(100);
        }
        return randomNums;
    }

    public int[] sort(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int pivot = 1; //1为以left做轴点，-1为以right做轴点

        if (nums.length == 2){
            if (nums[left] > nums[right]){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            return nums;
        }
        while (left < right){
            if (nums[left] > nums[right]){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                pivot = -pivot;
            }
            if (pivot == 1){
                right--;
            }else {
                left++;
            }
        }
        //轴点左边元素数目大于1才有排序的必要
        if (left > 1){
            int[] leftSorted = sort(Arrays.copyOf(nums, left));
            for (int i = 0; i < leftSorted.length; i++){
                nums[i] = leftSorted[i];
            }
        }
        //轴点右边元素数目大于1才有排序的必要
        if (left < nums.length - 3){
            int[] rightSorted = sort(Arrays.copyOfRange(nums, left + 1, nums.length));
            int temp = nums.length - 1;
            for (int i = 0; i < rightSorted.length; i++){
                nums[temp] = rightSorted[i];
                temp--;
            }
        }
        return nums;
    }
}
