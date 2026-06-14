class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Integer>nums = new Stack<>();
      for(String i:tokens){
        switch(i){
            case "+"->{
                nums.push(nums.pop()+nums.pop());
            }
            case "-"->{
                int a = nums.pop();
                int b = nums.pop();
                nums.push(b-a);
            }
            case "*"->{
                nums.push(nums.pop()*nums.pop());
            }
            case "/"->{
                int a = nums.pop();
                int b = nums.pop();
                nums.push(b/a);
            }
            default->nums.push(Integer.parseInt(i));
        }
      }
      return nums.pop();  
    }
}
