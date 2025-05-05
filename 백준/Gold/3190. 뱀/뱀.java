import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, K, L;
    static int[][] map;
    static boolean[][] visited;
    static ArrayDeque<int[]> snake = new ArrayDeque<>();
    static Map<Integer, Character> cmd = new HashMap<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1; // 사과
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            cmd.put(t, d);
        }

        System.out.println(simulate());
    }

    public static int simulate() {
        int time = 0;
        int dir = 0; // 오른쪽으로 시작
        int x = 0, y = 0;

        snake.offer(new int[]{x, y});
        visited[x][y] = true;

        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 벽 또는 자기 몸과 충돌하면 종료
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) break;

            snake.offerFirst(new int[]{nx, ny});
            visited[nx][ny] = true;

            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
            } else {
                int[] tail = snake.pollLast(); // 꼬리 줄이기
                visited[tail[0]][tail[1]] = false;
            }

            // 방향 전환
            if (cmd.containsKey(time)) {
                char turn = cmd.get(time);
                if (turn == 'D') dir = (dir + 1) % 4;
                else dir = (dir + 3) % 4;
            }

            x = nx;
            y = ny;
        }

        return time;
    }
}
