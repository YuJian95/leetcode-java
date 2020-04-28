package easy;

/**
 * @author YuJian95 clj9509@163.com
 * @date 2020/4/28
 */

public class PivotIndex {

    public static void main(String[] args) {
        int[] array = {-1,-1,0,1,1,0};
        System.out.println(pivotIndex(array));
    }

    public static int pivotIndex(int[] nums) {

        int sum = 0;

        // sum of nums
        for (int num : nums) {
            sum += num;
        }

        int leftSum = 0;

        for (int i = 0; i <= nums.length - 1; i++) {

            if (leftSum == (sum - leftSum - nums[i])){
                return i;
            }

            leftSum += nums[i];
        }

        // no exist
        return -1;
    }
}
