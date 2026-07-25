class SnapshotArray{
    ArrayList<int[]>[] arr;
    int snap;
    public SnapshotArray(int length){
        arr=new ArrayList[length];
        for(int i=0;i<length;i++){
            arr[i]=new ArrayList<>();
            arr[i].add(new int[]{0,0});
        }
        snap=0;
    }
    public void set(int index,int val){
        ArrayList<int[]> list=arr[index];
        if(list.get(list.size()-1)[0]==snap)list.get(list.size()-1)[1]=val;
        else list.add(new int[]{snap,val});
    }
    public int snap(){
        return snap++;
    }
    public int get(int index,int snap_id){
        ArrayList<int[]> list=arr[index];
        int l=0,r=list.size()-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(list.get(m)[0]<=snap_id)l=m+1;
            else r=m-1;
        }
        return list.get(r)[1];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna