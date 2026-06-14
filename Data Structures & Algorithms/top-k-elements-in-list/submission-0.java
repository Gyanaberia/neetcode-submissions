class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Set<Integer>> rank = new HashMap<>();
        
        Set<Integer>startSet = new HashSet<>();
        for(int num:nums){
            startSet.add(num);
        }
        rank.put(0,startSet);
        
        HashMap<Integer,Integer> count = new HashMap<>();
        
        for(int num:nums){
            int newCount = count.merge(num,1,Integer::sum);//increase the count of num by 1
            //remove num from newCount-1 group
            rank.get(newCount-1).remove(num);
            //if newCount doesn't exist, create its new set and add num
            rank.computeIfAbsent(newCount,temp->new HashSet<>()).add(num);
        } 
        List<Integer>keys = new ArrayList<>(rank.keySet());
        keys.sort(null);
        int req = k;
        int currIndex = keys.size()-1;
        HashSet<Integer> res = new HashSet<>();
        while(req>0){
            res.addAll(rank.get(keys.get(currIndex)));
            req-=rank.get(keys.get(currIndex)).size();
            currIndex--;
        }

        int[] ans = new int[res.size()];
        int index = 0;
        for (int val:res){
            ans[index++] = val;
        }
        return ans;
    }
}
