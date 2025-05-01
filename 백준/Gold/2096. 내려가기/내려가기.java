import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[][] maxDp = new int[N][3];
        int[][] minDp = new int[N][3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            maxDp[0][i] = minDp[0][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            maxDp[i][0] = a + Math.max(maxDp[i - 1][0], maxDp[i - 1][1]);
            maxDp[i][1] = b + Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]);
            maxDp[i][2] = c + Math.max(maxDp[i - 1][1], maxDp[i - 1][2]);

            minDp[i][0] = a + Math.min(minDp[i - 1][0], minDp[i - 1][1]);
            minDp[i][1] = b + Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]);
            minDp[i][2] = c + Math.min(minDp[i - 1][1], minDp[i - 1][2]);
        }

        int maxResult = Math.max(Math.max(maxDp[N - 1][0], maxDp[N - 1][1]), maxDp[N - 1][2]);
        int minResult = Math.min(Math.min(minDp[N - 1][0], minDp[N - 1][1]), minDp[N - 1][2]);

        System.out.println(maxResult + " " + minResult);
    }
}
