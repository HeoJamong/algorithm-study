import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 100000;
    static int[] time = new int[MAX + 1];
    static int[] prev = new int[MAX + 1];

    public static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        time[start] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == end) {
                System.out.println(time[cur] - 1);

                Stack<Integer> stack = new Stack<>();
                while (cur != start) {
                    stack.push(cur);
                    cur = prev[cur];
                }
                stack.push(start);  // 시작점 추가

                while (!stack.isEmpty()) {
                    System.out.print(stack.pop() + " ");
                }
                return;
            }

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (0 <= next && next <= MAX && time[next] == 0) {
                    queue.offer(next);
                    time[next] = time[cur] + 1;
                    prev[next] = cur;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);
    }
}
