class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum=0;
        for(int num:nums){
            sum+=num;
        }
        int target=(int)(sum%p);
        if(target==0){
            return 0;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        long prefix=0;
        int ans=nums.length;
        for(int i=0;i<nums.length;i++){
            prefix=(prefix+nums[i])%p;
            int need=(int)((prefix-target+p)%p);
            if(map.containsKey(need)){
                ans=Math.min(ans,i-map.get(need));
            }
            map.put((int)prefix,i);
        }
        return ans==nums.length?-1:ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna