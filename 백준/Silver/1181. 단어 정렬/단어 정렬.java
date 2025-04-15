import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        TreeSet<String> set = new TreeSet<>((a, b) -> {
            int size = a.length() - b.length();
            if (size == 0) {
                return a.compareTo(b);
            }
            return size;
        });

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (String s : set) {
            sb.append(s + "\n");
        }
        System.out.print(sb);
    }
}
