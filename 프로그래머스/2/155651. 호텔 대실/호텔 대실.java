import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = toMinutes(book_time[i][0]);
            times[i][1] = toMinutes(book_time[i][1]);
        }

        // 입실 시간 기준 정렬
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        // 최소 힙: 퇴실 시간 + 청소 시간(10분)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] time : times) {
            int checkIn = time[0];
            int checkOut = time[1];

            if (!pq.isEmpty() && pq.peek() <= checkIn) {
                pq.poll(); // 방 비움
            }

            // 현재 예약의 퇴실 시간 + 청소 시간 추가
            pq.add(checkOut + 10);
        }

        return pq.size(); // 현재 큐에 남아있는 방의 수
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
