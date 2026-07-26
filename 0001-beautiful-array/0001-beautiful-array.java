class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        while(list.size()<n){
            List<Integer> temp=new ArrayList<>();
            for(int x:list){
                if(2*x-1<=n){
                    temp.add(2*x-1);
                }
            }
            for(int x:list){
                if(2*x<=n){
                    temp.add(2*x);
                }
            }
            list=temp;
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna