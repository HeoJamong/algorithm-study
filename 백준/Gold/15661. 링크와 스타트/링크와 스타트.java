import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[][] arr;
    static boolean[] select;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        select = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int idx, int start) {
        if (0 < idx && idx < N) {
            min = Math.min(min, calcuration());
        }
        if (min == 0) {
            return;
        }

        for (int i = start; i < N; i++) {
            if (!select[i]) {
                select[i] = true;
                dfs(idx + 1, i + 1);
                select[i] = false;
            }
        }
    }

    public static int calcuration() {
        int s_team = 0;
        int l_team = 0;

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (select[i] && select[k]) {
                    s_team += arr[i][k];
                }
                if (!select[i] && !select[k]) {
                    l_team += arr[i][k];
                }
            }
        }

        return Math.abs(s_team - l_team);
    }

}
