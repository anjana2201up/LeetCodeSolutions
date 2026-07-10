import java.util.*;

class SummaryRanges {

    TreeMap<Integer, int[]> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int value) {

        Integer low = map.floorKey(value);
        Integer high = map.ceilingKey(value);

        // Already covered
        if (low != null && map.get(low)[1] >= value)
            return;

        boolean mergeLeft =
                low != null && map.get(low)[1] + 1 == value;

        boolean mergeRight =
                high != null && high == value + 1;

        if (mergeLeft && mergeRight) {

            map.get(low)[1] = map.get(high)[1];
            map.remove(high);

        }
        else if (mergeLeft) {

            map.get(low)[1]++;

        }
        else if (mergeRight) {

            int end = map.get(high)[1];
            map.remove(high);
            map.put(value, new int[]{value, end});

        }
        else {

            map.put(value, new int[]{value, value});

        }
    }

    public int[][] getIntervals() {

        return map.values().toArray(new int[map.size()][]);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna