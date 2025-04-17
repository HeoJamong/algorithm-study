import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        
        for (int i = 0; i < arr.length; i++) {
            if (deque.peek() == null) {
                deque.addLast(arr[i]);
            }
            else if (deque.peekLast() != (arr[i])) {
                deque.addLast(arr[i]);
            }
        }

        int[] answer = new int[deque.size()];
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            answer[i] = deque.removeFirst();
        }
        return answer;
    }
}