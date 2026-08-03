class RangeModule {
    private TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Integer start = map.floorKey(left);
        if (start != null && map.get(start) >= left) {
            left = start;
            right = Math.max(right, map.get(start));
            map.remove(start);
        }

        Integer key = map.ceilingKey(left);
        while (key != null && key <= right) {
            right = Math.max(right, map.get(key));
            map.remove(key);
            key = map.ceilingKey(left);
        }

        map.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        return start != null && map.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        Integer start = map.floorKey(left);
        if (start != null && map.get(start) > left) {
            int end = map.get(start);
            map.put(start, left);
            if (end > right) {
                map.put(right, end);
            }
        }

        Integer key = map.ceilingKey(left);
        while (key != null && key < right) {
            int end = map.get(key);
            map.remove(key);
            if (end > right) {
                map.put(right, end);
                break;
            }
            key = map.ceilingKey(left);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna