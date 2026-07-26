class Solution {
    public int waysToMakeFair(int[] nums) {
        int even=0,odd=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                even+=nums[i];
            }else{
                odd+=nums[i];
            }
        }
        int leftEven=0,leftOdd=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                even-=nums[i];
            }else{
                odd-=nums[i];
            }
            if(leftEven+odd==leftOdd+even){
                ans++;
            }
            if(i%2==0){
                leftEven+=nums[i];
            }else{
                leftOdd+=nums[i];
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna