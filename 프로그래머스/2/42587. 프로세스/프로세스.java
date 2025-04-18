import java.util.*;

class Solution {
    // 우선순위 큐를 사용하면 될 거 같은데, 값이 동일하면 어떻게 할까
    // HashMap으로 (우선순위, 인덱스) 이걸 pq에 넣을까 -> 메모리 너무 쓰는 거 같은데
    // 우선순위가 높은 순으로 정렬을 해야하는건 맞음 -> pq
    // 젤 큰 값을 찾고
    // for 문 돌면서 앞에서부터 빼면 뒤에꺼 나중에 빠져서 괜찮을듯?
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : priorities) {
            pq.add(i);
        }
        
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.remove();
                    answer++;
                    if (i == location) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}