class Solution {
    public int search(int[] nums, int target) {
    int l=0,r = nums.length-1;
    int m = 0;
    while(l<r){
        m = l+(r-l)/2;
        if(nums[m] ==target){
            return m;
        }else if(target==nums[l]){
            return l;
        }else if(target==nums[r]){
            return r;
        }
        else if
        (target<nums[m]){
            if(nums[r]<target || nums[m]<nums[r])r=m;
            else l = m+1;
        }else{
            if(nums[r]<target && nums[m]<nums[r])r=m;
            else l = m+1;
        }
    }
    System.out.println(r);
    return (l<nums.length && nums[r]==target)? r: -1;      
    }
}
