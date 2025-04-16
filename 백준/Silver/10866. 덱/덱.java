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

        ArrayDeque<Integer> deque = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            } else if (cmd.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            } else if (cmd.equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(deque.pollFirst() + "\n");
                }
            } else if (cmd.equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(deque.pollLast() + "\n");
                }
            } else if (cmd.equals("size")) {
                sb.append(deque.size() + "\n");

            } else if (cmd.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            } else if (cmd.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(deque.peekFirst() + "\n");
                }
            } else if (cmd.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(deque.peekLast() + "\n");
                }
            }
        }

        System.out.print(sb);
    }
}
