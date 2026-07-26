class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(1,n,k,new ArrayList<>(),ans);
        return ans;
    }

    public void backtrack(int start,int n,int k,List<Integer> list,List<List<Integer>> ans){
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=start;i<=n;i++){
            list.add(i);
            backtrack(i+1,n,k,list,ans);
            list.remove(list.size()-1);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna