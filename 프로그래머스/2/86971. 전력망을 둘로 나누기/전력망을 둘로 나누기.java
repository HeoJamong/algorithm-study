import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        for (int i = 0; i < wires.length; i++) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int k =0; k <= n; k++) {
                graph.add(new ArrayList<>());
            }
            
            for (int j = 0; j < wires.length; j++) {
                if (j == i) {
                    continue;
                }
                graph.get(wires[j][0]).add(wires[j][1]);
                graph.get(wires[j][1]).add(wires[j][0]);
            }
            
            boolean[] visit = new boolean[n + 1];
            int count = bfs(1, graph, visit);
            int diff = Math.abs((n - count) - count);
            answer = Math.min(answer, diff);
        }
        return answer;
    }
    
    public static int bfs(int start, List<List<Integer>> graph, boolean[] visit) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visit[start] = true;
        int count = 1;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph.get(node)) {
                if (!visit[next]) {
                    visit[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}