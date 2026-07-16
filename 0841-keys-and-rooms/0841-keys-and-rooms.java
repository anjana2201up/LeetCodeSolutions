class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];

        dfs(0, rooms, visited);

        for (boolean room : visited) {
            if (!room)
                return false;
        }

        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {

        visited[room] = true;

        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna