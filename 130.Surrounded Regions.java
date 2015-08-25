public void solve(char[][] board) {

	if (board == null || board.length < 3 || board[0].length < 3) {
		return;
	}	

	Queue<Integer> queue = new LinkedList<Integer>();


	for (int i = 0; i < board.length; i++) {
		enqueue(board, queue, i, 0);
		enqueue(board, queue, i, board[0].length-1);
	}

	for (int i = 0; i < board[0].length; i++) {
		enqueue(board, queue, 0, i);
		enqueue(board, queue, board.length-1, i);
	}

	while (!queue.isEmpty()) {

		int curr = queue.poll();
		int i = curr / board[0].length;
		int j = curr % board[0].length;

		board[i][j] = '#';

		enqueue(board, queue, i-1, j);
    	enqueue(board, queue, i, j-1);
    	enqueue(board, queue, i+1, j);
    	enqueue(board, queue, i, j+1);
	}

	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
			if (board[i][j] == '#') {
				board[i][j] = 'O';
			} else if (board[i][j] == 'O') {
				board[i][j] = 'X';
			}
		}
	}
}

void enqueue(char[][] board, Queue<Integer> queue, int i, int j) {

	if (i >=0 && i < board.length && j >=0 && j < board[0].length 
		&& board[i][j] == 'O') {
		queue.offer(i * board[0].length + j);
	}
}