class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int dir = 0;
        int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}};
        for(char c : instructions.toCharArray()) {
            if(c == 'G') {
                x += moves[dir][0];
                y += moves[dir][1];
            } else if(c == 'L') {
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }
        return (x == 0 && y == 0) || dir != 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna