import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        char[][] board = { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } };
        String word = "AAB";
        System.out.println(exist(board, word));
    }

    static boolean[][] stat;
    static boolean ans;

    static boolean dfs(char[][] board, boolean[][] stat, int i, int j, String word, int wi) {
        /*System.out.println(i + " " + j);
        for (int k = 0; k < stat.length; k++) {
            for (int k2 = 0; k2 < stat.length; k2++) {
                System.out.print(stat[k][k2] + " ");
            }
            System.out.println();
        }*/
        if (ans)
            return ans;
        if (wi == word.length() - 1 && word.charAt(wi) == board[i][j])
            return true;

        if (i > board.length || j > board[0].length)
            return false;
        if (board[i][j] != word.charAt(wi)) {
            return false;
        }
        stat[i][j] = true;
        if (i - 1 >= 0 && !stat[i - 1][j] && !ans) {
            stat[i - 1][j] = true;
            ans |= dfs(board, stat, i - 1, j, word, wi + 1);
            stat[i - 1][j] = false;
        }
        if (i + 1 < board.length && !stat[i + 1][j] && !ans) {
            stat[i + 1][j] = true;
            ans |= dfs(board, stat, i + 1, j, word, wi + 1);
            stat[i + 1][j] = false;

        }
        if (j + 1 < board[0].length && !stat[i][j + 1] && !ans) {
            stat[i][j + 1] = true;
            ans |= dfs(board, stat, i, j + 1, word, wi + 1);
            stat[i][j + 1] = false;
        }
        if (j - 1 >= 0 && !stat[i][j - 1] && !ans) {
            stat[i][j - 1] = true;
            ans |= dfs(board, stat, i, j - 1, word, wi + 1);
            stat[i][j - 1] = false;

        }
        stat[i][j] = false;
        return ans;
    }

    static public boolean exist(char[][] board, String word) {
        stat = new boolean[board.length][board[0].length];
        for (int i = 0; i < stat.length; i++) {
            Arrays.fill(stat[i], false);
        }
        ans = false;
        for (int i = 0; i < stat.length; i++) {
            for (int j = 0; j < stat[0].length; j++) {
                ans |= dfs(board, stat, i, j, word, 0);
                if (ans)
                    return ans;
            }
        }
        return ans;
    }
}