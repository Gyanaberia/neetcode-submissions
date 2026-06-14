class TimeMap {
    private HashMap<String,List<String>>map;
    private HashMap<String,List<Integer>>mapIndex;
    public TimeMap() {
        this.map = new HashMap<>();
        this.mapIndex = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            this.map.get(key).add(value);
            this.mapIndex.get(key).add(timestamp);
        }else{
            this.map.put(key,new ArrayList<>(List.of(value)));
            this.mapIndex.put(key,new ArrayList<>(List.of(timestamp)));
        }
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            List<String> mapValue = this.map.get(key);
            List<Integer> indices = this.mapIndex.get(key);
            int l = 0;
            int r = indices.size()-1;
            //timestamp is smaller than earliest timestamp
            if(indices.get(0)>timestamp)return "";
            if(indices.get(r)<=timestamp)return mapValue.get(r);
            //binary search for the index where its less than equal to timestamp
            int m = 0;
            while(l<r){
                m = l+(r-l)/2;
                if(indices.get(m)==timestamp){
                    return mapValue.get(m);
                }
                else if(indices.get(m)>timestamp){
                    r = m;
                }else{
                    l=m+1;
                }
            }
            return mapValue.get(r-1);

        }else{
            return "";
        }     
    }
}
