package easy;

/**
 * 204. 计数质数
 *
 * @author YuJian95  clj9509@163.com
 * @date 2020/4/3
 */

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(2));
    }

    /**
     * 统计所有小于非负整数 n 的质数的数量
     *
     * @param n 非负整数
     * @return 质数的数量
     */
    public int countPrimes(int n) {

        // 存放结果
        boolean[] isPrime = new boolean[n];

        // 假设所有数为质数
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < Math.sqrt(n); i++) {

            // 即不是素数的时候
            if (!isPrime[i]) {
                continue;
            }

            // 素数的倍数一定不是素数
            for (int j = i * i; j < n; j += i) {
                // 不是质数
                isPrime[j] = false;
            }

        }

        int total = 0;

        for (int i = 1; i <= n - 1; i++) {

            // 是质数时，计数
            if (isPrime[i]) {
                total += 1;
            }
        }

        return total;
    }

//    /**
//     * 判断是否质数
//     * <p>
//     * 质数是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数。
//     *
//     * @param n 非负整数
//     * @return 质数
//     */
//    private boolean isPrime(int n) {
//
//        if (n <= 3) {
//            return n > 1;
//        }
//
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if (n % i == 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }
}
