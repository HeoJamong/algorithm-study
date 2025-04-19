import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = new boolean[2000001];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num < 0) {
                arr[-(num) + 1000000] = true;
            } else {
                arr[num] = true;
            }
        }

        for (int i = 1000000; i >= 0; i--) {
            if (arr[i]) {
                bw.write(i + "\n");
            }
        }

        for (int i = 1000001; i < 2000001; i++) {
            if (arr[i]) {
                bw.write(-(i - 1000000) + "\n");
            }
        }

        bw.flush();
    }
}
