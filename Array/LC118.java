/*Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows == 0){
            return res;
        }
        List<Integer> level1 = new ArrayList<Integer>();
        level1.add(1);
        res.add(level1);
        if(numRows == 1){
            return res;
        }
        List<Integer> level2 = new ArrayList<Integer>();
        level2.add(1);
        level2.add(1);
        res.add(level2);
        for(int i=2; i<numRows; i++){
            List<Integer> current = new ArrayList<Integer>();
            current.add(1);
            List<Integer> upper = res.get(i-1);
            for(int j=0; j<upper.size()-1;j++){
                current.add(upper.get(j)+upper.get(j+1));
            }
            current.add(1);
            res.add(current);
        }
        return res;
    }
}