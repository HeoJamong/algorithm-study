import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {return a - b;});
        
        for (int n : scoville) {
            pq.add(n);
        }
        
        int cnt = 0;
        while (true) {
            if (pq.peek() >= K) return cnt;
            if (pq.size() == 1) break;
            
            int fir = pq.poll();
            int sec = pq.poll();
            
            // System.out.println("fir:" + fir);
            // System.out.println("sec:" + sec);
            // System.out.println("new:" + (fir + (sec * 2)));
            pq.add(fir + (sec * 2));
            cnt++;
        }
        
        
        return -1;
    }
}