class Solution {
    public boolean isValid(String s) {
       Stack <Character> brackets = new Stack<>();
       for(char c:s.toCharArray()){
        if(c == '{' || c == '[' || c == '('){
            brackets.push(c);
        }else if (!brackets.empty()) {
            if((c == ']' && brackets.peek() == '[')||(c == ')' && brackets.peek() == '(')||(c == '}' && brackets.peek() == '{')){
                brackets.pop();
            }else{
                return false;
            }

        }else{
            return false;
        }
        }
                if(brackets.empty()){
                return true;}
                else{
                    return false;
                }
    }
}
