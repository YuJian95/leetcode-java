package easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 1160. 拼写单词
 *
 * @author YuJian95  clj9509@163.com
 * @date 2020/4/4
 */

public class CountCharacters {

    public static void main(String[] args) {

        String[] words = {"cat", "bt", "hat", "tree"};

        String chars = "atach";

        System.out.println(new CountCharacters().countCharacters(words, chars));
    }

    /**
     * 拼写单词
     *
     * @param words 词汇表
     * @param chars 字符
     * @return 返回词汇表 words 中你掌握的所有单词的 长度之和
     */
    public int countCharacters(String[] words, String chars) {
        int sum = 0;

        // 空字符串返回空
        if (chars.trim().isEmpty()) {
            return sum;
        }

        HashMap<String, Integer> charCount = getCharCount(chars);

        HashMap<String, Integer> wordCount;

        // 获取可能存在拼写的字符
        for (String word : words) {

            // 单词表中的单词长度 > 拼接单词
            if (word.length() > chars.length()) {
                continue;
            }

            wordCount = getCharCount(word);

            // 是否存在
            boolean isExist = true;

            for (Map.Entry<String, Integer> stringIntegerEntry : wordCount.entrySet()) {
                String key = (String) ((Map.Entry) stringIntegerEntry).getKey();
                Integer value = (Integer) ((Map.Entry) stringIntegerEntry).getValue();

                // 不存在相应的字符，结束遍历
                if (!charCount.containsKey(key)) {
                    isExist = false;
                    break;
                }

                // 单词中对应的字符数量小于拼接字符
                if (charCount.get(key) < value) {
                    isExist = false;
                    break;
                }
            }

            if (isExist) {
                sum += word.length();
            }
        }

        return sum;
    }

    private HashMap<String, Integer> getCharCount(String chars) {

        HashMap<String, Integer> charCount = new HashMap<>();

        // 可拼接的字符串
        char[] string = chars.toCharArray();

        // 统计每个字符数目
        for (char value : string) {

            String c = String.valueOf(value);

            if (charCount.containsKey(c)) {
                // 原来基础上，增加 1
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }

        return charCount;
    }
}
