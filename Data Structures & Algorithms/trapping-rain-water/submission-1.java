class Solution {
    public int trap(int[] height) {
       if(height.length<3){return 0;}
       int st = 0;
       int lt = height.length-1;
       int volume = Math.min(height[st],height[lt])*(lt-1);
       int sh = height[st];
       int lh = height[lt];
       while(st<lt-1){
        //adjust the pointers to get to next best height
        while(st<lt-1 && height[st]<=height[lt]){
            if(height[st+1]>=sh){
                if(volume!=0)volume-=sh;
                int prevheight = sh;
                sh = height[++st];
                volume+=Math.min(sh-prevheight,lh-prevheight)*(lt-st-1);
                //System.out.println(st + " , " + lt + ". volume is: " + volume);
                break;

            }else{
                volume-=height[++st];
                //System.out.println(st + " , " + lt + ". volume is: " + volume);

            }
        }
        while(st<lt-1 && height[st]>height[lt]){
            if(height[lt-1]>=lh){
                if(volume!=0){volume-=lh;}
                int prevheight = lh;
                lh = height[--lt];
                volume+=Math.min(sh-prevheight,lh-prevheight)*(lt-st-1);
                //System.out.println(st + " , " + lt + ". volume is: " + volume);
                break;
            }else{
                volume-=height[--lt];
                //System.out.println(st + " , " + lt + ". volume is: " + volume);

            }
        }
       }
    return volume; 
    }
}
