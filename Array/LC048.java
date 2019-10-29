/*You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

Given input matrix =
[
  [ 5, 2, 13,15],
  [ 1, 4, 8,10],
  [9, 3, 6, 7],
  [11,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]*/


class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                if(i != j){
                    swap(matrix, i, j, j, i);
                }
            }
        }
        for(int j=0;j<matrix[0].length/2;j++){
            for(int i=0;i<matrix.length;i++){
                swap(matrix, i, j, i, matrix.length-1-j);
            }
        }
    }
    public void swap(int[][] matrix, int m, int n, int x, int y){
        int tmp = matrix[m][n];
        matrix[m][n] = matrix[x][y];
        matrix[x][y] = tmp;
    }
}