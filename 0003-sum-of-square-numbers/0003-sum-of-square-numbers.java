class Solution {
    public boolean judgeSquareSum(int c) {
        long a=0;
        long b=(long)Math.sqrt(c);
        while(a<=b){
            long sum=a*a+b*b;
            if(sum==c){
                return true;
            }else if(sum<c){
                a++;
            }else{
                b--;
            }
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna