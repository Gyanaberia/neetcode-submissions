class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length==1){
            return new int[]{0};
        }
        Stack<Integer> indices = new Stack<>();
        int[] values = new int[temperatures.length];
        indices.push(0);
        for(int i=1;i<temperatures.length;i++){
            while(indices.size()>0 && temperatures[indices.peek()]<temperatures[i]){
                values[indices.peek()] = i-indices.pop();
            }
            indices.push(i);
        } 
        return values;    
    }
}
