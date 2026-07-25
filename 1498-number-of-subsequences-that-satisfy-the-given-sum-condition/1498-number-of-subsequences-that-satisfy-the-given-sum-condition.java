class Solution{
    public int numSubseq(int[] nums,int target){
        Arrays.sort(nums);
        int n=nums.length,mod=1000000007;
        int[] pow=new int[n];
        pow[0]=1;
        for(int i=1;i<n;i++)pow[i]=pow[i-1]*2%mod;
        int l=0,r=n-1,ans=0;
        while(l<=r){
            if(nums[l]+nums[r]<=target){
                ans=(ans+pow[r-l])%mod;
                l++;
            }else r--;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna