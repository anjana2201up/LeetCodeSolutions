class Solution{
    public int findKthPositive(int[] arr,int k){
        int l=0,r=arr.length;
        while(l<r){
            int m=l+(r-l)/2;
            if(arr[m]-m-1<k)l=m+1;
            else r=m;
        }
        return l+k;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna