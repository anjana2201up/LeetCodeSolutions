class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zero = 0;
        int one = 0;

        for(int s : students) {
            if(s == 0)
                zero++;
            else
                one++;
        }

        for(int s : sandwiches) {
            if(s == 0) {
                if(zero == 0)
                    return one;
                zero--;
            } else {
                if(one == 0)
                    return zero;
                one--;
            }
        }

        return 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna