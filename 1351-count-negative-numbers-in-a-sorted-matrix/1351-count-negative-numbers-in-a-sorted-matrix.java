class Solution{
    public int countNegatives(int[][] grid){
        int m=grid.length,n=grid[0].length,r=m-1,c=0,ans=0;
        while(r>=0&&c<n){
            if(grid[r][c]<0){
                ans+=n-c;
                r--;
            }else c++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna