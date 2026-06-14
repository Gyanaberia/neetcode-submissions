class MinStack {
    private List<String> values;
    private int size = 0;
    public MinStack() {
       this.values = new ArrayList<>(); 
    }
    
    public void push(int val) {
        if(size==0){
        this.values.add( String.valueOf(val)+ "+"+String.valueOf(val));}
        else{
            int minVal = Integer.parseInt(this.values.get(size-1).split("\\+")[1]);
            this.values.add( String.valueOf(val)+ "+"+String.valueOf(Math.min(minVal,val)));
        }
        this.size++;
    }
    
    public void pop() {
        this.values.remove(--this.size);
        
    }
    
    public int top() {
        return Integer.parseInt(this.values.get(this.size-1).split("\\+")[0]);
    }
    
    public int getMin() {
        return Integer.parseInt(this.values.get(this.size-1).split("\\+")[1]);
    }
}
