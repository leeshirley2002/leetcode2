/*Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]*/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int row = n;
        int col = n;
        int x = 0;
        int y = -1;
        int num = 1;
        while(row>0 && col>0){
            for(int i=0;i<col;i++){
                y++;
                res[x][y] = num;
                num++;  
            }
            row--;
            if(row == 0){
                break;
            }
            for(int i=0;i<row;i++){
                x++;
                res[x][y] = num;
                num++;
            }
            col--;
            if(col == 0){
                break;
            }
            for(int i=0;i<col;i++){
                y--;
                res[x][y] = num;
                num++;
            }
            row--;
            if(row ==0){
                break;
            }
            for(int i=0;i<row;i++){
                x--;
                res[x][y] = num;
                num++;
            }
            col--;
        }
        return res;
    }
}