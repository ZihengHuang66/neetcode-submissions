class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        // put all treasures in the queue
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        // set directions
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] dir : directions) {
                int row = r + dir[0];
                int col = c + dir[1];

                if(row < 0 || row >= grid.length || col < 0 
                                    || col >= grid[0].length) {
                    continue;
                }
                
                // only visit the INF
                if(grid[row][col] == Integer.MAX_VALUE) {
                    grid[row][col] = grid[r][c] + 1;
                    q.add(new int[]{row, col});
                }
            }
        }
    }
}











