class Solution {
    // for in place soln we r updating the mat in such a way that
    // it stores both the updated and prev stat info simultanously

    // this function gives the previous state info given
    // the curruent or prev state
    // 0->1 2
    // 0->0 3
    // 1->0 4
    // 1->1 5
    static int pState(int i) {
        if (i < 2)
            return i;
        if (i < 4)
            return 0;
        return 1;
    }

    // this function decodes the current state
    // given the curruent or prev state
    // 0->1 2
    // 0->0 3
    // 1->0 4
    // 1->1 5
    static int cState(int i) {
        if (i < 2)
            return i;
        if (i % 2 == 0)
            return 1;
        return 0;
    }

    static int matrix_access(int i, int j, int[][] board) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return 0;
        }
        return board[i][j];
    }

    public void gameOfLife(int[][] board) {
        int sum;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sum = pState(matrix_access(i, j + 1, board)) +
                        pState(matrix_access(i, j - 1, board)) +
                        pState(matrix_access(i - 1, j, board)) +
                        pState(matrix_access(i + 1, j, board)) +
                        pState(matrix_access(i - 1, j - 1, board)) +
                        pState(matrix_access(i - 1, j + 1, board)) +
                        pState(matrix_access(i + 1, j - 1, board)) +
                        pState(matrix_access(i + 1, j + 1, board));
                if (board[i][j] == 0) {
                    if (sum == 3) {
                        board[i][j] = 2;
                    } else {
                        board[i][j] = 3;
                    }
                } else {
                    if (sum < 2 || sum > 3) {
                        board[i][j] = 5;
                    } else {
                        board[i][j] = 4;
                    }
                }
            }

        }
        for (int j = 0; j < board.length; j++) {
            for (int j2 = 0; j2 < board[0].length; j2++) {
                board[j][j2] = cState(board[j][j2]);
            }
        }
    }
}