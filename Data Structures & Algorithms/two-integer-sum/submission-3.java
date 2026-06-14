class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] temp = nums.clone();
        Arrays.sort(nums);
        int st = 0;
        int lt = nums.length - 1;
        while(st<lt){
            int val = nums[st]+nums[lt];
            System.out.println(val);
            if(val==target){ 
                break;}
            else if(val>target){lt--;}
            else st++; 
        }
        int res[] = {st,lt};
        
        for(int i=0;i<temp.length;i++){
            if(temp[i]==nums[st]){
                res[0] = i;
                break;
            }
        }
        for(int i=temp.length-1;i>-1;i--){
                        if(temp[i]==nums[lt]){
                res[1] = i;
                break;
            }
        }
        Arrays.sort(res);
        return res;
    }

}
