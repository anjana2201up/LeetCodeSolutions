class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for(char c : moves.toCharArray()) {
            if(c == 'U') {
                y++;
            } else if(c == 'D') {
                y--;
            } else if(c == 'L') {
                x--;
            } else {
                x++;
            }
        }
        return x == 0 && y == 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna