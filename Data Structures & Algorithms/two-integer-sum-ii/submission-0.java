class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int st = 0;
        int lt = numbers.length-1;
        int sum = 0;
        while(st<lt){
            sum = numbers[st]+numbers[lt];
            if(sum==target){
                break;
            }else if(sum>target){
                lt--;
            } else{
                st++;
            }
        }
        return new int[]{st+1,lt+1};
    }
}
