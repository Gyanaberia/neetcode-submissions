class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set res = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            res.add(nums[i]);
        }
        if(nums.length!=res.size())return true;
        return false;
    }
}