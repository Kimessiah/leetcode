// Time O(m^2 * n^2)   Space O(m*n)
public boolean exist(char[][] board, String word) {

	if (board == null || board.length == 0 || board[0].length == 0) return false;
	if (word == null || word.length() == 0) return false;

	boolean[][] used = new boolean[board.length][board[0].length]; 
	for (int i = 0; i< board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
			if (helper(board, word, i, j, 0, used)) {
				return true;
			}
		}
	}
	return false;
}

boolean helper(char[][] board, String word, int i, int j, int index, boolean[][] used) {

	if (index == word.length()) return true;

	if (i<0 || j<0 || i>=board.length || j>= board[0].length 
		|| used[i][j] || board[i][j] != word.charAt(index)) {
		return false;
	}

	used[i][j] = true;

	boolean res = helper(board, word, i-1, j, index+1, used)
					|| helper(board, word, i+1, j, index+1, used)
					|| helper(board, word, i, j-1, index+1, used)
					|| helper(board, word, i, j+1, index+1, used);

	used[i][j] = false;

	return res;
}