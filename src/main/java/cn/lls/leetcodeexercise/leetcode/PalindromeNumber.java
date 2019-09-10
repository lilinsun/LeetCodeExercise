package cn.lls.leetcodeexercise.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * LeetCode第9题：回文数
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * @author LLS
 */
@Slf4j
public class PalindromeNumber {

    /**
     * 解题思路：
     * <p>
     * 如果是负数，则不是回文。剩余步骤参考反转数字。
     *
     * @param x 输入数字
     * @return 是否为回文
     */
    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = 0;
        int tempX = x;
        while (tempX != 0) {
            temp = temp * 10 + tempX % 10;
            tempX /= 10;
        }
        return temp == x;
    }


    public static void main(String[] args) {
        int x = 123321;

        boolean result = isPalindrome(x);

        log.info("输出结果为：{}", result);
    }
}
