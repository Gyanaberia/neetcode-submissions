class Solution {
    public int lengthOfLongestSubstring(String s) {
       //hashmap of char and their indices
       //start indice of substring
       //if a char exist in hashmap, and index is more than start index
       //update start index to found index+1;
       //if index<start index, continue
       //no index, add to hashmap

        int starti = 0;
        int maxLen = 0;
       HashMap<Character,Integer>subChar = new HashMap<>();
       for(int i=0;i<s.length();i++){
        char c = s.charAt(i);
        if(subChar.containsKey(c)){
            int charIndex = subChar.get(c);
            if(charIndex>=starti){
                maxLen = Math.max(maxLen, i-starti);
                starti = charIndex+1;
                
            }
        }
        subChar.put(c,i);
       }
        maxLen = Math.max(maxLen,s.length()-starti);
       return maxLen;
    }
}
