class Solution {
    public int numberOfSubstrings(String s) {
        int[] count=new int[3];
        int left=0;
        int ans=0;

        for(int right=0;right<s.length();right++){
            count[s.charAt(right)-'a']++;

            while(count[0]>0&&count[1]>0&&count[2]>0){
                ans+=s.length()-right;
                count[s.charAt(left)-'a']--;
                left++;
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna