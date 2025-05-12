import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 트리맵을 사용하면 정렬, 순서를 알 수 잇으니 맨 앞, 맨 뒤 꺼낼 수 있음, 동일한 값이 입력 가능하므로 set이 아닌 map 사용

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tree = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    tree.put(num, tree.getOrDefault(num, 0) + 1);
                } else {
                    if (num == 1) {
                        if (tree.isEmpty()) {
                            continue;
                        } else if (tree.get(tree.lastKey()) >= 2) {
                            int key = tree.lastKey();
                            int lastValue = tree.get(key);
                            tree.put(key, lastValue - 1);
                        } else {
                            tree.remove(tree.lastKey());
                        }
                    } else {
                        if (tree.isEmpty()) {
                            continue;
                        } else if (tree.get(tree.firstKey()) >= 2) {
                            int key = tree.firstKey();
                            int firstValue = tree.get(key);
                            tree.put(key, firstValue - 1);
                        } else {
                            tree.remove(tree.firstKey());
                        }
                    }
                }
            }
            if (tree.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(tree.lastKey() + " " + tree.firstKey());
            }
        }
    }
}
