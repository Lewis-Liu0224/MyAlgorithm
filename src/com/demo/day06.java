package com.demo;

import java.util.Arrays;

/**
 * @author liusong0224
 * @date 2020/11/2 11:43
 * @Description
 */
public class day06 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int final_count = n*n;

        if (n==0){
            return result;
        }
        if (n==1){
            result[0][0] = 1;
            return result;
        }

        int count = 1;
        int left = 0;int right = result[0].length-1;
        int top = 0;int bottom = result.length-1;

        while (count<=final_count){
            for (int i = left; i <= right ; i++) {
                result[top][i] = count++;
                if (count>final_count){
                    break;
                }
            }
            for (int i = top+1; i <= bottom; i++) {
                result[i][right] = count++;
                if (count>final_count){
                    break;
                }
            }
            if (left<right && top<bottom){
                for (int i = right-1; i >=left ; i--) {
                    result[bottom][i] = count++;
                    if (count>final_count){
                        break;
                    }
                }
                for (int i = bottom-1; i > top; i--) {
                    result[i][left] = count++;
                    if (count>final_count){
                        break;
                    }
                }
            }
            left++;right--;
            top++;bottom--;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        day06 day06 = new day06();
        int i = day06.uniquePaths(3, 2);
        System.out.println(i);
    }

    public int uniquePaths(int m, int n) {
        if (m==0||n==0){
            return 0;
        }
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = i==0?0:dp[i-1][j];
                int left = j==0?0:dp[i][j-1];
                dp[i][j] += up+left;
            }
        }
        return dp[n-1][m-1];
    }

}
