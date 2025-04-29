import java.io.*;
import java.util.*;

public class Main {

    static int n, m, h;
    static int[][][] arr;
    static boolean[][][] visit;
    static Deque<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        arr = new int[h][m][n];
        visit = new boolean[h][m][n];
        
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < m; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < n; x++) {
                    arr[z][y][x] = Integer.parseInt(st.nextToken());
                    if (arr[z][y][x] == 1) {
                        q.add(new int[]{z, y, x});
                    }
                }
            }
        }

        if (!q.isEmpty()) {
            int[] start = q.poll();
            bfs(start[0], start[1], start[2]);
        }

        boolean flag = false;
        int result = 0;
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    if (arr[z][y][x] == 0) {
                        flag = true;
                    }
                    result = Math.max(result, arr[z][y][x]);
                }
            }
        }

        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(result - 1);
        }
    }

    public static void bfs(int z, int y, int x) {
        int[] dx = {0, 0, -1, 1, 0, 0};
        int[] dy = {1, -1, 0, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        visit[z][y][x] = true;
        q.addFirst(new int[]{z, y, x});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cz = current[0], cy = current[1], cx = current[2];

            for (int i = 0; i < 6; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nz = cz + dz[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && 0 <= nz && nz < h
                    && !visit[nz][ny][nx] && arr[nz][ny][nx] == 0) {
                    visit[nz][ny][nx] = true;
                    arr[nz][ny][nx] = arr[cz][cy][cx] + 1;
                    q.add(new int[]{nz, ny, nx});
                }
            }
        }
    }
}
