class Solution{
    public String longestCommonPrefix(String[] strs){
        if(strs.length==0)return "";
        String ans=strs[0];
        for(int i=1;i<strs.length;i++){
            while(!strs[i].startsWith(ans)){
                ans=ans.substring(0,ans.length()-1);
                if(ans.length()==0)return "";
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna