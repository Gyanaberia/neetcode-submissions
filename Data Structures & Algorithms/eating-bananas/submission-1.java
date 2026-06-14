class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    //max k is max(piles)
    //range is 1,piles
    //binary across the range, and run it for the array
    int maxVal = 0;
    for(int i:piles){
        if(i>maxVal)maxVal = i;
    }
    int k = 1;
    int r = maxVal;
    int ans = 0;
    while(k<r){
        ans = k+(r-k)/2;
        int temp = 0;
        for(int i=0;i<piles.length;i++){
            temp+= Math.ceil(piles[i]/(double)ans);
        }
        System.out.println("k:"+k+" r:"+r+" ans:"+ans+ " temp:"+ temp);

        if(temp<=h){//ans is too big
            r = ans;
        }else{
            k = ans+1;
        }
    } 
    return r;       
    }
}
