class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] frontProduct =new  int[nums.length];
       frontProduct[0] = 1;
       int product = 1;
       for(int i=1;i<nums.length;i++) {
        product*=nums[i-1];
        frontProduct[i] = product;
       }
       int[]backProduct = new int[nums.length];
       int last = nums.length-1;
       backProduct[last] = 1;
       product = 1;
       for(int i=last-1;i>=0;i--){
        product*=nums[i+1];
        backProduct[i] = product;
       }
       for(int i=0;i<nums.length;i++){
        frontProduct[i]*=backProduct[i];
       }
       return frontProduct;
    }
}  
