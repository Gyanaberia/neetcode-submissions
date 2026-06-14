class Solution {

    public String encode(List<String> strs) {
        String space = "gyana";
        String res = "";
        for(String s:strs){
            res+=s;
            res+=space;
        }
        return res;
    }

    public List<String> decode(String str) {
        
        List<String>ans = new ArrayList<>();
        if(str==""){
            return ans;
        }
        String space = "gyana";
        if(str.equals(space)){
            ans.add("");
            return ans;
        }
        ans = Arrays.asList(str.split(space));
        return ans;
    }
}
