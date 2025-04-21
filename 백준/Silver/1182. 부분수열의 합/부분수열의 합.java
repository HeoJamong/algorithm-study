import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0) {
            answer--;   // S가 0일 때 공집합은 허용ㅇ이 안되므로 하나 빼줌
        }
        System.out.println(answer);
    }

    public static void dfs(int cnt, int sum) {
        if (cnt == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }

        dfs(cnt + 1, sum + arr[cnt]);
        dfs(cnt + 1, sum);
    }
}
