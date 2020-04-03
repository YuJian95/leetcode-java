package easy;

import java.util.HashMap;

/**
 * 1365. 有多少小于当前数字的数字
 *
 * @author YuJian95  clj9509@163.com
 * @date 2020/4/3
 */

public class SmallerNumbersThanCurrent {

    public static void main(String[] args) {

    }

    /**
     * 统计数组中比它小的所有数字的数目
     *
     * @param nums 数组
     * @return 数组中比它小的所有数字的数目
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] result = new int[nums.length];

        // 存放已知结果
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (numMap.containsKey(i)) {
                result[i] = numMap.get(nums[i]);
                continue;
            }

            // 比它小得数
            int total = 0;

            // 计算已比当前数字小的数
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }

                if (nums[i] > nums[j]) {
                    total++;
                }
            }

            numMap.put(i, total);

            result[i] = total;
        }

        return result;
    }
}