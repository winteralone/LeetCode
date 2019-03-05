package p771;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(char s : S.toCharArray()) {
            if( J.indexOf(s) != -1 ){
                count++;
            }
        }
        return count;
    }
}
