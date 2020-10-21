package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例：
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针

public class day01 {

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
//        进行排序
        Arrays.sort(nums);
        for (int first = 0; first < n; first++) {
//            跳过重复的元素
            if (first>0&&nums[first]==nums[first-1])
                continue;
//            双指针，一个从头部开始一个从尾部开始
            int third = n-1;
            int target = -nums[first];
            for (int second = first+1; second < n; second++) {
                if (second>first+1&&nums[second]==nums[second-1])
                    continue;
//                尾指针从尾部开始必然是最大的，在往前移动的过程中，值会越来越小
                while (second<third&&nums[second]+nums[third]>target)
                    third--;
//                或头尾指针相遇，说明两个值都过大
                if (second==third)
                    break;
                if (nums[second]+nums[third]==target){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
