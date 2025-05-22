import java.io.*;
import java.util.*;

public class Solution {
    static List<Integer>[] tree;
    static int[] parent;
    static int V, E, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            tree = new ArrayList[V + 1];
            parent = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                tree[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                tree[p].add(c);
                parent[c] = p;
            }

            int lca = findLCA(a, b);
            int size = countSubtreeSize(lca);

            System.out.printf("#%d %d %d\n", t, lca, size);
        }
    }

    static int findLCA(int a, int b) {
        boolean[] visited = new boolean[V + 1];

        while (a != 0) {
            visited[a] = true;
            a = parent[a];
        }

        while (b != 0) {
            if (visited[b]) return b;
            b = parent[b];
        }
        return 1;
    }

    static int countSubtreeSize(int node) {
        int count = 1;
        for (int child : tree[node]) {
            count += countSubtreeSize(child);
        }
        return count;
    }
}
