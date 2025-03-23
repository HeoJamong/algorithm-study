import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

      int N = Integer.parseInt(br.readLine());

      long[] dp = new long[N+3];

      dp[1] = 1;
      dp[2] = 1;

      for (int i = 3; i <= N; i++){
          dp[i] = dp[i -2] + dp[i - 1];
      }

        System.out.println(dp[N]);
//      bw.flush();
//      bw.close();
    }
}
