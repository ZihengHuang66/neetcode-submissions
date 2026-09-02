class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacificVisited = new boolean[rows][cols];
        boolean[][] atlanticVisited = new boolean[rows][cols];

        // Pacific: top row + left column
        for(int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacificVisited);
            dfs(heights, rows - 1, c, atlanticVisited);
        }

        for(int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacificVisited);
            dfs(heights, r, cols - 1, atlanticVisited);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(pacificVisited[r][c] && atlanticVisited[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {

        if(r < 0 || c < 0 ||
           r >= heights.length || c >= heights[0].length ||
           visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        if(r + 1 < heights.length &&
           heights[r + 1][c] >= heights[r][c]) {
            dfs(heights, r + 1, c, visited);
        }

        if(r - 1 >= 0 &&
           heights[r - 1][c] >= heights[r][c]) {
            dfs(heights, r - 1, c, visited);
        }

        if(c + 1 < heights[0].length &&
           heights[r][c + 1] >= heights[r][c]) {
            dfs(heights, r, c + 1, visited);
        }

        if(c - 1 >= 0 &&
           heights[r][c - 1] >= heights[r][c]) {
            dfs(heights, r, c - 1, visited);
        }
    }
}