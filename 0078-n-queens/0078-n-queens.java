class Solution {

    private List<List<String>> solutions = new ArrayList<>();
    private char[][] board;
    private boolean[] columns;
    private boolean[] diagonal;
    private boolean[] antiDiagonal;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        columns = new boolean[n];
        diagonal = new boolean[2 * n];
        antiDiagonal = new boolean[2 * n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        placeQueen(0, n);
        return solutions;
    }

    private void placeQueen(int row, int n) {
        if (row == n) {
            List<String> configuration = new ArrayList<>();
            for (char[] currentRow : board) {
                configuration.add(new String(currentRow));
            }
            solutions.add(configuration);
            return;
        }

        for (int col = 0; col < n; col++) {
            int diagIndex = row - col + n;
            int antiDiagIndex = row + col;

            if (columns[col] || diagonal[diagIndex] || antiDiagonal[antiDiagIndex]) {
                continue;
            }

            board[row][col] = 'Q';
            columns[col] = true;
            diagonal[diagIndex] = true;
            antiDiagonal[antiDiagIndex] = true;

            placeQueen(row + 1, n);

            board[row][col] = '.';
            columns[col] = false;
            diagonal[diagIndex] = false;
            antiDiagonal[antiDiagIndex] = false;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna