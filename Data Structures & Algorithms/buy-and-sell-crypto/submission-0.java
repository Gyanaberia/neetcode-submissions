class Solution {
    public int maxProfit(int[] prices) {
     int maxprice = prices[prices.length - 1];
     int profit = 0;
     for(int i=prices.length-2;i>=0;i--){
        int diff = maxprice - prices[i];
        if(diff<0){
            maxprice = prices[i];
        }else if(diff>profit){
            profit = diff;
        }
     }   
     return profit;
    }
}
