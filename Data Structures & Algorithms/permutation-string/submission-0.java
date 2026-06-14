class Solution {
    public boolean checkInclusion(String s1, String s2) {
       HashMap<Character,Integer>charCount = new HashMap<>();
       for(char i:s1.toCharArray()){
        charCount.put(i, charCount.getOrDefault(i,0)+1);
       }
       int curLen = 0;
       int l = 0;
       int r = 0;
        for(int i=0;i<s2.length();i++){
            char c = s2.charAt(i);
            if(charCount.containsKey(c)){
                int val = charCount.get(c);
                if(val == 0){                   
                    while(s2.charAt(l)!=c){
                        char lc = s2.charAt(l);
                        charCount.put(lc,charCount.get(lc)+1);
                        l++;
                    }
                    l++;
                    //while loop of l to bring val to 0;
                }else{
                    if(i-l+1==s1.length())return true;
                    charCount.put(c,val-1);
                }
            }else{
                while(l<i){
                    char lc = s2.charAt(l);
                    charCount.put(lc,charCount.get(lc)+1);
                    l++;
                }
                l=i+1;
            }
        }
        return false;
    }
}
