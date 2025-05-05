import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.getLast() > y) {
                answer++;
                stack.removeLast();
            }

            if (!stack.isEmpty() && stack.getLast() == y) {
                continue;
            }

            stack.addLast(y);
        }

        while (!stack.isEmpty()) {
            if (stack.getLast() > 0) {
                answer++;
            }
            stack.removeLast();
        }

        System.out.println(answer);
    }
}
