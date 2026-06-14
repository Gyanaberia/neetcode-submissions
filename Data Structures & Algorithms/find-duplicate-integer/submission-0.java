class Solution {
    public int findDuplicate(int[] nums) {
        int index=0,next = 0;
        while(nums[index]!=-1){
            next = nums[index];
            nums[index] = -1;
            index = next;
        }
        return index;
    }
}
