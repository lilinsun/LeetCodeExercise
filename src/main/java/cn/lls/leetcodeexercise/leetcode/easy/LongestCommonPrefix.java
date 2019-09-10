package cn.lls.leetcodeexercise.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

/**
 * LeetCode第14题：最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LLS
 */
@Slf4j
public class LongestCommonPrefix {
    /**
     * 解题思路：
     * 首先将第一个字符串作为前缀结果，循环判断其他字符串是否包含这个前缀，如果不包含则将前缀的最后一个字符删除，直到寻找到最长的前缀
     *
     * @param strs 输入字符串数组
     * @return 最长公共前缀
     */
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0,result.length()-1);
                if(result.isEmpty()){
                    return "";
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"abcdefg", "abcdefgh", "abcdef"};

        String result = longestCommonPrefix(strs);

        log.info("输出结果为：{}", result);
    }
}
