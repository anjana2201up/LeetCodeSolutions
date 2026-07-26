class Solution {
    public String shortestPalindrome(String s) {
        String rev=new StringBuilder(s).reverse().toString();
        String temp=s+"#"+rev;
        int[] lps=new int[temp.length()];

        for(int i=1;i<temp.length();i++){
            int j=lps[i-1];
            while(j>0&&temp.charAt(i)!=temp.charAt(j)){
                j=lps[j-1];
            }
            if(temp.charAt(i)==temp.charAt(j)){
                j++;
            }
            lps[i]=j;
        }

        int add=s.length()-lps[temp.length()-1];
        return rev.substring(0,add)+s;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna