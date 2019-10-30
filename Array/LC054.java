/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0){
            return res;
        }
        int k = 0;
        int l = 0;
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        int x = 0;
        int y = 0;
        
        while(k<=m && l<=n){
            while(y<=n){
                System.out.println(matrix[x][y]);
                res.add(matrix[x][y]);
                y++;
            }
            y--;
            x++;
            k++;
            if(k>m || l>n){
                break;
            }
            while(x<=m){
                System.out.println(matrix[x][y]);
                res.add(matrix[x][y]);
                x++;
            }
            x--;
            y--;
            n--;
            if(k>m || l>n){
                break;
            }
            while(y>=l){
                System.out.println(matrix[x][y]);
                res.add(matrix[x][y]);
                y--;
            }
            y++;
            x--;
            m--;
            if(k>m || l>n){
                break;
            }
            while(x>=k){
                System.out.println(matrix[x][y]);
                res.add(matrix[x][y]);
                x--;
            }
            x++;
            y++;
            l++;
        }
        return res;
    }
}