class Solution {
    public int search(int[] nums, int target) {
    
      int l = 0;
      int r = nums.length;
      if(r==1){
        return nums[0]==target? 0:-1;
      }
      int center = (r-l)/2;
      while(r-l>1){
        if(nums[center] == target ){
            return center;
        }else if(nums[center]>target){
            r = center;
            center =l + (center-l)/2;
        }else{
            l = center;
            center += (r-center)/2;
        }
      }
      if(nums[center]==target)return center;
      return -1;
    }
}
