class Solution {
    public String minWindow(String s, String t) {
    int minLen = s.length();
    if(s.length()<t.length()){
        return "";
    }
    int l=0;
    //map to keep freq count
    HashMap<Character,Integer>tchar = new HashMap<>();
    HashMap<Character,Integer>schar = new HashMap<>();
    String ans = "";
    //freq count of t and corresponding window size in s
    for(int i=0;i<t.length();i++){
        char tt = t.charAt(i);
        char ss = s.charAt(i);
        tchar.put(tt, tchar.getOrDefault(tt,0)+1);
        schar.put(ss, schar.getOrDefault(ss,0)+1);
    }
    //total freq counts that should match
    int target = tchar.size();
    int match = 0;
    for(Map.Entry<Character,Integer> e:tchar.entrySet()){
        if(schar.containsKey(e.getKey())&& schar.get(e.getKey())>=e.getValue()){
            match++;
        }
    }
    if(match==target)return s.substring(0,t.length());
    
    for(int i = t.length();i<s.length();i++){
        char ss = s.charAt(i);
        schar.put(ss, schar.getOrDefault(ss,0)+1);
        if(tchar.containsKey(ss) && schar.get(ss)==tchar.get(ss)){
            match++;
        }
        if(match==target){
            //find l
            while(match==target){
                char temp = s.charAt(l);
                if(schar.get(temp)==tchar.get(temp))break;
                schar.put(temp,schar.get(temp)-1);
                l++;
            }
            //update answer
            if(i-l+1<=minLen){
            minLen = i-l+1;
            ans = s.substring(l,i+1);
            }

            //update l
            schar.put(s.charAt(l),schar.get(s.charAt(l))-1);
            l++;

            while(l<s.length()){
                char temp = s.charAt(l);
                if(schar.get(temp)==tchar.get(temp))break;
                schar.put(temp,schar.get(temp)-1);
                l++;
            }
            match--;
        }

    }

    return ans;

    }
}
