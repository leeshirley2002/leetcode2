/*Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]




Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Coordinates> zeroes = new ArrayList<Coordinates>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    Coordinates c = new Coordinates(i, j);
                    zeroes.add(c);
                }
            }
        }
        for(Coordinates c : zeroes){
            fillZeroRow(matrix, c.X);
            fillZeroColumn(matrix, c.Y);
        }
    }
    public void fillZeroRow(int[][] matrix, int row){
        for(int i=0;i<matrix[0].length;i++){
            matrix[row][i] = 0;
        }
    }
    public void fillZeroColumn(int[][] matrix, int col){
        for(int i=0;i<matrix.length;i++){
            matrix[i][col] = 0;
        }
    }
    class Coordinates(){
        int X;
        int Y;
        public Coordinates(int x, int y){
            this.X = x;
            this.Y = y;
        }
    }
}
//space complexity: O(1)
//use first col and first row as memo

0,1,2,0
3,4,5,2
1,3,1,5

class Solution{
    public void setZeroes(int[][] matrix) {
        boolean colflag = false;
        boolean rowflag = false;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                colflag = true;
            }
        }
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[0][j] == 0){
                rowflag = true;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(colflag){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
        if(rowflag){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }
    }
}
for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }