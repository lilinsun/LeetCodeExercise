package cn.lls.leetcodeexercise.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * LeetCode第20题：有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LLS
 */
@Slf4j
public class ValidParentheses {
    /**
     * 解题思路：使用"栈"
     * <p>
     * 将括号对以k-v形式存储在Map中。遍历输入字符串，如果当前符号是左括号将其压入栈中。如果当前符号是右括号，
     * 同时栈当前为空，或者栈顶元素不等于当前元素的value，则返回false
     *
     * @param s 输入字符串
     * @return 是否为有效的括号
     */
    private static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            if ((c == ')' || c == ']' || c == '}') && (stack.isEmpty() || !stack.pop().equals(map.get(c)))) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[()]}[()]()";

        boolean result = isValid(s);

        log.info("输出结果为：{}", result);
    }
}
