import java.util.*;

class Solution {
    // wires를 하나씩 스킵하면서 탐색을 진행해본다(?)
    static int answer = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {

        
        
        for (int i = 0; i < wires.length; i++) {
            
            // 그래프 생성 및 초기화
            List<List<Integer>> graph = new ArrayList<>();
            for (int k = 0; k <= n; k++) {
                graph.add(new ArrayList<>());
            }
            
            for (int z = 0; z < wires.length; z++) {
                if (z == i) {
                    continue;
                }
                graph.get(wires[z][0]).add(wires[z][1]);
                graph.get(wires[z][1]).add(wires[z][0]);
            }
            boolean[] visit = new boolean[n + 1];
            int count = bfs(1, graph, visit);
            int diff = Math.abs((n - count) - count); // 나머지 수에서 첫번째 탐색한 수를 빼면 몇개 차이인지 알 수 있다.
            answer = Math.min(answer, diff);
        } 
        return answer;
    }
    public static int bfs(int start, List<List<Integer>> graph, boolean[] visit) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visit[start] = true;
        int count = 1;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph.get(node)) {
                if (!visit[next]) {
                    visit[next] = true;
                    count++;
                    queue.offer(next);
                }
            }
        }
        return count;
    }
}