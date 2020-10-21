package com.demo;

import java.util.Arrays;

public class day02 {
    //给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
// 使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。
//
//
//
// 示例：
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
    int ans = Integer.MAX_VALUE / 2;

    public int threeSumClosest(int[] nums, int target) {
        int result;
        int min;
        int n = nums.length;
        //对数组从小到大排序
        Arrays.sort(nums);
//        枚举第一个数
        for (int first = 0; first < n; first++) {
//            双指针，一个指向头一个指向尾
            int second = first + 1;
            int third = n - 1;
//            头尾相遇，或者头部超过数组长度则跳出
            if (second >= n || second == third)
                continue;
//            当first+second+third的值大于target，则将尾指针向前移。反之则将头指针向后移
//            当相加值相等时，直接返回结果
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                update(sum, target);
                if (sum > target) {
                    third--;
                } else if (sum < target) {
                    second++;
                } else {
                    return target;
                }

            }
        }
        return ans;
    }

//    每次得到值时，进行一次更新
    public void update(int sum, int target) {
        int diff = Math.abs(sum - target);
        int minDiff = Math.abs(ans - target);
        if (diff < minDiff) {
            ans = sum;
        }
    }
}
