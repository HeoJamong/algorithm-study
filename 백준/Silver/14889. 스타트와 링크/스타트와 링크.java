import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] select;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        select = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);

        System.out.println(min);
    }

    public static void dfs(int cnt, int start) {
        // 종료 조건
        if (cnt == N / 2) {
            // 계산 들어가야함
            min = Math.min(min, calcuration());
            return;
        }

        for (int i = start; i < N; i++) {
            if (!select[i]) {
                select[i] = true;
                dfs(cnt + 1, i + 1);
                select[i] = false;
            }
        }
    }

    public static int calcuration() {
        // 반복문 돌면서 값을 계산해야함
        int s_team = 0;
        int l_team = 0;

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (select[i] && select[k]) { // 둘 다 true면 같은 팀
                    s_team += arr[i][k];
                } else if (!select[i] && !select[k]) { // 둘 다 false면 상대팀
                    l_team += arr[i][k];
                }
            }
        }
        return (Math.abs(s_team - l_team));
    }
}
