import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
            } else if (cmd.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(queue.pollFirst() + "\n");
                }
            } else if (cmd.equals("size")) {
                sb.append(queue.size() + "\n");
            } else if (cmd.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            } else if (cmd.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(queue.peekFirst() + "\n");
                }
            } else if (cmd.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(queue.peekLast() + "\n");
                }
            }
        }

        System.out.print(sb);
    }
}
