package cn.lls.leetcodeexercise.leetcode;

import lombok.extern.slf4j.Slf4j;


/**
 * LeetCode第7题：
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LLS
 */
@Slf4j
public class ReverseInteger {

    /**
     * 解题思路：
     * 将当前数对10取余,加上当前结果*10，再将输入值除以10以去掉已经处理的最后一位数字。
     * <p>
     * 最后，注意结果的范围判断。
     *
     * @param x 输入数字
     * @return 反转后的数字
     */
    private static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int x = 1534236469;

        int result = reverse(x);

        log.info("输出结果：{}", result);
    }
}
