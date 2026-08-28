class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = searchRow(matrix, target);
        if(row == -1) {
            return true;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] == target) {
                return true;
            } else if(matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private static int searchRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[mid][0] == target) {
                return -1;
            } else if(matrix[mid][0] < target) {
                if(mid == matrix.length - 1 || matrix[mid + 1][0] > target) {
                    return mid;
                } else if(matrix[mid + 1][0] < target) {
                    left = mid + 1;
                } else {
                    return -1;
                }
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
/*
1  2  4  8
10 11 12 13
14 20 30 40
41 45 48 50
52 55 57 58
*/
