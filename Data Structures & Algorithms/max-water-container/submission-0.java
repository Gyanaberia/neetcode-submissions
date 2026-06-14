class Solution {
    public int maxArea(int[] heights) {
        int st = 0;
        int lt = heights.length-1;
        int amt = Math.min(heights[st],heights[lt])*(lt-st);
        if(lt == 1){
            return amt;
        }
        while(st<lt){
            if(heights[st]<=heights[lt]){
                int temp = st+1;
                while(heights[temp]<=heights[st] && temp<lt){
                    temp++;
                }
                st=temp;
                int val = Math.min(heights[st],heights[lt])*(lt-st);
                amt = Math.max(amt,val);
            }else{
                int temp = lt-1;
                while(heights[temp]<=heights[lt] && st<temp){
                    temp--;
                }
                lt = temp;
                int val = Math.min(heights[st],heights[lt])*(lt-st);
                amt = Math.max(amt,val);
            }
        }
        return amt;    
    }
}
