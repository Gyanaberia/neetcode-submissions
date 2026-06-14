class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Integer>scount = new HashMap<>();
        Map<Character,Integer>tcount = new HashMap<>();
        for(int i=0;i<s.length();i++){
            scount.merge(s.charAt(i),1,Integer::sum);
        }
        for(int i=0;i<t.length();i++){
            tcount.merge(t.charAt(i),1,Integer::sum);
        }
        if(scount.equals(tcount))return true;
        return false;
    }
}
