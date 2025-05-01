import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] weights = new int[N + 1];
        int[] profits = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            profits[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[W + 1];

        for (int i = 1; i <= N; i++) {
            int w = weights[i];
            int p = profits[i];

            for (int j = W; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + p);
            }
        }

        System.out.println(dp[W]);
    }
}
