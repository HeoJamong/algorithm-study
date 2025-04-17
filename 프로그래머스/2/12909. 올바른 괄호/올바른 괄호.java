import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        ArrayDeque<Character> deque = new ArrayDeque<>();
            
        for (int i = 0; i < s.length(); i++) {
            char parentheses = s.charAt(i);
            if (parentheses == '(') {
                deque.addLast('(');
            } else if (parentheses == ')') {
                if (deque.isEmpty())
                    return false;
                deque.removeLast();
            }
        }
        
        if (!deque.isEmpty()) {
            return false;
        }
        return answer;
    }
}