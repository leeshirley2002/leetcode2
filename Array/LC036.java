/*
use one enumeration to validate a Sudoku
box_index = (row/3)*3 + col/3
*/


class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Integer> [] rows  = new HashMap[9];
        HashMap<Character, Integer> [] cols  = new HashMap[9];
        HashMap<Character, Integer> [] boxes  = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Character, Integer>();
            cols[i] = new HashMap<Character, Integer>();
            boxes[i] = new HashMap<Character, Integer>();
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != '.'){
                    int box_index = (i/3)*3 + j/3;
                    rows[i].put(board[i][j], rows[i].getOrDefault(board[i][j], 0)+1);
                    cols[j].put(board[i][j], cols[j].getOrDefault(board[i][j], 0)+1);
                    boxes[box_index].put(board[i][j], boxes[box_index].getOrDefault(board[i][j], 0)+1);
                    if(rows[i].get(board[i][j])>1 || cols[j].get(board[i][j])>1 || boxes[box_index].get(board[i][j])>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}