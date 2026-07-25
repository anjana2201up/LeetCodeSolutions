class TimeMap{
    HashMap<String,ArrayList<Pair>> map;
    public TimeMap(){
        map=new HashMap<>();
    }
    public void set(String key,String value,int timestamp){
        map.computeIfAbsent(key,k->new ArrayList<>()).add(new Pair(timestamp,value));
    }
    public String get(String key,int timestamp){
        if(!map.containsKey(key))return "";
        ArrayList<Pair> list=map.get(key);
        int l=0,r=list.size()-1;
        String ans="";
        while(l<=r){
            int m=l+(r-l)/2;
            if(list.get(m).time<=timestamp){
                ans=list.get(m).val;
                l=m+1;
            }else r=m-1;
        }
        return ans;
    }
    class Pair{
        int time;
        String val;
        Pair(int time,String val){
            this.time=time;
            this.val=val;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna