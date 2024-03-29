package cn.lls.leetcodeexercise.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * LeetCode第1题：
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LLS
 */
@Slf4j
public class TwoSum {

    /**
     * 解题思路：
     *
     * 遍历数组，如果目标值-当前值不在Hashmap中，则将存入Map；如果存在则返回当前值和目标值-当前值得下标
     *
     * @param nums 输入数组
     * @param target 目标值
     * @return 数组下标
     */
    private static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];

        //用来存储遍历的结果
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(temp)) {
                index[0] = i;
                index[1] = hashMap.get(temp);
                return index;
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 15};
        int target = 10;

        int[] result = twoSum(nums, target);

        log.info("输出结果为：{}", result);
    }
}
