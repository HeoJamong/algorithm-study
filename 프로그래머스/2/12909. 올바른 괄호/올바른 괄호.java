class Solution {
    boolean solution(String s) {
        int stack = 0;
        
        for (int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(' ) {
                stack++;
            }
            else if (c == ')') {
                if (stack == 0) {
                    return false;
                }
                else {
                    stack--;
                }
            }
        }
        
        if (stack > 0) {
            return false;
        }
        
        return true;
    }
}