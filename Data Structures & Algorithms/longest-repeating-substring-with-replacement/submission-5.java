class Solution {
    public int characterReplacement(String s, int k) {
        //window-maxFreq = k;
        //loop through string
        //when it >k
        //decrease l, till k
        int[] freq = new int[26];
        int l = 0,r = 0,max = 1,i = 0,ans = 0;
        for(r = 0;r<s.length();r++){
            i = s.charAt(r)-'A';
            freq[i]++;
            if(freq[i]>max)max = freq[i];
            while(r-l+1-max>k){
                i = s.charAt(l)-'A';
                freq[i]--;
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}
