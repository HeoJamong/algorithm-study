import java.util.*;

class Solution {
    static int[] parent;
    
    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void union(int a, int b) {
        int pa =find(a);
        int pb = find(b);
        
        if (pa != pb) parent[pa] = pb;
    }
    
    public int solution(int n, int[][] costs) {
        
        parent = new int[n];
        
        for (int i =0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int total  = 0;
        int edgeCount = 0;
        
        for (int[] edge: costs) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];
            
            // a와 b의 부모가 다름 -> 사이클 아님
            if (find(a) != find (b)) { 
                union(a, b);
                total += cost;
                edgeCount++;
                
                if (edgeCount == n - 1) {
                    break;
                }
            }                
        }  
        return total;
    }
}