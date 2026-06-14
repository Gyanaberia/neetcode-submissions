class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>,List<String>>anagrams = new HashMap();
        for(String word:strs){
            //convert word to int array of frequency
            List<Integer> freq = new ArrayList<>(26);
            for(int i=0;i<26;i++){
                freq.add(0);
            }
            for(char letter:word.toCharArray()){
                int index = letter-'a';
                int val = freq.get(index);
                freq.set(index,++val);
            }
            //int array is the key. 
            //if exist, add to array
            //else create new array
            anagrams.computeIfAbsent(freq,k->new ArrayList()).add(word);
        }
        List<List<String>> result =new ArrayList<>(anagrams.values());
        return result;
    }
}
