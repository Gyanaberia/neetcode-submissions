class Solution {
    public int findMin(int[] nums) {
    int l=0,r = nums.length-1;
    int m = 0;
    while(l<r){
        m = l+(r-l)/2;
        if(nums[m]<nums[r]){//means l-m contains the smaller number
            r = m;
        }else{
            l=m+1;
        }
    }
    return nums[r];
    }
}
