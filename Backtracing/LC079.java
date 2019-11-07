/*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.*/

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0) != board[i][j]){
                    continue;
                }
                if(helper(word, 0, i,j, visited, board)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(String word, int start, int i, int j, boolean[][] visited, char[][] board){
        if(start == word.length()){
            return true;
        }
        if(i>=0 && i<board.length && j>=0 && j<board[0].length && word.charAt(start) == board[i][j] && visited[i][j] == false){
            visited[i][j] = true;
            boolean d1 = helper(word,start+1, i+1,j, visited,board);
            boolean d2 = helper(word,start+1, i-1,j, visited,board);
            boolean d3 = helper(word,start+1, i,j+1, visited,board);
            boolean d4 = helper(word,start+1, i,j-1, visited,board);
            visited[i][j] = false;
            if(d1 || d2 || d3|| d4){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}