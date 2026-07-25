public class Solution extends VersionControl{
    public int firstBadVersion(int n){
        int l=1,r=n;
        while(l<r){
            int m=l+(r-l)/2;
            if(isBadVersion(m))r=m;
            else l=m+1;
        }
        return l;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna