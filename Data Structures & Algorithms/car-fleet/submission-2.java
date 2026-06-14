class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[]combine = new int[position.length];
        for(int i=0;i<position.length;i++){
            combine[i] = position[i]*1000+speed[i];
        }
        Arrays.sort(combine);
        //Now all vehicles are sorted on position, speed
        //eg:-0,0: 0,2:1,4:1,10...
        //for i, calculate, time required,
        //if more than stack top, add it to stack
        //if less,
        double maxTime= 0.0;
        int ans = 0;
        for(int i=position.length-1;i>=0;i--){
            int p = combine[i]/1000;
            int s = combine[i]%1000;
            if(s==0){
                return ans;
            }else{
                double currentTime = (double)(target-p)/s;
                //System.out.println("position:"+p+" time:"+currentTime);
                if(currentTime>maxTime){
                    maxTime = currentTime;
                    ans++;
                }
            }
        }
        return ans;
    }
}
