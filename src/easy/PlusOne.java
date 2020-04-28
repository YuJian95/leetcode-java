package easy;

/**
 * @author YuJian95  clj9509@163.com
 * @date 2020/4/28
 */

public class PlusOne {

    public int[] plusOne(int[] digits) {

        // 注意是从后往前计算。
        for(int i = digits.length - 1; i >= 0; i--){
            // 对数位进行加一
            digits[i]++;

            // 获取当前位数的值
            digits[i] = digits[i] % 10;

            // 不需要进位时，直接返回结果
            if(digits[i] != 0){
                return digits;
            }
        }

        // 这里是需要进位的情况。
        // int 数组默认赋值 0
        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }
}
