import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int MAX_CARD = 20_000_000;
        int PLUS_INDEX = 10_000_000;
        int[] arr = new int[MAX_CARD + 1];

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            arr[num + PLUS_INDEX]++;
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(st.nextToken());
            bw.write(arr[card + PLUS_INDEX] + " ");
        }
        bw.flush();
    }
}
