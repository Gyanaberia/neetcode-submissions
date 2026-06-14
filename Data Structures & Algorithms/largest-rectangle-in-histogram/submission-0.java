class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len==1)return heights[0];
        Stack<Integer>temp = new Stack<>();
        //contains the left index where height[l]<height[i]
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right,len);//all values is len-1
        temp.push(0);
        for(int i=1;i<len;i++){
            while(!temp.empty() && heights[temp.peek()]>=heights[i])temp.pop();
            if(!temp.empty()){left[i] = temp.peek()+1;}
            temp.push(i);
        }
        temp.clear();
        temp.push(len-1);
        int ans = heights[len-1]*(len-left[len-1]);
        for(int i=len-2;i>=0;i--){
            while(!temp.empty() && heights[temp.peek()]>=heights[i])temp.pop();
            if(!temp.empty()) right[i] = temp.peek();
            ans = Math.max(heights[i]*(right[i]-left[i]),ans);
            System.out.println("l:"+left[i]+" r:"+right[i]);
            temp.push(i);
        }
        return ans;
        
    }
}
