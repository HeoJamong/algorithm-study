import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[] isBroken = new int[N + 1];

        for (int i = 0; i < B; i++) {
            int idx = Integer.parseInt(br.readLine());
            isBroken[idx] = 1;
        }

        int[] prefix = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + isBroken[i];
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = K; i <= N; i++) {
            int brokenCount = prefix[i] - prefix[i - K];
            min = Math.min(min, brokenCount);
        }

        System.out.println(min);
    }
}
