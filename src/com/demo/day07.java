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
        dfs(0,curr,nums);

        return result;
    }

    private void dfs(int index, ArrayList<Integer> curr,int[] nums) {
        //每次从当前index开始遍历，保证没有重复的元素
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            result.add(new ArrayList<>(curr));
            dfs( i+1, curr, nums);
            curr.remove(curr.size()-1);
        }
    }

    //格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
//
// 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
//
// 格雷编码序列必须以 0 开头。
//
//
//
// 示例 1:
//
// 输入: 2
//输出: [0,1,3,2]
//解释:
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//
//对于给定的 n，其格雷编码序列并不唯一。
//例如，[0,2,3,1] 也是一个有效的格雷编码序列。
//
//00 - 0
//10 - 2
//11 - 3
//01 - 1
//
// 示例 2:
//
// 输入: 0
//输出: [0]
//解释: 我们定义格雷编码序列必须以 0 开头。
//     给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
//     因此，当 n = 0 时，其格雷编码序列为 [0]。
//
// Related Topics 回溯算法

    public List<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        //递增倍数
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = result.size()-1; j >= 0; j--) {
                result.add(result.get(j)+head);
            }
            //循环完后倍数加一倍
            head = head << 1;
        }
        return result;
    }
}
