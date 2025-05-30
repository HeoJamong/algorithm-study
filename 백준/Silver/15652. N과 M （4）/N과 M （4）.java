import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        dfs(0, 1);
        System.out.println(sb);
    }

    public static void dfs(int cnt, int start) {
        if (cnt == M) {
            for (int i = 0; i < cnt; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i <= N; i++) {
            arr[cnt] = i;
            dfs(cnt + 1, i);
        }
    }
}