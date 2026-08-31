class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int time = 0;
        int[][] directions = {
            {-1, 0}, 
            {1, 0}, 
            {0, -1}, 
            {0, 1}
        };
        
        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if(row < 0 || col < 0 || row >= grid.length 
                            || col >= grid[0].length) {
                        continue;
                    }
                    if(grid[row][col] == 1) {
                        grid[row][col] = 2;
                        fresh--;
                        q.offer(new int[]{row, col});
                    }
                }
            }
            time++;
        }
        if(fresh > 0) {
            return -1;
        }
        return time;
    }
}






