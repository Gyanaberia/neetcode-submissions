class Solution {
    public boolean isValidSudoku(char[][] board) {
        //hashmap of int, hashset for col, row and square
        //col is j/3, row is i/3, square is col+row+1
        //if at anytime, if any hashset returns true for a containsKey, return false
        List<Set<Integer>>cols = new ArrayList<>();
        List<Set<Integer>>rows = new ArrayList<>();
        List<Set<Integer>>square = new ArrayList<>();
        for(int i=0;i<9;i++){
            Set<Integer>temp1 = new HashSet<>();
            Set<Integer>temp2 = new HashSet<>();
            Set<Integer>temp3 = new HashSet<>();
            cols.add(temp1);
            rows.add(temp2);
            square.add(temp3);
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }else{
                    int val = board[i][j]-'1';
                    int curSquare = (i/3)*3 + j/3;
                    if(cols.get(j).contains(val)|| rows.get(i).contains(val)||
                    square.get(curSquare).contains(val)){
                        return false;
                    }else{
                        cols.get(j).add(val);
                        rows.get(i).add(val);
                        square.get(curSquare).add(val);
                    }
                }
            }
        }
        return true;

    }
}
