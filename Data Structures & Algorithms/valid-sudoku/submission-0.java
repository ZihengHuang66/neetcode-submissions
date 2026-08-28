class Solution {
    public boolean isValidSudoku(char[][] board) {
        return checkNine(board) && checkThree(board);
    }

    private static boolean isNumber(char ch) {
        int num = (int) ch;
        return ch >= 49 && ch <= 57;
    }

    private static boolean checkNine(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            Set<Character> rowCheck = new HashSet<>();
            Set<Character> colCheck = new HashSet<>();
            int validNumRow = 0;
            int validNumCol = 0;
            for(int j = 0; j < board[0].length; j++) {
                if(isNumber(board[i][j])) {
                    rowCheck.add(board[i][j]);
                    validNumRow++;
                }
                if(isNumber(board[j][i])) {
                    colCheck.add(board[j][i]);
                    validNumCol++;
                }
            }
            if(!(rowCheck.size() == validNumRow && colCheck.size() == validNumCol)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkThree(char[][] board) {
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                if(!checkThreeHelper(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean checkThreeHelper(char[][] board, int startRow, int startCol) {
        Set<Character> nums = new HashSet<>();
        int validNum = 0;

        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(isNumber(board[i][j])) {
                    nums.add(board[i][j]);
                    validNum++;
                }
            }
        }
        return validNum == nums.size();
    }
}
