package easy;

/**
 * 1154. 一年中的第几天
 *
 * @author YuJian95  clj9509@163.com
 * @date 2020/4/4
 */

public class DayOfYear {

    public static void main(String[] args) {
        System.out.println(new DayOfYear().dayOfYear("2004-03-01"));
    }

    /**
     * 计算并返回该日期是当年的第几天
     *
     * @param date YYYY-MM-DD 格式表示日期的字符串
     * @return 该日期是当年的第几天
     */
    public int dayOfYear(String date) {
        // 切割年月日
        String[] time = date.split("-");

        int year = Integer.parseInt(time[0]);
        int month = Integer.parseInt(time[1]);
        int day = Integer.parseInt(time[2]);

        // 每个月的天数
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 闰年的时候，把二月时间改完 29天
        if (isLeapYear(year)) {
            daysOfMonth[1] = 29;
        }

        int sum = day;

        // 计算当月前的天数
        for (int i = 0; i < (month - 1); i++) {
            sum += daysOfMonth[i];
        }

        return sum;
    }

    /**
     * 是否闰年
     *
     * @param year 年份
     * @return 是否闰年
     */
    private boolean isLeapYear(int year) {

        // 四年闰，百年不闰
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }

        // 四百年闰
        return year % 400 == 0;
    }
}
