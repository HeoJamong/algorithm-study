import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<String[]> input = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String tmp = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String rank = st.nextToken();
            String str = st.nextToken();
            if (str.equals(tmp)) {
                continue;
            }
            tmp = str;
            input.add(new String[]{rank, str});
        }

        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());
            binarySearch(power);
        }
        bw.flush();
        bw.close();
    }

    public static void binarySearch(int power) throws IOException {
        int left = 0;
        int right = input.size() - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;

            if (Integer.parseInt(input.get(mid)[1]) == power) {
                break;
            }

            if (left == right) {
                if (power > Integer.parseInt(input.get(left)[1])) {
                    mid = left + 1;
                } else {
                    mid = left;
                }
                break;
            }

            if (power > Integer.parseInt(input.get(mid)[1])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        bw.write(input.get(mid)[0] + "\n");
    }
}
