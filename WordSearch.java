import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 * @author Chris
 *
 */

class Pos {
    public int row;
    public int col;
    
    Pos(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
public class WordSearch {
	

	    public static boolean exist(char[][] board, String remainWord, boolean[][] visited, Pos cur) {
	        int m = board.length, n = board[0].length;
	        if (remainWord.equals("")) {
	            return true;
	        }
	        
	        char c = remainWord.charAt(0);
	        Pos top = new Pos(cur.row - 1, cur.col);
	        if(cur.row - 1 >= 0 && !visited[cur.row - 1][cur.col] && board[cur.row - 1][cur.col] == c) {
	        	visited[cur.row - 1][cur.col] = true;
	            if ( exist(board, remainWord.substring(1), visited, top) ) {
	                return true;
	            }
	            visited[cur.row - 1][cur.col] = false;
	        }
	        
	        Pos left = new Pos(cur.row, cur.col - 1);
	        if(cur.col - 1 >= 0 && !visited[cur.row][cur.col - 1] && board[cur.row][cur.col - 1] == c) {
	        	visited[cur.row][cur.col - 1] = true;
	            if ( exist(board, remainWord.substring(1), visited, left) ) {
	                return true;
	            }
	            visited[cur.row][cur.col - 1] = false;
	        }
	        
	        Pos right = new Pos(cur.row, cur.col + 1);
	        if(cur.col + 1 < n && !visited[cur.row][cur.col + 1] && board[cur.row][cur.col + 1] == c) {
	        	visited[cur.row][cur.col + 1] = true;
	            if ( exist(board, remainWord.substring(1), visited, right) ) {
	                return true;
	            }
	            visited[cur.row][cur.col + 1] = false;
	        }
	        
	        Pos down = new Pos(cur.row + 1, cur.col);
	        if(cur.row + 1 < m && !visited[cur.row + 1][cur.col] && board[cur.row + 1][cur.col] == c) {
	            visited[cur.row + 1][cur.col] = true;
	            if ( exist(board, remainWord.substring(1), visited, down) ) {
	                return true;
	            }
	            visited[cur.row + 1][cur.col] = false;
	        }
	        
	        return false;
	        
	    }
	    
	    public static boolean exist(char[][] board, String word) {
	        if (board == null || board.length == 0 
	            || board[0].length == 0 || word == null
	            || word.length() == 0) {
	                return false;
	        }
	        
	        char first = word.charAt(0);
	        List<Pos> startList = new ArrayList<Pos>();
	        for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[0].length; j++) {
	                if (board[i][j] == first) {
	                    Pos temp = new Pos(i, j);
	                    startList.add(temp);
	                }
	            }
	        }
	        
	        boolean[][] visit = new boolean[board.length][board[0].length];
	        
	        for (Pos start : startList) {
	        	visit[start.row][start.col] = true;
	            if (exist(board, word.substring(1), visit, start)) {
	                return true;
	            }
	            visit[start.row][start.col] = false;
	        }
	        
	        return false;
	    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr = {"ABCE","SFCS","ADEE"};
		char[][] board = {arr[0].toCharArray(), arr[1].toCharArray(), arr[2].toCharArray()};
//		                 word = "ABCCED", -> returns true,
//		                 word = "SEE", -> returns true,
//		                 word = "ABCB", -> returns false.
		System.out.println(exist(board, "ABCCED"));
		System.out.println(exist(board, "SEE"));
		System.out.println(exist(board, "ABCB"));
	}

}
