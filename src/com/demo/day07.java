package com.demo;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author liusong0224
 * @date 2020/11/3 9:03
 * @Description
 */
public class day07 {

    ArrayList<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        int n = nums.length;
        if (n==0){
            return  result;
        }
        ArrayList<Integer> curr = new ArrayList<>();
        dfs(0,0,curr,nums);

        return result;
    }

    private void dfs(int level,int index, ArrayList<Integer> curr,int[] nums) {
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            result.add(new ArrayList<>(curr));
            dfs(level+1, i+1, curr, nums);
            curr.remove(curr.size()-1);
        }
    }
}
