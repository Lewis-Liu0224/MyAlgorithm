package com.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusong0224
 * @date 2020/10/28 16:06
 * @Description
 */
public class day05 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0 ){
            return result;
        }
        int left = 0;
        int top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        while (left<=right && top<=bottom){
            //left2right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            //top2bottom
            for (int i = top+1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            //最后存在只剩一列或者一行的情况（也就是left==right或者top==bottom）的情况，这时遍历一次就够了
            if (left<right && top<bottom){
                //right2left
                for (int i = right-1; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                //bottom2top
                for (int i = bottom-1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}
