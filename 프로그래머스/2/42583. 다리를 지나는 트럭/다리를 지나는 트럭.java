import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        int sumWeight = 0;
        int index = 0;

        // 브릿지에 초기값
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (!bridge.isEmpty()) {
            // 다리를 지나간 트럭 빼기
            sumWeight -= bridge.poll();
            answer++;

            // 트럭이 아직 남아 있다면
            if (index < truck_weights.length) {
                if (sumWeight + truck_weights[index] <= weight) {
                    int truck = truck_weights[index++];
                    sumWeight += truck;
                    bridge.offer(truck);
                } else {
                    bridge.offer(0);
                }
            }
        }
        return answer;
    }
}