import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10001];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < 10001; i++) {
            while (arr[i]-- > 0) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }

        bw.flush();
    }
}
