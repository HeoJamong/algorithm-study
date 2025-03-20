import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] store = new int[n][2];
            int[] start = new int[2];
            int[] festival = new int[2];
            boolean[] visited = new boolean[n];

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());

                if (i == 0) {
                    start[0] = Integer.parseInt(st.nextToken());
                    start[1] = Integer.parseInt(st.nextToken());
                } else if (i == n + 1) {
                    festival[0] = Integer.parseInt(st.nextToken());
                    festival[1] = Integer.parseInt(st.nextToken());
                } else {
                    store[i - 1][0] = Integer.parseInt(st.nextToken());
                    store[i - 1][1] = Integer.parseInt(st.nextToken());
                }
            }

            if (bfs(start, store, festival, visited)) {
                sb.append("happy\n");
            } else {
                sb.append("sad\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean bfs(int[] start, int[][] store, int[] festival, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            if (Math.abs(festival[0] - cx) + Math.abs(festival[1] - cy) <= 1000) {
                return true;
            }

            // 편의점 탐색
            for (int i = 0; i < store.length; i++) {
                if (!visited[i]) { // 방문하지 않은 편의점만
                    int sx = store[i][0];
                    int sy = store[i][1];
                    if (Math.abs(sx - cx) + Math.abs(sy - cy) <= 1000) {
                        visited[i] = true;
                        queue.add(new int[]{sx, sy});
                    }
                }
            }
        }
        return false;
    }
}
