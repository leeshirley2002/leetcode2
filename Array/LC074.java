/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix, 0, matrix.length * matrix[0].length -1, target)
    }
    public boolean helper(int[][] matrix, int start, int end, int target){
        int middle = (start+end)/2;
        int x =　getPosition(matrix, middle)[0];
        int y =　getPosition(matrix, middle)[1];
        if(matrix[x][y] == target){
            return true;
        }else if(matrix[x][y] < target){
            return helper(matrix, middle+1, end, target);
        }else{
            return helper(matrix, start, middle, target);
        }
    }
    public int[] getPosition(int[][] matrix, int index){
        int[] res = new int[2];
        res[0] = index/matrix[0].length;
        res[1] = index%matrix[0].length;
        return res;
    }
}