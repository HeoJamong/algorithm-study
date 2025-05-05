import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] fDist, jDist;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static ArrayDeque<int[]> fq;
    static ArrayDeque<int[]> jq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        fDist = new int[R][C];
        jDist = new int[R][C];

        fq = new ArrayDeque<int[]>();
        jq = new ArrayDeque<int[]>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int k = 0; k < C; k++) {
                map[i][k] = str.charAt(k);
                if (map[i][k] == 'F') {
                    fq.offer(new int[]{i, k});
                    fDist[i][k] = 1;
                }

                if (map[i][k] == 'J') {
                    jq.offer(new int[]{i, k});
                    jDist[i][k] = 1;
                }
            }
        }
        fireBfs();
        if (!jBfs()) {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static void fireBfs() {
        while (!fq.isEmpty()) {
            int[] tmp = fq.remove();
            int y = tmp[0];
            int x = tmp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (0 > ny || ny >= R || 0 > nx || nx >= C) continue;
                if (map[ny][nx] == '#' || fDist[ny][nx] > 0) continue;

                fDist[ny][nx] = fDist[y][x] + 1;
                fq.offer(new int[]{ny, nx});
            }
        }
    }

    public static boolean jBfs() {
        while (!jq.isEmpty()) {
            int[] tmp = jq.remove();
            int y = tmp[0];
            int x = tmp[1];

            if (x == 0 || y == 0 || x == C - 1 || y == R - 1) {
                System.out.println(jDist[y][x]);
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (0 > ny || ny >= R || 0 > nx || nx >= C) continue;
                if (map[ny][nx] == '#' || jDist[ny][nx] > 0) continue;

                if (fDist[ny][nx] != 0 && jDist[y][x] + 1 >= fDist[ny][nx]) continue;

                jDist[ny][nx] = jDist[y][x] + 1;
                jq.offer(new int[]{ny, nx});
            }
        }
        return false;
    }
}
