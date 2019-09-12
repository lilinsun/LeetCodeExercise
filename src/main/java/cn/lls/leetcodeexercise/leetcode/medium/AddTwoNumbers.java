package cn.lls.leetcodeexercise.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

/**
 * LeetCode第2题：两数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LLS
 */
@Slf4j
public class AddTwoNumbers {
    /**
     * 解题思路：
     * 首先先设置一个0节点，指向结果的头结点，并设置一个进位。
     * 判断两个链表当前是否都为空，若不是将两个链表的当前结点值相加，计算当前位和进位，并将两个链表指向下一个结点。
     *
     * @param l1 第一个数
     * @param l2 第二个数
     * @return 两数之和
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lr = new ListNode(0);
        ListNode cur = lr;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return lr.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode num2 = new ListNode(4);
        ListNode num3 = new ListNode(3);
        l1.next = num2;
        num2.next = num3;

        ListNode l2 = new ListNode(5);
        ListNode num4 = new ListNode(6);
        ListNode num5 = new ListNode(4);
        l2.next = num4;
        num4.next = num5;

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            log.info("输出结果为：{}", result.val);
            result = result.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
