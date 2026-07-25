class Solution{
    public char nextGreatestLetter(char[] letters,char target){
        int l=0,r=letters.length-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(letters[m]<=target)l=m+1;
            else r=m-1;
        }
        return letters[l%letters.length];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna