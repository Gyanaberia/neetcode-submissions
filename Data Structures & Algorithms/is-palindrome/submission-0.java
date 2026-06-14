class Solution {
    public boolean isPalindrome(String s) {
        int st = 0;
        int lt = s.length()-1;
        String sl = s.toLowerCase();
        while(st<=lt){
            char stc = sl.charAt(st);
            char ltc = sl.charAt(lt);
            System.out.println(stc);
            if(!Character.isLetterOrDigit(stc)){
                st++;
                continue;
            }else if(!Character.isLetterOrDigit(ltc)){
                lt--;
                continue;
            }else if(stc==ltc){
                st++;
                lt--;
            }else{
                return false;
            }
        }
        return true;
    }
}
