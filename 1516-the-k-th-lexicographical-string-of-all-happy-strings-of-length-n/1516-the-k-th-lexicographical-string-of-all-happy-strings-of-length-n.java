class Solution {
    public String getHappyString(int n, int k) {
        List<String> list=new ArrayList<>();
        generate("",n,list);

        if(k>list.size()){
            return "";
        }

        return list.get(k-1);
    }

    public void generate(String s,int n,List<String> list){
        if(s.length()==n){
            list.add(s);
            return;
        }

        for(char ch='a';ch<='c';ch++){
            if(s.length()>0&&s.charAt(s.length()-1)==ch){
                continue;
            }
            generate(s+ch,n,list);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna