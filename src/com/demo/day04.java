package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day04 {

    boolean[] marked;
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<List<Integer>>();
        marked = new boolean[nums.length];
        List<Integer> curr = new ArrayList<>();
        backTracing(nums,0,curr);
        return result;
    }

    public static void main(String[] args) {
        day04 day04 = new day04();
        List<List<Integer>> result1 = day04.permute(new int[]{1, 2, 3});
        System.out.println(result1);

    }

    public void backTracing(int[] nums,int level,List<Integer> curr){

        if (level==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (marked[i]){
                continue;
            }
            marked[i]=true;
            curr.add(nums[i]);
            backTracing(nums, level+1, curr);
            curr.remove(curr.size()-1);
            marked[i] = false;
        }
    }
}
