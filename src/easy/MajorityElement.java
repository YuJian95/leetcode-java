package easy;

import java.util.HashMap;

/**
 * 面试题 17.10. 主要元素
 *
 * @author YuJian95  clj9509@163.com
 * @date 2020/4/7
 */

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2}));
    }

    /**
     * 给定一个整数数组，找到它的主要元素。若没有，返回-1。
     *
     * @param nums 整数数组
     * @return 主要元素。若没有，返回-1。
     */
    public int majorityElement(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        final int middleSize = nums.length / 2;

        HashMap<Integer, Integer> element = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (!element.containsKey(num)) {
                element.put(num, 1);
                continue;
            }

            int total = element.get(num) + 1;

            // i >= middleSize 判断是否已经遍历了一半的数据
            // total >= (middleSize + 1) 判断是否已经超过一半
            if (i >= middleSize && total >= (middleSize + 1)) {
                return num;
            }

            element.put(num, total);

        }

        return -1;
    }
}
