import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] time = new int[MAX];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[N] = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(N);

        while (!dq.isEmpty()) {
            int curr = dq.poll();

            int[] nexts = {curr * 2, curr - 1, curr + 1};
            int[] costs = {0, 1, 1};

            for (int i = 0; i < 3; i++) {
                int next = nexts[i];
                int cost = costs[i];

                if (next >= 0 && next < MAX && time[next] > time[curr] + cost) {
                    time[next] = time[curr] + cost;
                    if (cost == 0) {
                        dq.offerFirst(next);
                    } else {
                        dq.offerLast(next);
                    }
                }
            }
        }

        System.out.println(time[K]);
    }
}
