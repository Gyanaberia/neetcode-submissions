class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    //find the row where target resides
    int n = matrix.length;
    int m = matrix[0].length;
    int tn = 0;
    if(target<matrix[0][0]|| target>matrix[n-1][m-1])return false;
    while(tn<n){
        if(matrix[tn][m-1]>=target)break;
        tn++;
    }
    int l = 0;
    int center = 0;
    while(l<m){
        center = l+(m-l)/2;
        if(matrix[tn][center]>=target){
            m = center;
        }else{
            l=center+1;
        }
    }
    if(l<matrix[0].length && matrix[tn][l]==target)return true;
    return false;
    //do binary search on that row  
    }
}
