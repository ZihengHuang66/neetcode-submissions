class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                visited = new boolean[board.length][board[0].length];
                if(helper(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int currRow, int currCol, int index, boolean[][] visited) {
        if(index == word.length()) {
            return true;
        }
        if(currRow >= board.length || currCol >= board[0].length || currRow < 0 || currCol < 0 || visited[currRow][currCol] || board[currRow][currCol] != word.charAt(index)) {
            return false;
        }
        visited[currRow][currCol] = true;
        boolean res = helper(board, word, currRow + 1, currCol, index + 1, visited) || helper(board, word, currRow - 1, currCol, index + 1, visited) || helper(board, word, currRow, currCol + 1, index + 1, visited) || helper(board, word, currRow, currCol - 1, index + 1, visited);
        visited[currRow][currCol] = false;
        return res;
    }
}


// A B C E
// S F E S
// A D E E
