// Time O(n^m) n is the number of possibilities for each square (i.e., 9 in classic Sudoku) 
// and m is the number of spaces that are blank.
public void solveSudoku(char[][] board) {
	helper(board, 0, 0);
}

boolean helper(char[][] board, int i, int j) {

	if (j == 9) {
		return helper(board, i+1, 0);
	}
	if (i == 9) {
		return true;
	}

	if (board[i][j] == '.') {
		for (int k = 1; k < 10; k++) {
			board[i][j] = (char)(k + '0');
			if (isValid(board, i, j)) {
			    if(helper(board, i, j+1))
			        return true;
			}
			board[i][j] = '.';
		}
	} else {
	    return helper(board, i, j+1);
	}
	return false;
}

boolean isValid(char[][] board, int i, int j) {  

    for(int k = 0; k < 9; k++) {  
        if(k != j && board[i][k] == board[i][j])  
            return false;  
    }  

    for(int k = 0; k < 9; k++) {  
        if(k != i && board[k][j] == board[i][j])  
            return false;  
    }

    for(int row = i/3*3; row < i/3*3+3; row++) {  
        for(int col = j/3*3; col <j /3*3+3; col++) {  
            if((row!=i || col!=j) && board[row][col]==board[i][j])  
                return false;  
        }  
    }  
    return true;  
}  