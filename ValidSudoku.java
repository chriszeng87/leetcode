/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.
 * @author Chris
 *
 */
public class ValidSudoku {
	
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0
            || board[0].length == 0) {
                return false;
        }
        
        int len = board.length;
        boolean[] rowVisited = new boolean[len];
        boolean[] colVisited = new boolean[len];
        boolean[] subVisited = new boolean[len];
        int i = 0, j = 0, k = 0;
        //check every row
        for ( ; i <  len; i++) {
            for (k = 0; k < len; k++) {
                colVisited[k] = false;
            }
            for ( j = 0; j < len; j++) {
                if(board[i][j] != '.') {
                    if(colVisited[board[i][j] - '1']) {
                        return false;
                    } else {
                        colVisited[board[i][j] - '1'] = true;
                    }
                }
            }
        }
        
        //check every col
        for (j = 0; j < len; j++) {
            for (k = 0; k < len; k++) {
                rowVisited[k] = false;
            }
            for(i = 0; i < len; i++) {
                if(board[i][j] != '.') {
                    if(rowVisited[board[i][j] - '1']) {
                        return false;
                    } else {
                        rowVisited[board[i][j] - '1'] = true;
                    }
                }
            }
        }
        
      //check every sub matrix
      for (int m = 0; m < 3; m++) {
          for (int n = 0; n < 3; n++) {
              for (k = 0; k < len; k++) {
                  subVisited[k] = false;
              }
              
              for (i = 0; i < 3; i++) {
                  for (j = 0; j < 3; j++) {
                      int row = 3 * m + i;
                      int col = 3 * n + j;
                      if(board[row][col] != '.') {
                            if (subVisited[board[row][col] - '1']) {
                                return  false;
                            } else {
                                subVisited[board[row][col] - '1'] = true;
                            }
                      }
                  }
              }
              
          }
      }
      
      return true;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
