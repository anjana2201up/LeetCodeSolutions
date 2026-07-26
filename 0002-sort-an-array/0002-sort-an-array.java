class Solution {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int pivot = arr[high];
        int lt = low;
        int i = low;
        int gt = high;

        while (i <= gt) {

            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            }
            else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            }
            else {
                i++;
            }
        }
        quickSort(arr, low, lt - 1);
        quickSort(arr, gt + 1, high);
    }
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna