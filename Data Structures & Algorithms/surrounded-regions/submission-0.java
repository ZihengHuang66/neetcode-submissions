class Solution {
    public void solve(char[][] board) {
        int rs = board.length;
        int cs = board[0].length;
        boolean[][] mark = new boolean[rs][cs];

        for(int i = 0; i < rs; i++) {
            for(int j = 0; j < cs; j++) {
                if((i == 0 || j == 0 || i == rs - 1 || j == cs - 1) && board[i][j] == 'O') {
                    dfs(board, mark, i, j);
                }
            }
        }

        for(int i = 0; i < rs; i++) {
            for(int j = 0; j < cs; j++) {
                if(!mark[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] mark, int r, int c) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || mark[r][c] ||           board[r][c] == 'X') {
            return;
        }
        mark[r][c] = true;
        dfs(board, mark, r + 1, c);
        dfs(board, mark, r - 1, c);
        dfs(board, mark, r, c + 1);
        dfs(board, mark, r, c - 1);
    }
}
