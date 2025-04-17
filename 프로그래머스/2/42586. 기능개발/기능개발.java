import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        ArrayDeque<Integer> prog = new ArrayDeque<>();
        ArrayDeque<Integer> speed = new ArrayDeque<>();
        
        for (int i =0; i < progresses.length; i++) {
            prog.addLast(progresses[i]);
            speed.addLast(speeds[i]);
        }
        
        int cnt = 0;
        int time = 1;
        while (!prog.isEmpty()) {
            if (prog.getFirst() + speed.getFirst() * time >= 100) {
                prog.removeFirst();
                speed.removeFirst();
                cnt++;
            } else {
                if (cnt > 0) {
                    arr.add(cnt);
                    cnt = 0;
                }
              time++;  
            }
        }
        if (cnt > 0) {
            arr.add(cnt);
            cnt = 0;
        }
        int[] answer = new int[arr.size()];
        for (int i =0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}