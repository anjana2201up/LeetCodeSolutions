class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int ans=0,count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                count++;
            }
            ans+=count;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna