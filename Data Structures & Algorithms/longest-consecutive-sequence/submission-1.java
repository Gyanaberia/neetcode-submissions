class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        //two hashmap
        //a- key is smallest, and val is largest
        //b-key is largest, and val is smallest
        //for i, check i-1 present in b, i+1 present in a
        //if both present add [val(b),val(a)] to a 
        //and [val(a),val(b)] to b.
        //if only a present add [i,val(a)] to a, [val(a), i] to b
        //if only b present add [i, val(b)] to b, [val(b), i ] to a
        HashMap<Integer, Integer> smallLarge = new HashMap<Integer,Integer>();
        HashMap<Integer, Integer> largeSmall = new HashMap<Integer,Integer>();
        HashSet<Integer> numSet = new HashSet<Integer>();
        for(int i:nums){
            numSet.add(i);
        }
        for(Integer i:numSet){
            if(smallLarge.containsKey(i+1)){
                int largeVal = smallLarge.get(i+1);
                if(largeSmall.containsKey(i-1)){
                    int smallVal = largeSmall.get(i-1);
                    smallLarge.put(smallVal,largeVal);
                    largeSmall.put(largeVal,smallVal);
                    smallLarge.remove(i+1);
                    largeSmall.remove(i-1);
                }else{
                    smallLarge.put(i, largeVal);
                    largeSmall.put(largeVal,i);
                    smallLarge.remove(i+1);
                }
            }else{
                if(largeSmall.containsKey(i-1)){
                    int smallVal = largeSmall.get(i-1);
                    smallLarge.put(smallVal,i);
                    largeSmall.put(i, smallVal);
                    largeSmall.remove(i-1);
                }else{
                    smallLarge.put(i,i);
                    largeSmall.put(i,i);
                }
            }
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry: smallLarge.entrySet()){
            int temp = entry.getValue()-entry.getKey();
            if(temp>ans){
                ans = temp;
            }
        }
        return ans+1;
        
    }
}
