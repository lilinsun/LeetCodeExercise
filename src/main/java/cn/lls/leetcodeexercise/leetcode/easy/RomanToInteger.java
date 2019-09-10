package cn.lls.leetcodeexercise.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * LeetCode第13题：罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LLS
 */

@Slf4j
public class RomanToInteger {
    /**
     * 解题思路：
     * 首先用一个HashMap将所有的罗马字母存储为k-v形式，遍历字符串，如果当前字符是最后一个字符，则直接相加
     * 如果不是最后一个字符，判断当前字符值是否大于后面的字符，是则加上第一个字符的值，否则减去第一个字符的值
     *
     * @param s 输入罗马数字字符串
     * @return 返回数字
     */
    private static int romanToInt(String s) {
        //用HashMap存储所有的罗马字母
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int firstValue = 0;
        int nextValue = 0;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            firstValue = map.get(s.charAt(i));
            //如果当前字符是最后一个字符，直接相加
            if (i == s.length() - 1) {
                sum += firstValue;
            } else {
                //如果不是最后一个字符，判断当前字符值是否大于后面的字符，是则加上第一个字符的值，否则减去第一个字符的值
                nextValue = map.get(s.charAt(i + 1));
                if (firstValue >= nextValue) {
                    sum += firstValue;
                } else {
                    sum -= firstValue;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";

        int result = romanToInt(s);

        log.info("输出结果为：{}", result);
    }
}
