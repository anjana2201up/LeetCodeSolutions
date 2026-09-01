class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    litter++;
                }
            }
        }

        if (litter == 0) {
            return 0;
        }

        int[][] id = new int[m][n];

        for (int i = 0; i < m; i++) {
            java.util.Arrays.fill(id[i], -1);
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'L') {
                    id[i][j] = count++;
                }
            }
        }

        int states = 1 << litter;

        int[][][] best = new int[m][n][states];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                java.util.Arrays.fill(best[i][j], -1);
            }
        }

        java.util.ArrayDeque<int[]> queue = new java.util.ArrayDeque<>();

        int mask = 0;

        best[sr][sc][mask] = energy;

        queue.offer(new int[]{sr, sc, mask, energy, 0});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int r = cur[0];
            int c = cur[1];
            int currentMask = cur[2];
            int currentEnergy = cur[3];
            int moves = cur[4];

            if (currentMask == states - 1) {
                return moves;
            }

            if (currentEnergy == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int newEnergy = currentEnergy - 1;
                int newMask = currentMask;

                if (id[nr][nc] != -1) {
                    newMask |= (1 << id[nr][nc]);
                }

                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }

                if (best[nr][nc][newMask] < newEnergy) {
                    best[nr][nc][newMask] = newEnergy;

                    queue.offer(new int[]{
                        nr,
                        nc,
                        newMask,
                        newEnergy,
                        moves + 1
                    });
                }
            }
        }

        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna