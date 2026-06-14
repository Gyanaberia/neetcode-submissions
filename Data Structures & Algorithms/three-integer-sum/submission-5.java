class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      Set<List<Integer>> ans = new HashSet<>();
      Arrays.sort(nums);
      int last = nums.length-1;
      for(int i=0;i<last-1;i++){
        int st = i+1;
        int lt = last;
        while(st<lt){
            int sum = nums[st]+nums[lt];
            if(-nums[i]==sum){
                List<Integer>temp = new ArrayList<>(Arrays.asList(nums[i],nums[st],nums[lt]));
                ans.add(temp);
                st++;
                lt--;
            }else if(-nums[i]>sum){
                st++;
            }else{
                lt--;
            }
        }
      }
    return new ArrayList<>(ans);

    }
}
