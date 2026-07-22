class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }

            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {

        // Boundary and water check
        if (i < 0 || j < 0 ||
            i >= grid.length || j >= grid[0].length ||
            grid[i][j] == '0') {
            return;
        }

        // Mark visited
        grid[i][j] = '0';

        // Explore four directions
        dfs(grid, i + 1, j); // Down
        dfs(grid, i - 1, j); // Up
        dfs(grid, i, j + 1); // Right
        dfs(grid, i, j - 1); // Left
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna