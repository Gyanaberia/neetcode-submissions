class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //freq count map, max map;
        //every step
        //freq[l]--; if freq of max of i-1's max is >0, then 
        //if max>r, max[r] = max;
        //else max[r] = r;
        HashMap<Integer,Integer>freq = new HashMap<>();
        TreeSet<Integer>maxList = new TreeSet<>();
        int[] max = new int[nums.length-k+1];
        maxList.add(nums[0]);
        freq.put(nums[0],1);
        max[0] = nums[0];

        for(int i=1;i<k;i++){
            if(nums[i]>max[0])max[0] = nums[i];
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            maxList.add(nums[i]);
            }
        
        for(int i=k;i<nums.length;i++){
            //put current element in tree and freq;
            //remove last element from freq;
            //if last element count becomes 0 in freq, remove from tree;
            //max[i-k] = tree.ceiling;
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            maxList.add(nums[i]);
            if(freq.put(nums[i-k],freq.get(nums[i-k])-1) ==1){
                maxList.remove(nums[i-k]);
            }
            max[i-k+1] = maxList.last();
        }

        return max;
    }
}
